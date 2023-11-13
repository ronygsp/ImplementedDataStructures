public class MultiLinkedList<E> {
    private static class BDNode<E> {
        private E element;
        private BDNode<E> next1D;
        private BDNode<E> next2D;

        public BDNode(E e, BDNode<E> n1D, BDNode<E> n2D) {
            element = e;
            next1D = n1D;
            next2D = n2D;
        }

        public E getElement() {
            return element;
        }

        public BDNode<E> getNext1D() {
            return next1D;
        }

        public BDNode<E> getNext2D() {
            return next2D;
        }

        public void setNext1D(BDNode<E> n) {
            next1D = n;
        }

        public void setNext2D(BDNode<E> next12d) {
            next2D = next12d;
        }
    }

    SinglyLinkedList<E> primeraD = new SinglyLinkedList<>();
    SinglyLinkedList<E> segundaD = new SinglyLinkedList<>();
    
    private int size = 0;

    public MultiLinkedList(){};

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public E first(){
        if(isEmpty()){
            return null;
        }
        //return head.getElement();
        return null;
    }
    public E last(){
        if(isEmpty()){
            return null;
        }
        //return tail.getElement();
        return null;
    }
}
