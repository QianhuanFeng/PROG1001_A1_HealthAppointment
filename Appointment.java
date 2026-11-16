/**
 * Appointment class, implements Comparable<Appointment> for time‑based sorting
 * Student Name: Qianhuan Feng
 * Student ID:25258622
 * System: Health Service Daily Appointment Booking System
 * Link Patient, HealthProfessional and time slot for current‑day booking.
 * Time stored as String "HH:mm". Clinic slot:08:00‑16:00 step 30min.
 */
public class Appointment implements Comparable<Appointment> {
    private Patient patient;
    private HealthProfessional healthProfessional;
    private String timeSlot; // format "HH:mm", example "09:30"
    /**
     * Full constructor of Appointment
     * @param patient patient object reference
     * @param healthProfessional any subclass instance of HealthProfessional
     * @param timeSlot 30‑min slot string HH:mm
     */
    public Appointment(Patient patient, HealthProfessional healthProfessional, String timeSlot) {
        this.patient = patient;
        this.healthProfessional = healthProfessional;
        this.timeSlot = timeSlot;
    }
    // getter methods
    public Patient getPatient() {
        return patient;
    }
    public HealthProfessional getHealthProfessional() {
        return healthProfessional;
    }
    public String getTimeSlot() {
        return timeSlot;
    }
    /**
     * Convert "HH:mm" time string into total minutes for numeric comparison.
     * Helper function for sorting appointments.
     * @return int total minutes since 00:00
     */
    private int timeToMinutes() {
        String[] parts = timeSlot.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        return hour * 60 + minute;
    }
    /**
     * Implement compareTo for Comparable interface, sort by appointment time ascending.
     * @param other another appointment object
     * @return negative, zero or positive integer for ordering
     */
    @Override
    public int compareTo(Appointment other) {
        return Integer.compare(this.timeToMinutes(), other.timeToMinutes());
    }
    /**
     * Override toString for printing full appointment details.
     * @return formatted appointment information
     */
    @Override
    public String toString() {
        return String.format(
            "=== Appointment [Time: %s] ===\n  %s\n  Assigned Health Worker: %s\n",
            timeSlot,
            patient.toString(),
            healthProfessional.toString()
        );
    }
}
