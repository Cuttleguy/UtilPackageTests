package util.math;

public interface Dividable<T extends Dividable<T>> {
    public abstract T divide(T other);
    public abstract T from(Double other);
    public abstract T from(Integer other);

}
