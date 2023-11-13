public class LinkedQueue<E> implements Queue<E>{

    private SinglyLinkedList<E> list = new SinglyLinkedList<>();

    @Override
    public boolean isEmpty(){
        return list.isEmpty();
    }

    @Override
    public void enqueue(E element){
        list.addLast(element);
    }

    @Override
    public E dequeue(){
        return list.removeFirst();
    }

    @Override
    public int size(){
        return list.size();
    }

    @Override
    public E first(){
        return list.first();
    }

    @Override
    public String toString() {
        return list.toString();    
    }
}
