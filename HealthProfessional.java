/**
 * Abstract class HealthProfessional
 * Student Name: Qianhuan Feng
 * Student ID: 25258622
 * System: Health Service Daily Appointment Booking System
 * This abstract base class stores common data and behaviours for all health professionals.
 * Cannot be directly instantiated. Subclasses must implement getProfessionalType().
 * Part‑1 requirement: id(numeric only), name, workingDays.
 */
import java.util.ArrayList;
public abstract class HealthProfessional {
    // private fields for encapsulation
    private int professionalId;         // numeric‑only ID
    private String fullName;            // full name of health worker
    private ArrayList<String> workingDays; // e.g. "Monday", "Wednesday"
    /**
     * Full parameter constructor for HealthProfessional
     * @param professionalId numeric unique identifier
     * @param fullName full name of professional
     * @param workingDays list of working weekdays
     */
    public HealthProfessional(int professionalId, String fullName, ArrayList<String> workingDays) {
        this.professionalId = professionalId;
        this.fullName = fullName;
        this.workingDays = workingDays;
    }
    /**
     * Abstract method to return type name of health professional.
     * Every concrete subclass must override this method.
     * @return String professional type name
     */
    public abstract String getProfessionalType();
    // getter methods for controlled read‑only access (encapsulation)
    /**
     * Get professional unique numeric id
     * @return int id
     */
    public int getProfessionalId() {
        return professionalId;
    }
    /**
     * Get full name
     * @return String full name
     */
    public String getFullName() {
        return fullName;
    }
    /**
     * Get list of working weekdays
     * @return ArrayList<String> workingDays
     */
    public ArrayList<String> getWorkingDays() {
        return workingDays;
    }
    /**
     * Override equals: compare by professionalId only
     * @param o object to compare
     * @return boolean true if same id
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HealthProfessional that = (HealthProfessional) o;
        return professionalId == that.professionalId;
    }
    /**
     * Override hashCode match equals()
     * @return int hash
     */
    @Override
    public int hashCode() {
        return Integer.hashCode(professionalId);
    }
    /**
     * Override toString for readable print output
     * @return formatted string with all details
     */
    @Override
    public String toString() {
        return String.format(
            "[%s] ID:%d | Name:%s | Working Days:%s",
            getProfessionalType(),
            professionalId,
            fullName,
            workingDays
        );
    }
}
