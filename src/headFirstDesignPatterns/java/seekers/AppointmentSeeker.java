package headFirstDesignPatterns.java.seekers;

import headFirstDesignPatterns.java.clinics.Clinic;

import java.util.ArrayList;

public class AppointmentSeeker implements Observer {
    private boolean hasAppointment;
    private ArrayList<Clinic> clinics;

    public AppointmentSeeker(ArrayList<Clinic> clinics) {
        this.hasAppointment = false;
        this.clinics = clinics;
        this.clinics.forEach(clinic -> clinic.registerObserver(this));
    }

    public void update(String clinicName) {
        Clinic clinic = clinics.stream().filter(clinicInList -> clinicInList.getClinicName().equals(clinicName)).findFirst().get();
        if(!hasAppointment()) {
            System.out.println("Checking appointments at " + clinic.getClinicName() + "...");
            if (clinic.hasAppointments()) {
                System.out.println("Appointments available!! Attempting to signup.");
                String appointment = clinic.getAppointments().get(0);
                attemptSignUp();
                if (hasAppointment()) {
                    System.out.println("Signup successful!");
                } else {
                    System.out.println("Someone registered before you. Sorry!");

                }
                clinic.removeAppointment(appointment);
            } else {
                System.out.println("No appointments available. :(");
            }
        }
    }

    private void attemptSignUp() {
        boolean gotLucky = Math.random() < 0.1;
        if (gotLucky) {
            this.hasAppointment = true;
        }
    }

    public boolean hasAppointment() {
        return this.hasAppointment;
    }
}
