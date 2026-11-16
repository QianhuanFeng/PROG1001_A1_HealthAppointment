/**
 * Patient class
 * Student Name: Qianhuan Feng
 * Student ID:25258622
 * System: Health Service Daily Appointment Booking System
 * Store patient basic information: name and mobile phone number.
 */
public class Patient {
    private String patientName;
    private String mobilePhone;
    /**
     * Patient constructor
     * @param patientName name of patient
     * @param mobilePhone mobile contact number
     */
    public Patient(String patientName, String mobilePhone) {
        this.patientName = patientName;
        this.mobilePhone = mobilePhone;
    }
    public String getPatientName() {
        return patientName;
    }
    public String getMobilePhone() {
        return mobilePhone;
    }
    @Override
    public String toString() {
        return "Patient { Name:" + patientName + ", Mobile:" + mobilePhone + " }";
    }
}
