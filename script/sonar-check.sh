#!/usr/bin/env bash

if [ $# -lt 1 ]; then
    echo "Usage: ${0} <sonar-host-addr-and-port>"
fi

SONAR_HOST="${1}"
SONAR_KEY="microservices-kata:web-bff"

STATUS=$(curl -qsSL "http://${SONAR_HOST}/api/qualitygates/project_status?projectKey=${SONAR_KEY}" |\
    sed 's/.*"projectStatus"[: {]*"status"[: ]*"\([a-zA-Z]*\)".*/\1/')
if [ "${STATUS}" != "OK" ]; then
    echo "代码扫描未通过，请检查 http://${SONAR_HOST}/dashboard?id=${SONAR_KEY} 扫描报告并修复！"
    exit -1
fi
echo "代码扫描完成！"