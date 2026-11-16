/**
 * AppointmentManager class
 * Student Name: Qianhuan Feng
 * Student ID:25258622
 * System: Health Service Daily Appointment Booking System
 * Manage collection of daily appointments.
 * Provide add, filter, sort, cancel, duplicate‑booking check.
 * Clinic valid slots 08:00‑16:00 every 30 minutes.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class AppointmentManager {
    private ArrayList<Appointment> appointmentList;
    // define clinic schedule constant, can modify if requirement changed
    public static final String[] VALID_TIME_SLOTS = {
        "08:00","08:30","09:00","09:30","10:00","10:30",
        "11:00","11:30","12:00","12:30","13:00","13:30",
        "14:00","14:30","15:00","15:30","16:00"
    };
    /**
     * Constructor initialise empty appointment storage list
     */
    public AppointmentManager() {
        appointmentList = new ArrayList<>();
    }
    /**
     * Check if input time string belongs to clinic valid 30‑min slots
     * @param timeSlot input time "HH:mm"
     * @return true if valid slot
     */
    public boolean isValidTimeSlot(String timeSlot) {
        for(String slot : VALID_TIME_SLOTS){
            if(slot.equals(timeSlot)){
                return true;
            }
        }
        return false;
    }
    /**
     * Check double‑booking conflict: same professional already has appointment at given time
     * @param hp target health professional
     * @param timeSlot booking time
     * @return true means conflict exists (already booked)
     */
    public boolean checkDuplicateBooking(HealthProfessional hp, String timeSlot) {
        // iterate all stored appointments
        for(Appointment app : appointmentList) {
            // compare professional id and time slot
            if(app.getHealthProfessional().equals(hp) && app.getTimeSlot().equals(timeSlot)){
                return true; // conflict found
            }
        }
        return false;
    }
    /**
     * Try add new appointment. Validate time slot and double‑book conflict.
     * Print warning message for failure.
     * @param newAppointment new appointment instance
     * @return boolean true if add successfully
     */
    public boolean addAppointment(Appointment newAppointment) {
        // validate time slot
        if(!isValidTimeSlot(newAppointment.getTimeSlot())){
            System.out.println("WARNING: Failed to add appointment. Time slot is outside clinic schedule (08:00‑16:00 every 30 min).");
            return false;
        }
        // check double booking conflict
        if(checkDuplicateBooking(newAppointment.getHealthProfessional(), newAppointment.getTimeSlot())){
            System.out.println("WARNING: Failed to add appointment. This health professional is already booked for this time slot.");
            return false;
        }
        // no error, add to collection
        appointmentList.add(newAppointment);
        System.out.println("SUCCESS: New appointment added.");
        return true;
    }
    /**
     * Get filtered list by health professional numeric ID
     * @param targetId professional id
     * @return list of matching appointments
     */
    public List<Appointment> filterByProfessionalId(int targetId) {
        ArrayList<Appointment> result = new ArrayList<>();
        for(Appointment ap : appointmentList) {
            if(ap.getHealthProfessional().getProfessionalId() == targetId){
                result.add(ap);
            }
        }
        return result;
    }
    /**
     * Get filtered list by patient mobile phone number
     * @param mobile patient mobile string
     * @return list of matching appointments
     */
    public List<Appointment> filterByPatientMobile(String mobile) {
        ArrayList<Appointment> result = new ArrayList<>();
        for(Appointment ap : appointmentList) {
            if(ap.getPatient().getMobilePhone().equals(mobile)){
                result.add(ap);
            }
        }
        return result;
    }
    /**
     * Return full appointment list sorted chronologically (earliest time first)
     * @return sorted copy list
     */
    public List<Appointment> getSortedAppointments() {
        ArrayList<Appointment> copyList = new ArrayList<>(appointmentList);
        Collections.sort(copyList); // use Comparable implemented inside Appointment
        return copyList;
    }
    /**
     * Cancel appointment using professional ID + time slot. Print warning if nothing found.
     * @param hpId target health professional id
     * @param timeSlot target time slot string
     * @return boolean true if cancelled
     */
    public boolean cancelAppointmentByProIdAndTime(int hpId, String timeSlot) {
        for(int i=0; i<appointmentList.size(); i++){
            Appointment ap = appointmentList.get(i);
            if(ap.getHealthProfessional().getProfessionalId() == hpId && ap.getTimeSlot().equals(timeSlot)){
                appointmentList.remove(i);
                System.out.println("SUCCESS: Appointment cancelled by professional ID & time slot.");
                return true;
            }
        }
        System.out.println("WARNING: Cannot cancel, matching appointment not found.");
        return false;
    }
    /**
     * Cancel all appointments belong to one patient mobile phone number
     * @param patientMobile patient contact mobile
     * @return boolean true if any appointment removed
     */
    public boolean cancelAppointmentByPatientMobile(String patientMobile) {
        int removeCount = 0;
        for(int i = appointmentList.size()-1; i >=0; i--){
            Appointment ap = appointmentList.get(i);
            if(ap.getPatient().getMobilePhone().equals(patientMobile)){
                appointmentList.remove(i);
                removeCount++;
            }
        }
        if(removeCount > 0){
            System.out.printf("SUCCESS: Removed %d appointment(s) for this patient.%n", removeCount);
            return true;
        }else{
            System.out.println("WARNING: Cannot cancel, no appointment found for this patient mobile.");
            return false;
        }
    }
    /**
     * Print valid clinic time slots for user reference
     */
    public void printAllValidTimeSlots() {
        System.out.println("Valid clinic time slots (08:00‑16:00 every 30 min):");
        for(String s : VALID_TIME_SLOTS){
            System.out.print(s + "  ");
        }
        System.out.println();
    }
    /**
     * Get raw appointment list copy
     * @return ArrayList<Appointment>
     */
    public ArrayList<Appointment> getAppointmentList() {
        return new ArrayList<>(appointmentList);
    }
}
