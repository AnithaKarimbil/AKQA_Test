
Running the test :

1. Import the project to Eclipse IDE from the github https://github.com/AnithaKarimbil/AKQA_Test

2. Under the excel folder, open seleniumdata.xls. Update the desired values for Browser, url and SearchItem. Save and close.

3. Right Click on the project , Run As Maven Test.


About the framework:

1.The framework has Maven as the build tool and added dependencies for Selenium, TestNG and jxl in it

2.The excel file from which the input data is read is located in the excel folder in the project. Edit the Browser to Chrome or Firefox and url to the environment under test. Specify the keyword to search.

3. To run, Use Run as Maven Test.(This will download all the dependency jars)
Note I used Eclipse IDE .(If you get an error about no compiler found -  go to Windows->Preferences->Installed jres -point to jdk and update execution environment).

4.Reports are located in test output folder.

5.The framework uses Page Object Model. All page classes are defined under package com.bunnnings.Pages in main java

6.The testcase is under test java-AKQA_Test. The test makes use of TestNG and has 2 parts. BeforeTest, AfterTest and Test. @Test contains the testcase, @BeforeTest contains initialization and @AfterTest contains teardown method.

7. When the TestCase id run, Maven surefire plugin picks the classname of the test from testing.xml

Project structure :

	- AKQA_Test
		|
		- src/main/java
			|
			- com.bunnings.Pages
				|
				- HomePage.java - Contains functions used in the Home page
				|
				- InitializeDriver.java - Initializes the Selenium webdriver
				|
				- ProducPage.java - Contains functions used in the Product page
				|
				- WishList.java - Contains functions used in the Wishlist page
		|
		- src/test/java	
			|
			- AKQA_Test.AKQA_Test
				|
				- BunningsWishListTest.java - Test code for evaluating Wishlist tescase
		|
		- Drivers
			|
			- Includes Chrome and Firefox web drivers
		|
		- Excel
			|
			- seleniumdata.xls - Contains data that is used as input for the testcase. Configure the Environment, URL(test environment), and search item in this sheet
		|
		- test-output - will generate the result
		|
		- pom.xml - Contains the details of the dependencies
		|
		- testng.xml - Defines the testcases executed
		
Possible Improvements :

Connect to Jenkins as a CI/CD tool and initiate email triggers after test run.
			




