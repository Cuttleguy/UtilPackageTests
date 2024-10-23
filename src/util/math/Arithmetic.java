package util.math;

import manifold.ext.rt.api.Structural;

@Structural
public interface Arithmetic<T> {
    public abstract T add(T other);
    public abstract T subtract(T other);
    public abstract T multiply(T other);
    public abstract T divide(T other);
    public abstract T remainder(T other);
    public abstract T negate();
    public abstract Double doubleVal();
    public abstract T ln();
    public abstract T exp();

}
