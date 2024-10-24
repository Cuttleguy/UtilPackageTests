package util.math;

import manifold.ext.rt.api.ComparableUsing;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Complex<T extends Arithmetic<T>> implements ComparableUsing<Complex<T>> {
    public T real;
    public T imag;
    final Arithmetic<T> test = (Arithmetic<T>) 0.0;
    public static <T extends Arithmetic<T>> Complex<T> i()
    {
        return new Complex<>(0.0,1.0);
    }
    public static <T extends Arithmetic<T>> Complex<T> one()
    {
        return new Complex<>(1.0,0.0);
    }
    public static <T extends Arithmetic<T>> Complex<T> zero()
    {
        return new Complex<>(0.0,0.0);
    }


//    public final Complex<T> zero = new Complex<>(0.0,0.0);
//    public final Complex<T> half = new Complex<>(0.5,0.0);

    public Class<? extends Arithmetic> getType()
    {
        return real.getClass();
    }
    public Complex(double newReal) {

        this.real = test.from(newReal);
        this.imag = test.from(0.0);
    }
    public Complex(T newReal)
    {
        this.real=newReal;
        this.imag = test.from(0.0);
    }
    public Complex() {
        this.real = test.from(0.0);
        this.imag = test.from(0.0);
    }

    public Complex(double newReal, double newImag) {
        this.real = test.from(newReal);
        this.imag = test.from(newImag);
    }
    public Complex(T newReal, T newImag)
    {
        this.real=newReal;
        this.imag=newImag;
    }
    public int hashCode() {
        return Objects.hash(real, imag);
    }
    public Complex<T> plus(Complex<T> other) {
        return new Complex<>(this.real.add(other.real), this.imag.add(other.imag));
    }


    public Complex<T> minus(Complex<T> other) {
        return new Complex<>(this.real.subtract(other.real), this.imag.subtract(other.imag));
    }


    public Complex<T> times(Complex<T> other) {
        return new Complex<>(
                this.real.multiply(other.real).subtract(this.imag.multiply(other.imag)),
                this.real.multiply(other.imag).add(this.imag.multiply(other.real))
        );
    }

    public Complex<T> div(double other) {
        if (other == 0) throw new ArithmeticException("Division by zero");
        return new Complex<>(this.real.divide(real.from(other)), this.imag.divide(real.from(other)));
    }
    public Complex<T> div(T other) {
        if (other == other.from(0.0)) throw new ArithmeticException("Division by zero");
        return new Complex<>(this.real.divide(other), this.imag.divide(other));
    }

    public Complex<T> div(Complex<T> other) {
        if(other == Complex.<T>zero()) throw new ArithmeticException("Division by zero");
        T denominator = other.real.multiply(other.real).add(other.imag.multiply(other.imag));
        if (denominator == test.from(0)) throw new ArithmeticException("Division by zero");
        return this * other / denominator;
    }

    public T magnitude() {
        return (real.multiply(real).add(imag.multiply(imag))).sqrt();
    }
    public T argument()
    {
        return test.from(Math.atan2(imag.doubleVal(),real.doubleVal()));
    }
    public static <T extends Arithmetic<T>> Complex<T> pow(Complex<T> a, Complex<T> b)
    {
        try{
            if(a== Complex.<T>zero())
            {
                if(b==Complex.<T>zero())
                {
                    return Complex.one();
                }
                else
                {
                    return Complex.zero();
                }
            } else if (b==Complex.<T>zero()) {
                return Complex.<T>one();
            }
            else if(b==Complex.<T>one())
            {
                return a;
            } else if (b.imag==Complex.<T>zero()&&b.real.remainder(b.real.from(1))==b.real.from(0)) {
                return Complex.<T>pow(a,b.real.doubleVal().intValue());
            }
            T mag = a.magnitude();
            T arg = a.argument();
            T log_mag=a.real.ln(mag);
            Complex<T> log_a=new Complex<>(log_mag,arg);
            Complex<T> b_log_a=log_a*b;
            T e_real=a.real.exp(b_log_a.real);
            if(a.getType()==Double.class)
            {
                return round(new Complex<T>(e_real.multiply(a.real.cos(b_log_a.imag)),e_real.multiply(a.real.sin(b_log_a.imag))),10);
            }
            else
            {
                return new Complex<>(e_real.multiply(a.real.cos(b_log_a.imag)),e_real.multiply(a.real.sin(b_log_a.imag)));
            }

        }
        catch(RuntimeException e)
        {
            throw new RuntimeException(e+"\n"+a+"\n"+b);
        }

    }

    private static <T extends Arithmetic<T>> Complex<T> pow(Complex<T> a, int b)
    {
        Complex<T> result= Complex.<T>one();
        for (int j = 0; j < b; j++) {
            result*=a;
        }

        return result;

    }

    public static <T extends Arithmetic<T>> Complex<T> round(Complex<T> c,int digits)
    {
        return new Complex<>(MathUtil.round(c.real.doubleVal(),digits),MathUtil.round(c.imag.doubleVal(),digits));
    }
    public boolean equals(Complex<T> other)
    {
        return real==other.real && imag==other.imag;
    }
    @Override
    public boolean equals(Object other)
    {
        if(other instanceof Complex<?>)
        {
            System.out.println(((Complex<?>) other).imag);
            return equals(other);
        }
        else
        {
            throw new RuntimeException("Complex compared to "+other.getClass());
        }
    }


    public Complex<T> conjugate()
    {
        return new Complex(
                real,imag.negate()
        );
    }
    public Complex<T> unaryMinus()
    {
        return new Complex<T>(
                real.negate(),imag.negate()
        );
    }


    public String toString(){
        T zero2 = test.from(0);
        T one2 = test.from(1);
        System.out.println(test.from(1.0));

        System.out.println(one2.equals(one2));
        if(imag.equals(imag.from(0)))
        {
            if(real.remainder(test.from(1)).equals(test.from(0)))
            {

                return Integer.toString(real.doubleVal().intValue());
            }
            else
            {
                return real.toString();
            }

        } else if (real.equals(zero2)) {
            if (imag.equals(one2))
            {
                return "i";
            }
            else if (imag.equals(one2.negate()))
            {
                return "-i";
            }
            else if(imag.remainder(one2)==zero2)
            {

                return imag.doubleVal().intValue() +"i";
            }
            else
            {
                return imag.toString()+"i";
            }
        } else if (imag==one2) {
            if(real.remainder(one2)==zero2)
            {

                return Integer.toString(real.doubleVal().intValue())+" + i";
            }
            else
            {
                return real.toString()+" + i";
            }
        }
        else if(imag==one2.negate())
        {
            if(real.remainder(one2)==zero2)
            {

                return Integer.toString(real.doubleVal().intValue())+" - i";
            }
            else
            {
                return real.toString()+" - i";
            }
        } else if (imag.lt(zero2)) {
            String realStr;
            if(real.remainder(one2)==zero2)
            {

                realStr= Integer.toString(real.doubleVal().intValue());
            }
            else
            {
                realStr= real.toString();
            }
            String imagStr;
            if(imag==one2)
            {
                imagStr = "";
            } else if (imag==one2.negate()) {
                imagStr = "";
            } else if(imag.remainder(one2)==zero2)
            {

                imagStr= " -"+Integer.toString(imag.doubleVal().intValue());
            }
            else
            {
                imagStr= " "+imag.toString();
            }

            return realStr+imagStr+"i";
        } else {
            String realStr;
            if(real.remainder(real.from(1))==real.from(0))
            {

                realStr= Integer.toString(real.doubleVal().intValue());
            }
            else
            {
                realStr= real.toString();
            }
            String imagStr;
            if(real.remainder(one2)==zero2)
            {

                imagStr= Integer.toString(imag.doubleVal().intValue());
            }
            else
            {
                imagStr= imag.toString();
            }

            return realStr+" + "+imagStr+"i";
        }

    }
    public Complex<T> times(T other)
    {
        return new Complex<>(real.multiply(other),imag.multiply(other));
    }
    public static <T extends Arithmetic<T>> Complex<T> sqrt(Complex<T> other)
    {

        return Complex.root(other,Complex.<T>one()*other.real.from(2));
    }
    public static <T extends Arithmetic<T>> Complex<T> root(Complex<T> other, Complex<T> power)
    {
        return Complex.pow(other,Complex.<T>one()/power);
    }
    public static <T extends Arithmetic<T>> Complex<T> cbrt(Complex<T> other)
    {
        return Complex.<T>root(other,new Complex<T>(3));
    }
    public static <T extends Arithmetic<T>> Complex<T> exp(Complex<T> other)
    {
        if(other.real instanceof Double)
        {
            return round(other.test.exp(other.real)*new Complex<T>(other.test.cos(other.imag),other.test.sin(other.imag)),10);
        }
        else
        {
            return other.test.exp(other.real)*new Complex<T>(other.test.cos(other.imag),other.test.sin(other.imag));
        }

    }
    public static <T extends Arithmetic<T>>List<Complex<T>> rootsOfUnity(int power)
    {
        List<Complex<T>> roots = new ArrayList<>();
        for (int j = 0; j < power; j++) {
            roots.add(exp(new Complex<T>(0,2*Math.PI*j/power)));
        }
        return roots;
    }


    @Override
    public int compareTo(Complex<T> other) {

        if(this.real!=other.real)
        {
            return (int) Math.round(this.real.subtract(other.real).doubleVal());
        }
        else
        {
            return (int) Math.round(this.imag.subtract(other.imag).doubleVal());
        }
    }
    @Override
    public boolean compareToUsing(Complex<T> other,Operator op)
    {
        int result = compareTo(other);
        if(op==Operator.EQ)
        {
            return this.equals(other);
        } else if (op==Operator.NE) {
            return !this.equals(other);
        } else if (op==Operator.GT) {
            return result>0;
        } else if (op==Operator.GE) {
            return result>=0;
        } else if (op==Operator.LT) {
            return result<0;
        } else {
            return result<=0;
        }
    }


//    @Override
//    public Complex<T> add(Complex<T> other) {
//        return this+other;
//    }
//
//    @Override
//    public Complex<T> subtract(Complex<T> other) {
//        return this-other;
//    }
//
//    @Override
//    public Complex<T> multiply(Complex<T> other) {
//        return this*other;
//    }
//
//    @Override
//    public Complex<T> divide(Complex<T> other) {
//        return this/other;
//    }
//
//    @Override
//    public Complex<T> remainder(Complex<T> other) {
//        return null;
//    }
//
//    @Override
//    public Complex<T> negate() {
//        return -this;
//    }
//
//    @Override
//    public Double doubleVal() {
//        return real.doubleVal();
//    }
//
//    @Override
//    public boolean lt(Complex<T> other) {
//        return compareToUsing(other,Operator.LT);
//    }
//
//    @Override
//    public boolean le(Complex<T> other) {
//        return compareToUsing(other,Operator.LE);
//    }
//
//    @Override
//    public boolean gt(Complex<T> other) {
//        return compareToUsing(other,Operator.GT);
//    }
//
//    @Override
//    public boolean ge(Complex<T> other) {
//        return compareToUsing(other,Operator.GE);
//    }
//
//    @Override
//    public Complex<T> add(Double other) {
//        return this+new Complex<T>(other);
//    }
//
//    @Override
//    public Complex<T> subtract(Double other) {
//        return this-new Complex<T>(other);
//
//    }
//
//    @Override
//    public Complex<T> multiply(Double other) {
//        return this*new Complex<T>(other);
//
//    }
//
//    @Override
//    public Complex<T> divide(Double other) {
//        return this/other;
//
//    }
//
//    @Override
//    public Complex<T> remainder(Double other) {
//        return null;
//    }
//
//    @Override
//    public boolean lt(Double other) {
//        return compareToUsing(new Complex<>(other),Operator.LT);
//    }
//
//    @Override
//    public boolean le(Double other) {
//        return compareToUsing(new Complex<>(other),Operator.LE);
//    }
//
//    @Override
//    public boolean gt(Double other) {
//        return compareToUsing(new Complex<>(other),Operator.GT);
//    }
//
//    @Override
//    public boolean ge(Double other) {
//        return compareToUsing(new Complex<>(other),Operator.GE);
//    }
//
//    @Override
//    public Complex<T> sqrt() {
//        return Complex.<T>sqrt(this);
//    }
//
//    @Override
//    public Complex<T> from(Double other) {
//        return new Complex<>(other);
//    }
//
//    @Override
//    public Complex<T> from(Integer other) {
//        return new Complex<>(other);
//    }
//
//
//    public Complex<T> expSpec(Complex other1) {
//        return T.exp(other1);
//    }
//
//    public Complex<T> logSpec(Complex other1) {
//        return T.ln(other1);
//    }
//
//    public Complex<T> cosSpec(Complex other1) {
//        return T.cos(other1);
//    }
//
//    public Complex<T> sinSpec(Complex other1) {
//        return T.sin(other1);
//    }
}
