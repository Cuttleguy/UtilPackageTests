package util.math;

import manifold.ext.rt.api.ComparableUsing;
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
//    public static <T extends Arithmetic<T>> T exp(T other)
//    {
////        if(other instanceof Complex)
////        {
////            if(other instanceof Quaternion)
////            {
////                return null;
////            }
////            else
////            {
////                Complex other1 = (Complex) other;
////
////                return (T) other1.expSpec(other1);
////
////            }
////        }
//        return other.from(Math.exp(other.doubleVal()));
//    }
//    public static <T extends Arithmetic<T>> T ln(T other)
//    {
////        if(other instanceof Complex)
////        {
////            if(other instanceof Quaternion)
////            {
////                return null;
////            }
////            else
////            {
////                Complex other1 = (Complex) other;
////                return (T) other1.logSpec(other1);
////            }
////        }
//        return other.from(Math.log(other.doubleVal()));
//    }
//    public static <T extends Arithmetic<T>> T cos(T other)
//    {
//        if(other instanceof Complex)
//        {
//            if(other instanceof Quaternion)
//            {
//                return null;
//            }
//            else
//            {
//                Complex other1 = (Complex) other;
//                return (T) other1.cosSpec(other1);
//            }
//        }
//        return other.from(Math.cos(other.doubleVal()));
//    }
//    public static <T extends Arithmetic<T>> T sin(T other)
//    {
//        if(other instanceof Complex)
//        {
//            if(other instanceof Quaternion)
//            {
//                return null;
//            }
//            else
//            {
//                Complex<?> other1 = (Complex<?>) other;
//                return (T) other1.sinSpec(other1);
//            }
//        }
//        return other.from(Math.sin(other.doubleVal()));
//    }
//    public abstract T ln();
//    public abstract T exp();
//    public abstract T cos();
//    public abstract T sin();
    // Trig Functions
    public abstract T ln(T other);
    public abstract T exp(T other);
    public abstract T cos(T other);
    public abstract T sin(T other);
    public abstract T cosh(T other);
    public abstract T sinh(T other);
    public abstract T sec(T other);
    public abstract T csc(T other);
    public abstract T tan(T other);
    public abstract T tanh(T other);
    public abstract T cot(T other);
    public abstract T coth(T other);
    public abstract T sech(T other);
    public abstract T csch(T other);
    // Comparisons
    public abstract boolean lt(T other);
    public abstract boolean le(T other);
    public abstract boolean gt(T other);
    public abstract boolean ge(T other);
//    public default T add(Double other)
//    {
//        return this.add(this.from(other));
//    }
//
//    public default T subtract(Double other)
//    {
//        return this.subtract(this.from(other));
//    }
//    public default T multiply(Double other)
//    {
//        return this.multiply(this.from(other));
//    }
//    public default T divide(Double other)
//    {
//        return this.divide(this.from(other));
//    }
//    public default T remainder(Double other)
//    {
//        return this.remainder(this.from(other));
//    }
//    public default boolean lt(Double other)
//    {
//        return this.lt(this.from(other));
//    }
//    public default boolean le(Double other)
//    {
//        return this.le(this.from(other));
//    }
//    public default boolean gt(Double other)
//    {
//        return this.gt(this.from(other));
//    }
//    public default boolean ge(Double other)
//    {
//        return this.ge(this.from(other));
//    }
    public abstract T sqrt();
    public abstract T from(Double other);
    public abstract T from(Integer other);
    public abstract boolean equals(Object other);
}
