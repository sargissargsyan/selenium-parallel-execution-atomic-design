# Selenium Framework: Atomic Design with Parallel Execution

# Overview
This repository contains a Java-based framework for UI testing, showcasing dynamic test data generation techniques. 
Designed for efficiency and clarity in automated testing, it incorporates key principles like faster execution, 
higher stability, easier maintenance, test isolation, and enhanced reusability.


# Framework Details  
- **Programming Language:** Java
- **Test Runner:** TestNG
- **Build Tool:** Maven
- **Design Pattern:** Page Object Model

# Libraries Used

- **OkHttp:** For handling HTTP requests.
- **Gson:** To manage JSON data.
- **WebDriverManager:** Simplifies WebDriver setup.
- **Lombok:** To reduce boilerplate code.
- **log4j:** For logging capabilities.
- **Allure Reporting:** For enhanced test reporting.

# Getting Started
1. Clone the repo using below URL

```sh
git clone https://github.com/sargissargsyan/selenium-parallel-execution-atomic-design.git
```

2. Navigate to folder:

```sh
cd selenium-parallel-execution-atomic-design
```

3. Build the project
```sh
mvn clean install -DskipTests
```

4. Run tests
```sh
mvn verify
```

5. Generate Allure Report
```sh
allure serve allure-results 
```

The framework is created with Taiga.io example. To be able to run this suite you will need to deploy [Taiga.io locally](https://github.com/kaleidos-ventures/taiga-docker).
Don't forget to set  `PUBLIC_REGISTER_ENABLED: "True"` for `taiga-back` and `taiga-front` services.
