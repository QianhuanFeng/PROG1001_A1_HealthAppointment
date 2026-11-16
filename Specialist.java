/**
 * Specialist extends HealthProfessional
 * Student Name: Qianhuan Feng
 * Student ID:25258622
 * System: Health Service Daily Appointment Booking System
 * Concrete subclass for medical specialist, store specialty field.
 */
import java.util.ArrayList;
public class Specialist extends HealthProfessional {
    private String specialty; // e.g. "Cardiologist", "Paediatric"
    /**
     * Constructor for Specialist
     * @param professionalId numeric id
     * @param fullName specialist name
     * @param workingDays working weekdays
     * @param specialty medical specialty name
     */
    public Specialist(int professionalId, String fullName, ArrayList<String> workingDays, String specialty) {
        super(professionalId, fullName, workingDays);
        this.specialty = specialty;
    }
    @Override
    public String getProfessionalType() {
        return "Specialist";
    }
    public String getSpecialty() {
        return specialty;
    }
    @Override
    public String toString() {
        return super.toString() + " | Specialty: " + specialty;
    }
}
