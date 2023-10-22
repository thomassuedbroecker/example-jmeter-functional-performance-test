# Example `JMeter` functional performance test plan

This project contains an `example functional performance test` using [`JMeter`](https://jmeter.apache.org/).

The reason to call this example a **Functional Performance Test Plan** is that we are not verifying the performance of a working System Under Test with a focus on the response times. We also demonstrate that System Under Test works functionally and delivers the correct response content values. Therefore, we also enable Functional Test Mode (i.e. save Response Data and Sampler Data) for the Test Plan.

![](/images/01-jmeter-save-functional-response-vales.png)

These are the main sections of the project. You can use this project as a starting point and optimize it.

1. [Installation of JMeter](/documentation/01-installation.md)
2. [Structure of the `Test Plan` and its elements in JMeter for the `example functional performance test`.](/documentation/02-basic-structure-of-JMeter.md)
3. [The example functional performance test and the test execution](/documentation/03-functional-performance-test-example.md)

### Additional resources

* [REST API Load performance testing using Apache JMeter](https://medium.com/javarevisited/rest-api-load-performance-testing-using-apache-jmeter-63605572e862)
* [Handle JSON in `Groovy`](https://docs.groovy-lang.org/next/html/gapi/groovy/json/JsonSlurper.html)
* [Configure HTML Report details (german)](https://www.proficom.de/blog/lasttestauswertung-html-report-und-custom-graphs-in-jmeter/)
