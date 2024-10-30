package util.math;

public interface Multipliable<T extends Multipliable<T>> {
    public abstract T multiply(T other);
    public default T pow(T input, int other) {
        T toReturn = from(1);
        for (int i = 0; i < other; i++) {
            toReturn=toReturn.multiply(input);
        }
        return toReturn;
    }
    public abstract T from(Double other);
    public abstract T from(Integer other);
}
