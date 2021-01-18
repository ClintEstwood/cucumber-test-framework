# How to run

Add new **TestNG** runner in Intellij IDEA:

* class: core.runners.RunCucumberTest
* VM options: -ea -Dtestng.dtd.http=true
* Working directory: $MODULE_WORKING_DIR$
* JRE: Default (15)
* Shorten command line: user-local default: none

![Runner screenshot](https://github.com/ClintEstwood/cucumber-test-framework/blob/master/runner.jpeg)

Add Lombok plugin
![lombok plugin screenshot](https://github.com/ClintEstwood/cucumber-test-framework/blob/master/lombok.jpeg)

# How to see reports

1. Run test (or tests)
2. On Run window scroll to the text 'View your Cucumber Report at:'

![Where is report's link screenshot](https://github.com/ClintEstwood/cucumber-test-framework/blob/master/report.jpeg)

Report looks like this:

![Report example screenshot](https://github.com/ClintEstwood/cucumber-test-framework/blob/master/report_example.jpeg)

# Todo list:

1. Add universal steps like 'I click on {string} element on page {pageLabel}
2. Add Allure report with screenshots, history, graphs etc
3. Run tests via Maven
4. Add Jenkins support
5. Add multibrowser support
6. Add test running in parallel 
