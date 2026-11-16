/**
 * AssignmentOne main entry point
 * Student Name: Qianhuan Feng
 * Student ID: 25258622
 * System: Health Service Daily Appointment Booking System
 * This class holds main() method for Part‑3 and Part‑6 demonstration.
 * It creates health professional objects, simulates end‑to‑end workflow.
 * Implements loop menu for interactive demonstration, covers success and error test‑cases.
 * GenAI Declaration: I acknowledge that I have not knowingly used GenAI to complete this assessment.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class AssignmentOne {
    /**
     * Print divider for console output formatting
     */
    public static void printDivider() {
        System.out.println("----------------------------------------------------------------------");
    }
    /**
     * Main method, program entry point
     * @param args command‑line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AppointmentManager manager = new AppointmentManager();
        // ========= Part 3: create multiple different‑type health professional objects =========
        ArrayList<String> monWedFri = new ArrayList<>();
        monWedFri.add("Monday");
        monWedFri.add("Wednesday");
        monWedFri.add("Friday");
        ArrayList<String> tueThu = new ArrayList<>();
        tueThu.add("Tuesday");
        tueThu.add("Thursday");
        // create 4 kinds of health professionals
        GeneralPractitioner gp1 = new GeneralPractitioner(1001, "Dr Alice Smith", monWedFri, "GP-7841");
        GeneralPractitioner gp2 = new GeneralPractitioner(1002, "Dr Bob Brown", tueThu, "GP-2233");
        Specialist cardiologist = new Specialist(2001, "Dr Clara Lee", monWedFri, "Cardiology");
        Nurse wardNurse = new Nurse(3001, "Nurse Diana White", tueThu, "Emergency Ward");
        Dietitian diet = new Dietitian(4001, "Ms Eva Green", monWedFri, "Level-3 Qualified");
        ArrayList<HealthProfessional> allProfessionals = new ArrayList<>();
        allProfessionals.add(gp1);
        allProfessionals.add(gp2);
        allProfessionals.add(cardiologist);
        allProfessionals.add(wardNurse);
        allProfessionals.add(diet);
        printDivider();
        System.out.println("Part 3: Display all created health professional details");
        printDivider();
        // Polymorphism: loop abstract superclass type list, call toString() of each subclass
        for(HealthProfessional hp : allProfessionals) {
            System.out.println(hp);
        }
        // Pre‑create sample patients
        Patient p1 = new Patient("Tom Wilson","0411-111-222");
        Patient p2 = new Patient("Lucy Hall","0422-333-444");
        Patient p3 = new Patient("Mike Ross","0433-555-666");
        // Pre‑add sample appointments for demonstration
        Appointment appSample1 = new Appointment(p1, gp1, "09:00");
        Appointment appSample2 = new Appointment(p2, cardiologist, "10:30");
        Appointment appSample3 = new Appointment(p3, wardNurse, "14:00");
        manager.addAppointment(appSample1);
        manager.addAppointment(appSample2);
        manager.addAppointment(appSample3);
        // ========== Main interactive loop system ==========
        boolean running = true;
        while(running) {
            printDivider();
            System.out.println("===== HEALTH APPOINTMENT SYSTEM MENU =====");
            System.out.println("1 → Show all valid time slots");
            System.out.println("2 → Add NEW appointment (manual input patient details)");
            System.out.println("3 → Show ALL appointments sorted by time");
            System.out.println("4 → Filter appointments by health‑professional ID");
            System.out.println("5 → Filter appointments by patient mobile number");
            System.out.println("6 → Cancel appointment by professional ID + time");
            System.out.println("7 → Cancel all appointments for a patient(mobile)");
            System.out.println("8 → Test error‑case: try double‑book same professional same time");
            System.out.println("0 → Exit program");
            System.out.print("Please input menu number: ");
            String input = scanner.nextLine();
            int menuOption;
            try {
                menuOption = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number input, please try again.");
                continue;
            }
            switch (menuOption) {
                case 1:
                    manager.printAllValidTimeSlots();
                    break;
                case 2:
                    // Add new appointment: read data from console input
                    System.out.println("\n--- Create New Appointment ---");
                    System.out.print("Enter patient name: ");
                    String patName = scanner.nextLine();
                    System.out.print("Enter patient mobile number: ");
                    String patMobile = scanner.nextLine();
                    System.out.print("Enter health professional ID: ");
                    String hpIdText = scanner.nextLine();
                    int targetHpId;
                    try {
                        targetHpId = Integer.parseInt(hpIdText);
                    } catch (NumberFormatException e) {
                        System.out.println("ERROR: Professional ID must be integer number.");
                        break;
                    }
                    // Find matching health professional object from our list
                    HealthProfessional selectedHp = null;
                    for(HealthProfessional hp : allProfessionals){
                        if(hp.getProfessionalId() == targetHpId){
                            selectedHp = hp;
                            break;
                        }
                    }
                    if(selectedHp == null){
                        System.out.println("ERROR: Cannot find health professional with this ID.");
                        break;
                    }
                    // Loop: only re‑enter time if validation / duplicate booking fails
                    String selectTime;
                    while(true) {
                        System.out.print("\nValid clinic time slots you can choose: ");
                        manager.printAllValidTimeSlots();
                        System.out.print("Enter time slot (HH:mm e.g 09:30): ");
                        selectTime = scanner.nextLine();
                        Patient inputPatient = new Patient(patName, patMobile);
                        Appointment newUserApp = new Appointment(inputPatient, selectedHp, selectTime);
                        boolean addSuccess = manager.addAppointment(newUserApp);
                        if(addSuccess){
                            break;
                        }else{
                            System.out.println("Please re‑enter a valid time slot.\n");
                        }
                    }
                    break;
                case 3:
                    printDivider();
                    System.out.println("Sorted appointments (earliest first):");
                    List<Appointment> sortedList = manager.getSortedAppointments();
                    for(Appointment ap : sortedList){
                        System.out.println(ap);
                    }
                    break;
                case 4:
                    System.out.print("Input health professional ID for filter: ");
                    String hpIdInput = scanner.nextLine();
                    int hpIdFilter;
                    try{
                        hpIdFilter = Integer.parseInt(hpIdInput);
                    }catch(NumberFormatException e){
                        System.out.println("ERROR: ID must be integer.");
                        break;
                    }
                    List<Appointment> filteredHp = manager.filterByProfessionalId(hpIdFilter);
                    System.out.println("Filter result:");
                    for(Appointment ap : filteredHp) System.out.println(ap);
                    break;
                case 5:
                    System.out.print("Input patient mobile number for filter: ");
                    String mobInput = scanner.nextLine();
                    List<Appointment> filteredMob = manager.filterByPatientMobile(mobInput);
                    System.out.println("Filter result:");
                    for(Appointment ap : filteredMob) System.out.println(ap);
                    break;
                case 6:
                    System.out.print("Input professional ID to cancel:");
                    String delHpText = scanner.nextLine();
                    int delHpId;
                    try{
                        delHpId = Integer.parseInt(delHpText);
                    }catch(NumberFormatException e){
                        System.out.println("ERROR: ID must be integer number.");
                        break;
                    }
                    System.out.print("Input time slot (HH:mm):");
                    String delTime = scanner.nextLine();
                    manager.cancelAppointmentByProIdAndTime(delHpId, delTime);
                    break;
                case 7:
                    System.out.print("Input patient mobile number to cancel all bookings:");
                    String delMob = scanner.nextLine();
                    manager.cancelAppointmentByPatientMobile(delMob);
                    break;
                case 8:
                    // ERROR CASE TEST: double‑book gp1 at 09:00 which already occupied
                    System.out.println("Testing double booking: trying to book ID 1001 at 09:00");
                    Patient conflictPatient = new Patient("Conflict Test Man","0400-000-000");
                    Appointment conflictApp = new Appointment(conflictPatient, gp1, "09:00");
                    manager.addAppointment(conflictApp);
                    break;
                case 0:
                    running = false;
                    System.out.println("Program exit.");
                    break;
                default:
                    System.out.println("Menu option out‑of‑range, choose 0‑8.");
            }
        }
        scanner.close();
    }
}
