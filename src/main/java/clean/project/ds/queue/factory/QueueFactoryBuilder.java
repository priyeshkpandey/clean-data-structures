package clean.project.ds.queue.factory;

public class QueueFactoryBuilder<T> {
    public StraightMonitoredLimitedQueueFactory<T> getStraightMonitoredLimitedQueueFactory() {
        return new StraightMonitoredLimitedQueueFactory<T>();
    }

    public CircularMonitoredLimitedQueueFactory<T> getCircularMonitoredLimitedQueueFactory() {
        return new CircularMonitoredLimitedQueueFactory<T>();
    }

}
