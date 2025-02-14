package Input;

public class Employee {
    private String name;
    private String email;
    private String secretChild;
    private String secretChildEmail;

    public Employee(String name, String email) {
        this.name = name;
        this.email = email;
        this.secretChild = null;
        this.secretChildEmail = null;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getSecretChild() {
        return secretChild;
    }

    public String getSecretChildEmail() {
        return secretChildEmail;
    }

    public void setSecretChild(String secretChild, String secretChildEmail) {
        this.secretChild = secretChild;
        this.secretChildEmail = secretChildEmail;
    }

    @Override
    public String toString() {
        return name + "," + email + "," + secretChild + "," + secretChildEmail;
    }
}
