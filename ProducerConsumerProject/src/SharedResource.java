class SharedResource {
    private int data;
    private boolean isDataAvailable = false;
    // Synchronized method for producing data
    public synchronized void produce(int value) {
        while (isDataAvailable) {
            try {
                wait(); // Wait if data is already available
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Producer interrupted!");
            }
        }
        data = value;
        isDataAvailable = true;
        System.out.println("Produced: " + data);
        notify(); // Notify the consumer
    }

    // Synchronized method for consuming data
    public synchronized int consume() {
        while (!isDataAvailable) {
            try {
                wait(); // Wait if no data is available
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Consumer interrupted!");
            }
        }
        isDataAvailable = false;
        System.out.println("Consumed: " + data);
        notify(); // Notify the producer
        return data;
    }
}
