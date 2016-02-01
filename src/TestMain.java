import algorithm.easy.ImplementQueueUsingStacks_232;

public class TestMain {
    public static void main(String[] args) {
        ImplementQueueUsingStacks_232 queue = new ImplementQueueUsingStacks_232();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        queue.pop();
        queue.pop();
        System.out.println(queue.empty());
    }
}