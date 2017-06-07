import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Arrays;

public class PriorityQueueFrontier implements Frontier{

    private int constant;//constant determines type of heap (min or max),
    private int size;//size is because first element creates problems
    private ArrayList<Mnode>heap;//storage

    public PriorityQueueFrontier(){
	heap=new ArrayList<Mnode>();
	heap.add(new Mnode(0, 0, null, 0, 0));//filler
	size=0;
	constant=1;
    }
    
    public PriorityQueueFrontier(boolean type){//min or max heap?
	this();
	constant = (type) ? 1 : -1;
    }
    
    private int compare(Mnode first, Mnode other) {
	return first.compareTo(other)*constant;
    }

    private int leftChild(int i){
	return i*2;
    }
    
    private int rightChild(int i){
	return i*2+1;
    }

    private int switchChild(int i){
        if (leftChild(i) > size){
	    return -1;
	}
        if (rightChild(i) > size){
	    return leftChild(i);
	}
        return (compare(heap.get(rightChild(i)),heap.get(leftChild(i)))>0) ? rightChild(i) : leftChild(i);
    }

    private Mnode peek(){
	if(size==0){
	    throw new NoSuchElementException("Deque is empty");
	}
	return heap.get(1);
    }

    public void add(Mnode s){
        heap.add(s);
	size++;
	pushUp();
    }

    private Mnode remove(){
	if(size==0){
	    throw new NoSuchElementException("Deque is empty");
	}
        Mnode temp = heap.get(1);
	heap.set(1, heap.get(size));
	heap.remove(size);
	size--;
	pushDown();
	return temp;
    }

    private int swap(int index1, int index2){
	Mnode temp= heap.get(index1);
	heap.set(index1, heap.get(index2));
	heap.set(index2, temp);
	return index2;
    }

    private void pushUp(){
	int child= size;
	int parent = size / 2;
	while (parent > 0 && compare(heap.get(parent), heap.get(child)) < 0){
	    child= swap(child, parent);
	    parent = child / 2;
	}
    }
    
    private void pushDown(){
	int parent= 1;
	int child=switchChild(1);
	while(child>0 && compare(heap.get(child), heap.get(parent))>0){
	    parent= swap(parent, child);
	    child=switchChild(parent);
	}
    }

    public int getSize(){
	return size;
    }
    
    public String toString(){
	String s="";
	Mnode temp=heap.remove(0);
	for(Mnode x:heap)
	    s+=x+" ";
	heap.add(0,temp);
	return s;
    }
    //Will add tree printing when done in other file

    public boolean hasNext(){
	return size != 0;
    }

    public Mnode next(){
	return remove();
    }
    
}
