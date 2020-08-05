package clean.project.gui.contract;

public interface Target<T, S> {
    public void setElement(final T element);
    public T getElement();
    public void setSelector(final S selector);
    public S getSelector();
    public void setPageName(final String pageName);
    public String getPageName();
}
