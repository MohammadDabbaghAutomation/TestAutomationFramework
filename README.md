# TestAutomationFramework
It's a test automation framework incubates both Selenium and REST Assured technologies in Maven/Jave environment for UI and API testing.
It's a hyprid framework which means it's Keywords driven and Data driven.

The components that this framework is consisted of are:
1- TestNG (data-driven framework)
2- Selenium (test automation tool for UI testing)
3- RESTAssured (test automation tool for API testing)
4- Extent Report (open source reporting tool)

Also this frame work relying primarly on the static variables that are listed within 2 classes under tha name of GlobalVariable and APIGlobalVariable, they are intended 
to keep using them across all classes and to be changed/overwritten during the test execution.

The framework has a customized reporting function and it's created as a suite using TestNG, so it has an xml file to be referred to at the pom file and it works like that:
On pom file within the <suiteXmlFiles> we put the location of the reporting function xml file path but to be executed after the main test execution has been done, 
that tells that the execution will be done in 2 shots instead of one, the first shot you have to comment the reporting function tag and keep the test suites, and once the test suites
execution is done then we comment the test suites and uncomment the reporting function, we we do that because the reporting function takes the results from 2 sources
TestNG report and jUnit reports.

In order to get everything executed properly there's a preconditions class it's intended for the reporting and managing reports paths for each suite, it's also created as 
a suite and it has  an xml file and referred to on pom file, so on pom file it should be uncommented always while running test suites and it should be commented along with
all test suites while running the reporting function.
  
The framework has a class called CostomKeywords, it's the class that contains all common functions that are most propably pure java code, like handling datepicker,
generating random values, reading from sheets functions, waiting functions and so on.
  
 
