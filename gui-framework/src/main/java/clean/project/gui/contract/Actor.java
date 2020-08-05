package clean.project.gui.contract;

public interface Actor<T, S> {
    public  void setTarget(final Target<T, S> target);
    public Target<T, S> getTarget();
    public void removeTarget();
    public boolean open(final String url);
    public boolean enter(final String input);
    public boolean click();
    public boolean submit();
    public boolean find();
    public boolean sleep(final String timeInMillis);
    public boolean robot(final String action);
    public boolean jsClick();
    public boolean jsChange();
    public boolean clear();
    public boolean keyboard(final String action);
    public boolean close();
}
