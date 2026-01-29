package keywords;

/**
 * The Patient class represents a patient with static hospital name and patient count, private fields, and final patient ID.
 * It demonstrates static, private, final keywords, and instanceof operator.
 */
class Patient {
    public static String hospitalName = "AIIMS";
    private static int totalPatients = 0;

    private String name;
    private int age;
    private String ailment;
    private final String patientID;

    Patient(String name, int age, String ailment, String patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;
    }

    // Static method to get total number of patients
    public static int getTotalPatients() {
        return totalPatients;
    }

    // Method to display patient details
    public void displayDetails() {
        System.out.println("Hospital: " + hospitalName);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Ailment: " + ailment);
        System.out.println("Patient ID: " + patientID);
        System.out.println();
    }
}

/**
 * The HospitalManagement class demonstrates hospital patient management using various Java keywords.
 */
public class HospitalManagement {
    public static void main(String[] args) {
        Patient p1 = new Patient("Yash", 25, "Fever", "P001");
        Patient p2 = new Patient("Himanshu", 30, "Cold", "P002");

        if (p1 instanceof Patient) {
            p1.displayDetails();
        }

        if (p2 instanceof Patient) {
            p2.displayDetails();
        }

        System.out.println("Total Patients: " + Patient.getTotalPatients());
    }
}