package clean.project.ds.queue.factory;

import clean.project.ds.queue.contract.MonitoredLimitedQueue;
import clean.project.ds.queue.impl.MonitoredLimitedPriorityQueueImpl;

import java.util.Comparator;

public class MonitoredLimitedPriorityQueueFactory<T> implements QueueFactory<MonitoredLimitedQueue<T>, T> {
    private Comparator<T> comparator;

    public MonitoredLimitedPriorityQueueFactory(final Comparator<T> comparator) {
        this.comparator = comparator;
    }
    public MonitoredLimitedQueue<T> getQueue(int size) {
        return new MonitoredLimitedPriorityQueueImpl<T>(size, this.comparator);
    }
}
