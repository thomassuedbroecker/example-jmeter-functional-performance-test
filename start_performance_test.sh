#!/bin/bash

source ./.env

export TESTPLAN="performance-single.jmx"
export TEST_DATE="$(date +'%F_%H_%M_%S')"
export TEST_RESULTS="${TEST_DATE}_test_results.csv"

export RESULTS_HOME="./results"
export _RESULTS_CSV_PATH="$(pwd)/results/${PATH_TO_HTML_RESULTS}/${TEST_DATE}_custom_test_results.csv"

export PATH_TO_HTML_RESULTS="${TEST_DATE}_html_results_performace_test"
export JMETER_PROPERTIES_BACKUP="./user_backup.properties"
export JMETER_CUSTOM_PROPERTIES="./example-user-properties-file-jmeter.properties"
export JMETER_PROPERTIES="/usr/local/Cellar/jmeter/5.6.2/libexec/bin/user.properties"

mkdir ${RESULTS_HOME}/${PATH_TO_HTML_RESULTS}

echo "************************************"
echo "         JMeter performance test"
echo "************************************"

echo "JMeter: Change configuration"
cat ${JMETER_PROPERTIES} > ${JMETER_PROPERTIES_BACKUP}
cat ${JMETER_CUSTOM_PROPERTIES} > ${JMETER_PROPERTIES}
#cat  ${JMETER_PROPERTIES}
echo ""
echo "JMeter: Start test"
jmeter -n -t ${TESTPLAN} -l ${RESULTS_HOME}/${TEST_RESULTS} -e -o ${RESULTS_HOME}/${PATH_TO_HTML_RESULTS}
echo "JMeter: open results"
open ${RESULTS_HOME}/${PATH_TO_HTML_RESULTS}/index.html