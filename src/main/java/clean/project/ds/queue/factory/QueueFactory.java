package clean.project.ds.queue.factory;

public interface QueueFactory<QT, T> {
    public QT getQueue(final int size);
}
