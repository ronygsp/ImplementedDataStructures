public class SpecialSinglyLinkedList<E> {
        private static class Node<E> {
            private E element;
            private Node<E> next1D;
            private Node<E> next2D;
    
            public Node(E e, Node<E> n1D, Node<E> n2D) {
                element = e;
                next1D = n1D;
                next2D = n2D;
            }
    
            public E getElement() {
                return element;
            }
    
            public Node<E> getNext1D() {
                return next1D;
            }

            public Node<E> getNext2D() {
                return next2D;
            }
    
            public void setNext1D(Node<E> n) {
                next1D = n;
            }

            public void setNext2D(Node<E> next12d) {
                next2D = next12d;
            }
        }
        private Node<E> head = null;
        private Node<E> tail = null;
        private int size = 0;
        public SpecialSinglyLinkedList(){}
    
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
            return head.getElement();
        }
        public E last(){
            if(isEmpty()){
                return null;
            }
            return tail.getElement();
        }
        public void addFirst(E e){
            head = new Node<>(e, head, head);
        }
        public void addLast(E e){
            Node<E> newest = new Node<>(e, null, null);
            if(isEmpty()){
                head = newest;
            }else{
                tail.setNext1D(newest);
            }
            tail = newest;
            size++;
        }
        public E removeFirst(){
            if (isEmpty()){
                return null;
            }
            E answer = head.getElement();
            head = head.getNext1D();
            size--;
            if(size == 0){
                tail = null;
            }
            return answer;
        }
}
