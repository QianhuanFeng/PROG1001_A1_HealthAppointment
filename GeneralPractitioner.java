/**
 * GeneralPractitioner extends HealthProfessional
 * Student Name: Qianhuan Feng
 * Student ID: 25258622
 * System: Health Service Daily Appointment Booking System
 * Concrete subclass for General Practitioner (GP).
 * Stores GP‑specific extra field: registrationNumber.
 */
import java.util.ArrayList;
public class GeneralPractitioner extends HealthProfessional {
    private String registrationNumber; // GP unique medical registration number
    /**
     * Constructor for GeneralPractitioner
     * @param professionalId numeric id
     * @param fullName practitioner name
     * @param workingDays list of work days
     * @param registrationNumber medical registration number unique for GP
     */
    public GeneralPractitioner(int professionalId, String fullName, ArrayList<String> workingDays, String registrationNumber) {
        super(professionalId, fullName, workingDays); // call parent constructor
        this.registrationNumber = registrationNumber;
    }
    /**
     * Implement abstract method from parent HealthProfessional
     * @return "General Practitioner"
     */
    @Override
    public String getProfessionalType() {
        return "General Practitioner";
    }
    /**
     * Get GP registration number
     * @return registrationNumber string
     */
    public String getRegistrationNumber() {
        return registrationNumber;
    }
    /**
     * Override toString to add subclass‑specific information
     * @return formatted detail string
     */
    @Override
    public String toString() {
        return super.toString() + " | GP Registration No:" + registrationNumber;
    }
}
