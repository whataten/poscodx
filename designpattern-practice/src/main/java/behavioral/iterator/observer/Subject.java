package behavioral.iterator.observer;

import java.util.List;
import java.util.ArrayList;

public class Subject<T> {
    private T val;
    private List<Observer<T>> observerCollection = new ArrayList<>();

    public void registerObserver(Observer<T> observer) {
        this.observerCollection.add(observer);
    }

    public void unregisterObserver(Observer<T> observer) {
        this.observerCollection.remove(observer);
    }

    public void changeSubject(T val) {
        this.val = val;
        notifyObervers();
    }

    private void notifyObervers() {
        for(var observer : this.observerCollection) {
            observer.update(this.val);
        }
    }
}
