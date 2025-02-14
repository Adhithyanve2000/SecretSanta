package SecretSantaTest;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import Input.SecretSantaMatcher;
import Input.Employee;

public class SecretSantaTests {




	    @Test
	    void testLoadEmployees() throws IOException {
	        String testFile = "C:\\\\Users\\\\adith\\\\OneDrive\\\\Desktop\\\\csvdemo.csv";
	        writeTestFile(testFile, List.of(
	            "Alice Smith, alice@company.com",
	            "Bob Johnson, bob@company.com"
	        ));

	        SecretSantaMatcher matcher = new SecretSantaMatcher(testFile, "C:\\\\Users\\\\adith\\\\OneDrive\\\\Desktop\\\\csvdemo1.csv");
	        assertEquals(2, matcher.employees.size());
	        assertEquals("Alice Smith", matcher.employees.get(0).getName());
	        assertEquals("alice@company.com", matcher.employees.get(0).getEmail());
	    }

	    @Test
	    void testLoadPreviousPairs() throws IOException {
	        String testFile = "C:\\\\Users\\\\adith\\\\OneDrive\\\\Desktop\\\\csvdemo1.csv";
	        writeTestFile(testFile, List.of(
	            "Alice Smith,alice@company.com,Bob Johnson,bob@company.com"
	        ));

	        SecretSantaMatcher matcher = new SecretSantaMatcher("test_employees.csv", testFile);
	        assertTrue(matcher.previousPairs.contains("Alice Smith,alice@company.com,Bob Johnson,bob@company.com"));
	    }

	    @Test
	    void testAssignSecretSantas() throws IOException {
	        String testFile = "C:\\\\Users\\\\adith\\\\OneDrive\\\\Desktop\\\\csvdemo.csv";
	        writeTestFile(testFile, List.of(
	            "Alice Smith, alice@company.com",
	            "Bob Johnson, bob@company.com",
	            "Charlie Davis, charlie@company.com"
	        ));

	        SecretSantaMatcher matcher = new SecretSantaMatcher(testFile, "C:\\\\Users\\\\adith\\\\OneDrive\\\\Desktop\\\\csvdemo.csv");
	        matcher.assignSecretSantas();

	        assertEquals(3, matcher.employees.size());
	        for (Employee e : matcher.employees) {
	            assertNotNull(e.getSecretChild());
	            assertNotNull(e.getSecretChildEmail());
	            assertNotEquals(e.getEmail(), e.getSecretChildEmail());
	        }
	    }

	    @Test
	    void testWriteNewPairsToFile() throws IOException {
	        String testFile = "C:\\\\Users\\\\adith\\\\OneDrive\\\\Desktop\\\\csvdemo2.csv";
	        SecretSantaMatcher matcher = new SecretSantaMatcher("C:\\\\Users\\\\adith\\\\OneDrive\\\\Desktop\\\\csvdemo.csv", "C:\\\\Users\\\\adith\\\\OneDrive\\\\Desktop\\\\csvdemo1.csv");
	        matcher.assignSecretSantas();
	        matcher.writeNewPairsToFile(testFile);

	        File file = new File(testFile);
	        assertTrue(file.exists());
	    }

	    private void writeTestFile(String fileName, List<String> lines) throws IOException {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
	            for (String line : lines) {
	                writer.write(line);
	                writer.newLine();
	            }
	        }
	    }
	}