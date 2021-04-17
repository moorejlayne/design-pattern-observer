package headFirstDesignPatterns.java;

import headFirstDesignPatterns.java.clinics.Clinic;
import headFirstDesignPatterns.java.seekers.AppointmentSeeker;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to the COVID Vaccine Scheduler. Good luck!\n");

        Clinic walgreens = new Clinic("Walgreens");
        Clinic cvs = new Clinic("CVS");
        ArrayList<Clinic> clinics = new ArrayList<>(
                Arrays.asList(walgreens, cvs)
        );
        AppointmentSeeker jacob = new AppointmentSeeker(clinics);

        walgreens.setAppointments(new ArrayList<>(
                Arrays.asList(
                        "April 21, 2021 10:00am",
                        "April 24, 2021 03:15pm"
                )
        ));
        cvs.setAppointments(new ArrayList<>(
                Arrays.asList(
                        "April 26, 2021 07:00am",
                        "April 27, 2021 02:45pm"
                )
        ));

        while(!jacob.hasAppointment()) {
            if (Math.random() > 0.5) {
                cvs.addAppointment("Random CVS appointment");
            } else {
                walgreens.addAppointment("Random Walgreens appointment");
            }
        }

    }
}
