package clean.project.gui.contract;

public interface Page<T, S> {
    public Target<T, S> get(final String targetName) throws Exception;
}
