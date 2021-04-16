package headFirstDesignPatterns.java.seekers;

import headFirstDesignPatterns.java.clinics.Clinic;

public class AppointmentSeeker implements Observer {
    private boolean hasAppointment;
    private Clinic clinic;

    public AppointmentSeeker(Clinic clinic) {
        this.hasAppointment = false;
        this.clinic = clinic;
        clinic.registerObserver(this);
    }

    public void update() {
//        System.out.println("There's been a change in appointment availability. Let's check it out.");
        if(!hasAppointment()) {
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
        } else {
            System.out.println("There's been a change in appointment availability, but you already have an appointment. Why are you still looking?");
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
