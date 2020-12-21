#### Installation and Setup:

##### Download IDE:
- I am using intelliJ as an IDE on Mac OS.
- Link : https://www.jetbrains.com/idea/download/#section=mac     
- If jdk is not installed on your machine, follow the prompts from the IDE after opening the project (install jdk 1.8 or higher )

##### Import project:
- Pull the repo from gitHub.
- Run the IntelliJ
- Click open project
- Navigate to the folder(ui-tests or api-tests)
- Open pom.file. (this will import the project into IDE)
- Enable [“Import maven projects Automatically”](https://subscription.packtpub.com/book/application_development/9781785286124/2/ch02lvl1sec25/importing-an-existing-maven-project-in-intellij-idea)

#### Run API tests
- Open the file /src/test/java/HopinApiTest.java.
- Click the play button next to the test to run it.

#### Run UI tests 
- Open the file /src/test/java/UITest.java.
- Click the play button next to the test to run it.
- By default the tests are setup to run on Mac OS. If you are running a different OS you should update the line 13 in /src/test/java/UITest.java accordingly.