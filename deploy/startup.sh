#!/usr/bin/env bash

cd ${0%/*}

export VTS_STORE_FILE=./data/vts.data
export VTS_MARSBOX_REPORT_URL_PREFIX=http://xcx.yunzujia.com.cn/deviceservice/devicereport
export SERVER_PORT=8889

java -jar vts.jar > out.log 2>&1 &
