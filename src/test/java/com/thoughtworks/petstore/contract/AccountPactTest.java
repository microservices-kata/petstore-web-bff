package com.thoughtworks.petstore.contract;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import com.google.common.collect.ImmutableMap;
import io.restassured.RestAssured;
import org.junit.Rule;
import org.junit.Test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.core.IsEqual.equalTo;

public class AccountPactTest {

    private int providerPort = 8083;

    @Rule
    public PactProviderRuleMk2 mockProvider = new PactProviderRuleMk2("account_provider", "localhost", providerPort, this);

    @Pact(consumer = "account_consumer")
    public RequestResponsePact createFragment(PactDslWithProvider builder) {
        return builder
                .given("test state")
                .uponReceiving("get application information")
                .path("/app/info")
                .method("GET")
                .willRespondWith()
                .headers(ImmutableMap.of("Content-Type", "application/json"))
                .status(200)
                .body(new PactDslJsonBody()
                    .stringType("lang", "Scala!"))
                .toPact();
    }

    @Test
    @PactVerification
    public void storeContractTest() {
        RestAssured.port = providerPort;
        get("/app/info").then().body("lang", equalTo("Scala!"));

    }
}
