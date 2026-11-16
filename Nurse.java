/**
 * Nurse extends HealthProfessional
 * Student Name: Qianhuan Feng
 * Student ID:25258622
 * System: Health Service Daily Appointment Booking System
 * Concrete subclass for Nurse, store ward assignment.
 */
import java.util.ArrayList;
public class Nurse extends HealthProfessional {
    private String assignedWard;
    /**
     * Nurse constructor
     * @param professionalId numeric id
     * @param fullName nurse full name
     * @param workingDays working weekdays
     * @param assignedWard ward name assigned for nurse
     */
    public Nurse(int professionalId, String fullName, ArrayList<String> workingDays, String assignedWard) {
        super(professionalId, fullName, workingDays);
        this.assignedWard = assignedWard;
    }
    @Override
    public String getProfessionalType() {
        return "Nurse";
    }
    public String getAssignedWard() {
        return assignedWard;
    }
    @Override
    public String toString() {
        return super.toString() + " | Assigned Ward: " + assignedWard;
    }
}
