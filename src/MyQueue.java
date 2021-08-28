import java.util.*;

public class MyQueue {

    Queue<Integer> queue;

    public MyQueue(){
        queue = new LinkedList<Integer>();
    }

    public void addElement(int nr){
        queue.add(nr);
    }

    public int removeAndGetFrontElement(){

       return queue.poll();
    }

    public boolean isFull(int n){
        return queue.size() >= n;
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public int getNumberOfElements(){
        return queue.size();
    }


}
