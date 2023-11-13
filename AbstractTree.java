import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public abstract class AbstractTree<E> implements Tree<E>{
   
    @Override
    public boolean isInternal(Position<E> p){
        return numChildren(p) > 0;
    }

    @Override
    public boolean isExternal(Position<E> p){
        return numChildren(p) == 0;
    }

    @Override
    public boolean isRoot(Position<E> p){
        return p == root();
    }

    @Override
    public int numChildren(Position<E> p){
        int count = 0;
        for(Position child : children(p)){
        count++;
        }   
        return count;
    }

    @Override
    public int size(){
        int count = 0;
        for(Position p : positions()){
        count++;
        }   
        return count;
    }

    @Override
    public boolean isEmpty(){
        return size() == 0;
    }

    public int depth(Position<E> p) throws IllegalArgumentException{
        if(isRoot(p)){
            return 0;
        }else{
            return 1 + depth(parent(p));
        }
    }

    private int heightBad() throws IllegalArgumentException{
        int h = 0;
        for(Position<E> p : positions()){
            if(isExternal(p)){
                h = Math.max(h, depth(p));
            }
        }
        return h;
    }

    private int height(Position<E> p) throws IllegalArgumentException{
        int h = 0;
        for(Position<E> c : children(p)){
            if(isExternal(p)){
                h = Math.max(h, 1 + height(p));
            }
        }
        return h;
    }

    private class ElementIterator implements Iterator<E>{
        Iterator<Position<E>> posIterator = positions().iterator();
        public boolean hasNext(){
            return posIterator.hasNext(); 
        }
        public E next(){
            return posIterator.next().getElement();
        }
        public void remove(){
            posIterator.remove();
        }
    }

    @Override
    public Iterator<E> iterator(){
        return new ElementIterator();
    }

    @Override
    public Iterable<Position<E>> positions(){
        return preorder();
    }

    private void preorderSubtree(Position<E> p, List<Position<E>> snapshot){
        snapshot.add(p);
        for(Position<E> c : children(p)){
            preorderSubtree(c, snapshot);
        }
    }

    public Iterable<Position<E>> preorder(){
        List<Position<E>> snapshot = new ArrayList<>();
        if(!isEmpty()){
            preorderSubtree(root(), snapshot);
        }
        return snapshot;
    }

    private void postorderSubtree(Position<E> p, List<Position<E>> snapshot){
        for(Position<E> c : children(p)){
                postorderSubtree(c, snapshot);
        }
        snapshot.add(p);
    }

    public Iterable<Position<E>> postorder(){
        List<Position<E>> snapshot = new ArrayList<>();
        if(!isEmpty()){
            postorderSubtree(root(), snapshot);
        }
        return snapshot;
    }

    public Iterable<Position<E>> breadthfirst(){
        List<Position<E>> snapshot = new ArrayList<>();
        if(!isEmpty()){ 
            Queue<Position<E>> fringe = new LinkedQueue();
            fringe.enqueue(root());
            while (!fringe.isEmpty()){
                Position<E> p = fringe.dequeue();
                snapshot.add(p);
                for(Position<E> c : children(p)){
                    fringe.enqueue(c);
                }
            }
        }
        return snapshot;
    }
}
