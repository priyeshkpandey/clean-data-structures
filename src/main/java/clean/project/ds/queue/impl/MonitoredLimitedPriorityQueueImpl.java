package clean.project.ds.queue.impl;

import clean.project.ds.queue.contract.MonitoredLimitedQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MonitoredLimitedPriorityQueueImpl<T> implements MonitoredLimitedQueue<T> {

    private int size;
    private int front;
    private int rear;
    private List<T> queue;
    private Comparator<T> comparator;

    public MonitoredLimitedPriorityQueueImpl(final int size, final Comparator<T> comparator) {
        this.size = size;
        this.comparator = comparator;
        this.front = 0;
        this.rear = 0;
        queue = new ArrayList<T>();
    }

    public T peek() {
        return queue.get(front);
    }

    public boolean isFull() {
        return (this.rear - this.front) >= (this.size - 1);
    }

    @Override
    public int getCount() {
        return this.queue.size();
    }

    public void insert(T item) throws Exception {
        if (!isFull()) {
            queue.add(this.rear++, item);
            Collections.sort(this.queue, this.comparator);
        } else {
            throw new Exception("Queue is full");
        }
    }

    public T remove() throws Exception {
        if (!isEmpty()) {
            this.rear--;
            return queue.remove(this.front);
        }
        throw new Exception("Queue is empty");
    }

    public boolean isEmpty() {
        return (this.rear == this.front);
    }
}
