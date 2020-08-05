package clean.project.gui.contract;

public interface Driver<T, S> {
    public void bind(final Actor<T, S> actor, final Target<T, S> target);
    public void addAction(final String actionName, final String param);
    public void clearActions();
    public boolean perform();
}
