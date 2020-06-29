package clean.project.ds.queue.factory;

import java.util.Comparator;

public class QueueFactoryBuilder<T> {
    public StraightMonitoredLimitedQueueFactory<T> getStraightMonitoredLimitedQueueFactory() {
        return new StraightMonitoredLimitedQueueFactory<T>();
    }

    public CircularMonitoredLimitedQueueFactory<T> getCircularMonitoredLimitedQueueFactory() {
        return new CircularMonitoredLimitedQueueFactory<T>();
    }

    public MonitoredLimitedPriorityQueueFactory<T> getMonitoredLimitedPriorityQueueFactory(final Comparator<T> comparator) {
        return new MonitoredLimitedPriorityQueueFactory<T>(comparator);
    }

}
