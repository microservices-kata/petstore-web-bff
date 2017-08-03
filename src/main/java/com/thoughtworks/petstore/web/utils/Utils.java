package com.thoughtworks.petstore.web.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Utils {
    private static final Logger log = LoggerFactory.getLogger(Utils.class);

    private Utils() {
        // Prevent instantiate this class
    }

    public static Map<String, Object> introspect(Object obj) {
        Map<String, Object> result = new HashMap<>();
        try {
            BeanInfo info = Introspector.getBeanInfo(obj.getClass());
            for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
                Method reader = pd.getReadMethod();
                if (reader != null && !pd.getName().equals("class"))
                    result.put(pd.getName(), reader.invoke(obj));
            }
        } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
            log.error("Fail to convert object to map", e);
        }
        return result;
    }

}
