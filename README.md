# Automation for demoqa.com

### Tools:

#### Java, SerenityBDD, Serenity-Ensure, Cucumber, ScreenPlay

#### jdk_11_0_15

### Data Base

- com.demoqa.utils.db.mysql are the connection to database using springboot and java.SQL

### Bugs 

- Date and time section does not work correctly. It only selects the month and the day but does not select the year or the hour

### Init

#### You must to have gradle and jdk_11_0_15 >

> git clone https://github.com/edwincneira/prueba-tecnica-habi

> branch main 

#### Run

> gradle clean test -Pdriver=chrome

##### Or IntelliJ (Editor code...) Run the File CucumberTestSuite.java

## See the report Serenity on the folder file /target/site/serenity/index.html

### Pipeline with Jenkins


- Contruccion
