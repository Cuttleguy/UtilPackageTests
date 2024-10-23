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
    public abstract boolean lt(T other);
    public abstract boolean le(T other);
    public abstract boolean gt(T other);
    public abstract boolean ge(T other);
    public abstract T add(Double other);
    public abstract T subtract(Double other);
    public abstract T multiply(Double other);
    public abstract T divide(Double other);
    public abstract T remainder(Double other);
    public abstract double lt(Double other);
    public abstract boolean le(Double other);
    public abstract boolean gt(Double other);
    public abstract boolean ge(Double other);

}
