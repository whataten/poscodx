package behavioral.iterator;

public interface Aggregate<E> {

    // Iterator<E> iterator();
    Iterator<E> createIterator();
}
