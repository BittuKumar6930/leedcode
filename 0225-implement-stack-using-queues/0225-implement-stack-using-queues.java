import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    // Only one queue is needed
    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }
    
    public void push(int x) {
        // 1. Get the current size before adding the new element
        int size = queue.size();
        
        // 2. Add the new element to the back
        queue.add(x);
        
        // 3. Move all previous elements to the back of the new element
        for (int i = 0; i < size; i++) {
            queue.add(queue.poll());
        }
    }
    
    public int pop() {
        // The newest element is always at the front
        return queue.poll();
    }
    
    public int top() {
        // Peer at the front element
        return queue.peek();
    }
    
    public boolean empty() {
        // Return true if the queue has no elements
        return queue.isEmpty();
    }
}
