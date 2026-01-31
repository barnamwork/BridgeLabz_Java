package objectModelingClassDiagram;
/*
 * HospitalDoctorPatient
 * -------------------------
 * Demonstrates Association and Communication
 * between Doctor and Patient through consultation.
 */

/* Patient class */
class Patient {

    // Patient name
    private String name;

    // Constructor to initialize patient
    public Patient(String name) {
        this.name = name;
    }

    // Returns patient name
    public String getName() {
        return name;
    }
}

/* Doctor class */
class Doctor {

    // Doctor name
    private String name;

    // Constructor to initialize doctor
    public Doctor(String name) {
        this.name = name;
    }

    // Doctor consults a patient (Communication)
    public void consult(Patient patient) {
        System.out.println("Doctor " + name + " is consulting patient " + patient.getName());
    }
}

/* Hospital class */
class Hospital {

    // Hospital name
    private String name;

    // Constructor to initialize hospital
    public Hospital(String name) {
        this.name = name;
    }
}

/* Main class */
public class HospitalDoctorPatient {

    public static void main(String[] args) {

        Doctor d1 = new Doctor("Dr. Mehta");
        Patient p1 = new Patient("Rohit");
        Patient p2 = new Patient("Sita");

        d1.consult(p1);
        d1.consult(p2);
    }
}
