package clean.project.ds.queue.factory;

import clean.project.ds.queue.contract.MonitoredLimitedQueue;
import clean.project.ds.queue.impl.StraightMonitoredLimitedQueueImpl;

public class StraightMonitoredLimitedQueueFactory<T> implements QueueFactory<MonitoredLimitedQueue<T>, T> {
    public MonitoredLimitedQueue<T> getQueue(int size) {
        return new StraightMonitoredLimitedQueueImpl<T>(size);
    }
}
