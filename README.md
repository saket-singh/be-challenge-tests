# API Test Automation project
API test automation framework created with Java and Rest Assured. You can find the APIs here which have been automated as a part of this project:
`https://jsonplaceholder.typicode.com/`

# Prerequisites
1. Requires JDK version 8 or later to be installed in your system. Gradle uses the JDK libraries which is installed and sets to the JAVA_HOME environmental variable.
2. Gradle should be installed in your system. If not, run
`brew install gradle` to install it using Homebrew.

# Usage
* To execute the tests, go to the root directory of the project and execute the following command:
```$xslt
./gradlew clean RunTests
```
* The request sent, the endpoint and the response returned, all are getting logged to the Reports as well as on the standard output.

# Reporting
* For generating test execution reports, `ReportNg` is being used 
* To see the reports, go to the path `/build/RunTests/html` and open `index.html` in any browser. Click on `Gradle Tests` hyperlink to see more detailed report with the logs.

# CircleCI
The project is integrated with CircleCI for execution in CI environments. Please find the link below:

https://circleci.com/gh/saket-singh/be-challenge-tests
