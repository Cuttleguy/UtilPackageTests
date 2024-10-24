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
    public abstract T ln(T other);
    public abstract T exp(T other);
    public abstract T cos(T other);
    public abstract T sin(T other);
    public abstract boolean lt(T other);
    public abstract boolean le(T other);
    public abstract boolean gt(T other);
    public abstract boolean ge(T other);
    public abstract T add(Double other);
    public abstract T subtract(Double other);
    public abstract T multiply(Double other);
    public abstract T divide(Double other);
    public abstract T remainder(Double other);
    public abstract boolean lt(Double other);
    public abstract boolean le(Double other);
    public abstract boolean gt(Double other);
    public abstract boolean ge(Double other);
    public abstract T sqrt();
    public abstract T from(Double other);
    public abstract T from(Integer other);
    public abstract boolean equals(Object other);
}
