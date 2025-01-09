//this is the main class of this project 
public class ProducerConsumerExample {
    public static void main(String[] args) { 
        SharedResource resource = new SharedResource();
        Producer producer = new Producer(resource);
        Consumer consumer = new Consumer(resource);
        producer.start();
        consumer.start();
        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted!"); 
             System.out.println("Task Completed!");
        }
        System.out.println("Producer-Consumer process completed!");
    }
}
