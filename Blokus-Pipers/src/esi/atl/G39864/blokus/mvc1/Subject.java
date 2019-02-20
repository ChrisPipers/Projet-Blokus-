package esi.atl.G39864.blokus.mvc1;

/**
 * this interface allows of the class implement him to be a subject and add it
 * and notify it if there is one change
 *
 * @author chris home
 */
public interface Subject {

    /**
     * this signature of method allows to implement the method add an Observer
     * at the List of Observer
     *
     * @param observer this the new Observer to add to the List
     */
    public void addObserver(Observer observer);

    /**
     * this signature of method allows to implement the method remove an Observer
     * at the List of Observer
     *
     * @param observer this the Observer to remove to the List
     */
    public void removeObserver(Observer observer);
    
    /**
     * this signature of method allows to implement the method notify all of
     * Observer where are in the her List
     */
    public void notifyObservers();
}
