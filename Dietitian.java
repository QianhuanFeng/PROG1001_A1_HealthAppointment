/**
 * Dietitian extends HealthProfessional
 * Student Name: Qianhuan Feng
 * Student ID:25258622
 * System: Health Service Daily Appointment Booking System
 * Concrete subclass for dietitian health worker.
 */
import java.util.ArrayList;
public class Dietitian extends HealthProfessional {
    private String certificationLevel;
    /**
     * Dietitian constructor
     * @param professionalId numeric id
     * @param fullName dietitian full name
     * @param workingDays working weekdays
     * @param certificationLevel qualification level
     */
    public Dietitian(int professionalId, String fullName, ArrayList<String> workingDays, String certificationLevel) {
        super(professionalId, fullName, workingDays);
        this.certificationLevel = certificationLevel;
    }
    @Override
    public String getProfessionalType() {
        return "Dietitian";
    }
    public String getCertificationLevel() {
        return certificationLevel;
    }
    @Override
    public String toString() {
        return super.toString() + " | Certification Level: " + certificationLevel;
    }
}
