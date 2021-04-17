package headFirstDesignPatterns.java.clinics;

import headFirstDesignPatterns.java.seekers.Observer;
import java.util.ArrayList;

public class Clinic implements Subject {
    private String clinicName;
    private ArrayList<String> appointments;
    private ArrayList<Observer> observers;
    private boolean hasAppointments;

    public Clinic() {
        appointments = new ArrayList<>();
        hasAppointments = false;
        observers = new ArrayList<>();
    }

    public Clinic(String clinicName) {
        this();
        this.clinicName = clinicName;
    }

    public Clinic(String clinicName, ArrayList<String> appointments) {
        this.clinicName = clinicName;
        this.appointments = appointments;
        this.hasAppointments = appointments.size() >= 1;
        this.observers = new ArrayList<>();
    }

    public void appointmentsChanged() {
        this.hasAppointments = getAppointments().size() >= 1;
        notifyObservers();
    }

    public boolean hasAppointments() {
        return this.hasAppointments;
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(getClinicName());
        }
    }

    public void printObservers() {
        this.observers.forEach(observer -> System.out.println("Observer: " + observer));
    }

    public String getClinicName() {
        return this.clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    public ArrayList<String> getAppointments() {
        return this.appointments;
    }

    public void setAppointments(ArrayList<String> appointments) {
        this.appointments = appointments;
        appointmentsChanged();
    }

    public void removeAppointments() {
        this.appointments = new ArrayList<>();
        appointmentsChanged();
    }

    public void addAppointment(String appointment) {
        this.appointments.add(appointment);
        appointmentsChanged();
    }

    public void removeAppointment(String appointment) {
        this.appointments.remove(appointment);
        appointmentsChanged();
    }
}
