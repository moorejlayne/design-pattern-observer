package headFirstDesignPatterns.java.clinics;
import headFirstDesignPatterns.java.seekers.Observer;

public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
