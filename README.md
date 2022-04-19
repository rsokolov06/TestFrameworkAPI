# ApiFramework

This API test framework contains 3 tests:
- Test basic Pet deletion flow;
- Test User password update;
- Test Order creation.

Technologies:
- Java
- Rest Assured
- Maven
- TestNG
- Apache POI
- Allure Reports

Description:

- The solution has clear directory structure with datamodel corresponding to the information entities, and actions that envoke APIs;
- Parallel execution for the test classes;
- TestNG assertions are used, for return codes as well as to verify the correctness of data;
- RetryAnalyser is inherited from the TestNG framework.

Execution:

To launch test suite: "**mvn clean test**";
To launch Allure reports: "**allure serve .\target\allure-results**".

Improvements:

- Consolidate all the API URLs in one class so to externalize date and support Data Driven Automation;
- Add support for error codes returned by APIs.
