package behavioral.iterator;

public class AggreGateImpl<E> implements Aggregate<E>{
    private E[] datas = null;

    public AggreGateImpl(E[] datas) {
        this.datas = datas;
    }

    @Override
    public Iterator<E> createIterator() {

        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<E> {
        int index = 0;

        @Override
        public E next() {
            return index < datas.length ? datas[index++] : null;
        }

        @Override
        public boolean hasNext() {
            return index < datas.length;
        }

    }

}
