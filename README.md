CLASSES

It includes two classes,Employee and SecretSantaMatcher.

Employee.java

Employee(String name, String email)- Constructor to initialize an employee with their name and email.

void setSecretChild(String secretChild, String secretChildEmail)- Assigns a Secret Santa recipient to the employee.

String toString()- Returns a string representation of the employee and their assigned Secret Santa.SecretSantaMatcher.java

SecretSantaMatcher

SecretSantaMatcher(String employeesFile, String previousPairsFile) - Constructor that initializes the list of employees and previous Secret Santa pairs from the provided CSV files.Calls loadEmployees and loadPreviousPairs to read data.

List<Employee> loadEmployees(String filePath)- Reads employee names and emails from the provided CSV file and stores them in a list.Each line should be formatted as name,email.

Set<String> loadPreviousPairs(String filePath)- Reads previous Secret Santa pairs from a CSV file.Each entry is stored as a string in the format giverName,giverEmail,receiverName,receiverEmail.

void assignSecretSantas()- Randomly assigns each employee a Secret Santa recipient while ensuring that.They are not assigned themselves.They do not receive a match from the previous years' pairs.If no valid match is found, a message is displayed.

void writeNewPairsToFile(String outputFile)- Saves the newly generated Secret Santa assignments to a CSV file.Each line is written as giverName,giverEmail,receiverName,receiverEmail.


TESTS

testLoadEmployees()

Verifies that employee data is correctly read from the CSV file.

Ensures the correct number of employees is loaded.

testLoadPreviousPairs()

Checks if previous Secret Santa pairs are correctly loaded into a set.

testAssignSecretSantas()

Ensures each employee gets a valid Secret Santa assignment.

Confirms no one is assigned themselves or repeats past pairs.

testWriteNewPairsToFile()

Verifies that new assignments are correctly written to a CSV file.

writeTestFile(String fileName, List<String> lines)

A helper function for creating test CSV files dynamically.

INSTALLATION AND SETUP

Prerequisites

Ensure you have the following installed:

Java 8+

Maven (for dependency management)

JUnit 5 (for running tests)

Steps for running

 Open Eclipse and Import the Project

    Open Eclipse IDE.
    Click on File → Open Projects from File System (or Import → Existing Maven Projects if using Maven).
    Select your SecretSanta project folder.
    Click Finish.

 Set Up the Java Build Path (If Needed)

    Right-click the project in Project Explorer.
    Select Properties → Java Build Path.
    Under the Libraries tab, ensure the JDK and JUnit are included.
    Click Apply and Close.

 Run the Main Class

    Expand the project in Project Explorer.
    Navigate to src/main/java/Input/SecretSantaMatcher.java.
    Right-click SecretSantaMatcher.java → Run As → Java Application.

 Run the Tests

    Expand src/test/java/SecretSantaTest/.
    Right-click SecretSantaTests.java → Run As → JUnit Test.
    Verify test results in the JUnit tab.

View Output Files

    Navigate to the output CSV file (csvdemo2.csv).
    Open it to review the new Secret Santa assignments.

INPUT FILES

csvdemo.csv: Contains the list of current employees (name, email)(*you can replace this files with any you like)

csvdemo1.csv: Contains the list of previous Secret Santa pairs

OUTPUT FILE

csvdemo2.csv: New Secret Santa assignments
