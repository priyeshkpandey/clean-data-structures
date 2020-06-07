package clean.project.ds.queue.factory;

import clean.project.ds.queue.contract.MonitoredLimitedQueue;
import clean.project.ds.queue.impl.CircularMonitoredLimitedQueueImpl;

public class CircularMonitoredLimitedQueueFactory<T> implements QueueFactory<MonitoredLimitedQueue<T>, T>{
    public MonitoredLimitedQueue<T> getQueue(int size) {
        return new CircularMonitoredLimitedQueueImpl<T>(size);
    }
}
