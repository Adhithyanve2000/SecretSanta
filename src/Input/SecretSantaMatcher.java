package Input;
import java.io.*;
import java.util.*;

public class SecretSantaMatcher {
    public List<Employee> employees;
    public Set<String> previousPairs;

    public SecretSantaMatcher(String employeesFile, String previousPairsFile) {
        this.employees = new ArrayList<>();
        this.previousPairs = new HashSet<>();

        try {
            this.employees = loadEmployees(employeesFile);
            this.previousPairs = loadPreviousPairs(previousPairsFile);
        } catch (IOException e) {
            System.err.println("Error reading files: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private List<Employee> loadEmployees(String filePath) throws IOException {
        List<Employee> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2) {
                    list.add(new Employee(data[0].trim(), data[1].trim()));
                }
            }
        }
        return list;
    }

    private Set<String> loadPreviousPairs(String filePath) throws IOException {
        Set<String> set = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                set.add(line.trim());
            }
        }
        return set;
    }

    public void assignSecretSantas() {
        List<Employee> availableReceivers = new ArrayList<>(employees);
        Collections.shuffle(availableReceivers);

        for (Employee giver : employees) {
            boolean assigned = false;
            for (Iterator<Employee> iterator = availableReceivers.iterator(); iterator.hasNext(); ) {
                Employee receiver = iterator.next();
                String pair = giver.getName() + "," + giver.getEmail() + "," + receiver.getName() + "," + receiver.getEmail();

                if (!giver.getEmail().equals(receiver.getEmail()) && !previousPairs.contains(pair)) {
                    giver.setSecretChild(receiver.getName(), receiver.getEmail());
                    iterator.remove();
                    assigned = true;
                    previousPairs.add(pair);
                    break;
                }
            }

            if (!assigned) {
                System.out.println("Could not find a valid match for " + giver.getName());
            }
        }
    }

    public void writeNewPairsToFile(String outputFile) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            for (Employee e : employees) {
                if (e.getSecretChild() != null) {
                    bw.write(e.toString());
                    bw.newLine();
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            SecretSantaMatcher matcher = new SecretSantaMatcher("C:\\Users\\adith\\OneDrive\\Desktop\\csvdemo.csv", "C:\\Users\\adith\\OneDrive\\Desktop\\csvdemo1.csv");
            matcher.assignSecretSantas();
            matcher.writeNewPairsToFile("C:\\Users\\adith\\OneDrive\\Desktop\\csvdemo2.csv");
            System.out.println("New Secret Santa assignments saved!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
