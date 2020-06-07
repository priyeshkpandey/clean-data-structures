package clean.project.ds.queue.impl;

import clean.project.ds.queue.contract.MonitoredLimitedQueue;

import java.util.ArrayList;
import java.util.List;

public class CircularMonitoredLimitedQueueImpl<T> implements MonitoredLimitedQueue<T> {
    private int size;
    private int front;
    private int rear;
    private List<T> queue;

    public CircularMonitoredLimitedQueueImpl(final int size) {
        this.size = size;
        this.front = 0;
        this.rear = 0;
        queue = new ArrayList<T>();
    }

    public T peek() {
        return queue.get(front);
    }

    public boolean isFull() {
        return ((this.front - this.rear) == 1)
                || ((this.rear - this.front) >= (this.size - 1));
    }

    public void insert(T item) throws Exception {
        if (!isFull()) {
            this.rear = ++this.rear % this.size;
            queue.add(this.rear, item);
        } else {
            throw new Exception("Queue is full");
        }
    }

    public T remove() throws Exception {
        if (!isEmpty()) {
            T item = queue.get(this.front);
            this.front = ++this.front % this.size;
            return item;
        }
        throw new Exception("Queue is empty");
    }

    public boolean isEmpty() {
        return (this.rear == this.front);
    }
}
