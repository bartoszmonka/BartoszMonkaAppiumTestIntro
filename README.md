# Appium Android Test Automation Framework

This is a comprehensive Appium-based test automation framework for Android applications, specifically designed to test the SauceLabs Demo App. The framework uses Java, Maven, JUnit 5, and Allure reporting to provide robust end-to-end testing capabilities.

## Table of Contents
- [Prerequisites](#prerequisites)
- [Project Setup](#project-setup)
- [Demo Application Setup](#demo-application-setup)
- [Appium Server Configuration](#appium-server-configuration)
- [Running Tests](#running-tests)
- [Allure Reporting](#allure-reporting)
- [Project Structure](#project-structure)
- [Technical Stack](#technical-stack)

## Prerequisites

Before setting up the project, ensure you have the following installed:

- **Java 21** or higher
- **Maven 3.6+**
- **Android Studio** (latest version)
- **IntelliJ IDEA** (latest version)
- **Node.js** (for Appium)
- **Appium** 
- **Android SDK** and **Android Emulator** or physical Android device
- **Git**

## Project Setup

### 1. Prepare Android Studio
1. Download and install Android Studio from the official website
2. Set up Android SDK and create an Android Virtual Device (AVD)
3. Ensure the emulator is working properly

### 2. Clone the Project
```bash
https://github.com/bartoszmonka/BartoszMonkaAppiumTestIntro.git
```

### 3. Install Dependencies
```bash
mvn clean install
```

## Demo Application Setup

### Download and Install the Demo App
1. Clone the SauceLabs demo application:
```bash
git clone https://github.com/saucelabs/my-demo-app-android
```
2. Open the project in Android Studio
3. Build and run the application on your emulator or physical device
4. Ensure the app is successfully installed and running

## Appium Server Configuration

### 1. Install Appium
```bash
npm install -g appium
```

### 2. Start Appium Server
Open command prompt/terminal and run:
```bash
appium
```

### 3. Verify Appium Server URL
After starting Appium, check the server URL in the console output. By default, it should be:
```
http://127.0.0.1:4723
```

### 4. *IF NEEDED Configure Test Base URL
In the `TestBase.java` file, update the URL if needed:
```java
URL url = URI.create("http://xxx.x.x.x:4723").toURL();
```
Replace `xxx.x.x.x` with your actual Appium server IP address (usually `127.0.0.1` for local setup).

## Running Tests

### Option 1: Run Tests via IDE
1. Open the project in your preferred IDE (IntelliJ IDEA, Eclipse, etc.)
2. Navigate to the test classes in `src/test/java/tests/`
3. Right-click on the test class or method and select "Run"

### Option 2: Run Tests via Maven Command Line
Execute the following command in the project root directory (where `pom.xml` is located):

```bash
mvn clean test
```

This command will:
- Clean the previous build artifacts
- Compile the test classes
- Execute all tests
- Generate test reports

## Allure Reporting

### Generate Allure Report
After running tests, generate the Allure report using:

```bash
mvn allure:report
```

**Important:** Execute this command in the same directory where the `pom.xml` file is located.

### View Allure Report
1. After generating the report, navigate to:
```
BartoszMonkaAppiumTestIntro\target\site\allure-maven-plugin\
```

2. Open `index.html` in your web browser to view the detailed test report

The Allure report provides:
- Test execution summary
- Detailed test steps with screenshots
- Test history and trends
- Failed test analysis
- Performance metrics

## Project Structure

```
BartoszMonkaAppiumTestIntro/
├── src/
│   ├── main/
│   │   └── resources/
│   │       └── log4j2.xml                 # Logging configuration
│   └── test/
│       └── java/
│           ├── screen/                    # Page Object Model classes
│           │   ├── CheckoutCompleteScreen.java
│           │   ├── EnterPaymentMethodScreen.java
│           │   ├── EnterShippingAddressScreen.java
│           │   ├── HeaderVidget.java
│           │   ├── LoginScreen.java
│           │   ├── MyCartScreen.java
│           │   ├── ProductDetailsScreen.java
│           │   ├── ProductsScreen.java
│           │   └── ReviewYourOrderScreen.java
│           ├── tests/                     # Test classes
│           │   ├── CompleteOrderProcessTests.java
│           │   └── TestBase.java          # Base test configuration
│           └── utils/                     # Utility classes
│               └── RetryAnalyzer.java     # Test retry mechanism
├── target/                                # Build artifacts and reports
├── pom.xml                               # Maven configuration
└── README.md                             # This file
```

## Technical Stack

- **Java** - Programming language
- **Maven** - Build and dependency management
- **Appium** - Mobile automation framework
- **Selenium WebDriver** - Web automation library
- **JUnit** - Testing framework
- **Allure** - Test reporting framework
- **Log4j2** - Logging framework
- **Page Object Model** - Design pattern for maintainable tests

## Test Features

### Complete E-commerce Checkout Flow
The framework includes a comprehensive end-to-end test that validates:
1. Product selection and addition to cart
2. Shopping cart verification
3. User authentication
4. Shipping address entry
5. Payment method configuration
6. Order review and confirmation
7. Order completion

### Test Retry Mechanism
The framework includes an intelligent test retry system that:
- Automatically retries failed tests up to 2 times
- Resets application navigation state before each retry attempt
- Provides detailed logging of retry attempts and outcomes
- Uses JUnit 5 extension mechanism for seamless integration

### Allure Integration
- Detailed step-by-step reporting
- Test severity levels
- Test management system integration

## Configuration

### TestBase Configuration
The `TestBase.java` class provides:
- AndroidDriver initialization
- UiAutomator2 options configuration
- WebDriverWait setup
- Logging configuration
- Test lifecycle management (@BeforeEach, @AfterEach)

### Logging
The framework uses Log4j2 for comprehensive logging. Logs help in:
- Debugging test failures
- Tracking test execution flow
- Performance monitoring

## Troubleshooting

### Common Issues
1. **Appium server not starting**: Ensure Node.js and Appium are properly installed
2. **Device not detected**: Check Android SDK configuration and device connection
3. **Tests failing**: Verify the demo app is installed and running on the target device
4. **Report generation fails**: Ensure Maven and all dependencies are properly configured

### Support
For issues and questions, please refer to the project documentation or create an issue in the repository.

---

**Author**: Bartosz Monka  
**Version**: 1.3  
**Last Updated**: 11.09.2025
