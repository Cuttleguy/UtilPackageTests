package util.math;

import manifold.ext.rt.api.ComparableUsing;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Complex<T extends Arithmetic<T>> implements ComparableUsing<Complex>,Arithmetic<T> {
    public T real;
    public T imag;
    public static final Complex<Double> i = new Complex<>(0.0,1.0);
    public static final Complex<Double> one = new Complex<>(1.0,0.0);
    public static final Complex<Double> zero = new Complex<>(0.0,0.0);
    public static final Complex<Double> half = new Complex<>(0.5,0.0);
    public static final Number zero2=Double.valueOf(0.0);

    public Complex(T newReal) {
        this.real = newReal;
        this.imag = (T) zero2;
    }
    public Complex() {

        this.real = (T) zero2;
        this.imag = (T) zero2;
    }

    public Complex(T newReal, T newImag) {
        this.real = newReal;
        this.imag = newImag;
    }
    public int hashCode() {
        return Objects.hash(real, imag);
    }
    public Complex<T> plus(Complex other) {
        return new Complex(this.real.add((T) other.real), this.imag.add((T) other.imag));
    }

    public Complex<T> minus(Complex other) {
        return new Complex(this.real.subtract((T) other.real), this.imag.subtract((T) other.imag));
    }

    public Complex<T> times(Complex<T> other) {
        return new Complex<T>(
                this.real.multiply((T) other.real).subtract( this.imag.multiply((T) other.imag)),
                this.real.multiply((T) other.imag).add(this.imag.multiply((T) other.real))
        );
    }

    public Complex<T> div(T other) {

        if (other == (T) zero2) throw new ArithmeticException("Division by zero");
        return new Complex<>(this.real.divide(other), this.imag.divide(other));
    }

    public Complex<T> div(Complex<T> other) {
        if(other == Complex.zero) throw new ArithmeticException("Division by zero");
        T denominator = other.real.multiply(other.real).add(other.imag.multiply(other.imag));
        if (denominator == (T) zero2) throw new ArithmeticException("Division by zero");
        return this * new Complex<T>(other.real.divide(denominator), other.imag.negate().divide(denominator));
    }

    public double magnitude() {
        return Math.sqrt(real.multiply(real).add(imag.multiply(imag)).doubleVal());
    }
    public double argument()
    {
        return Math.atan2(imag.doubleVal(),real.doubleVal());
    }
    public static Complex<T> pow(Complex a, Complex<T> b)
    {
        try{
            if(a== Complex.zero)
            {
                if(b==Complex.zero)
                {
                    return Complex.one;
                }
                else
                {
                    return Complex.zero;
                }
            } else if (b==Complex.zero) {
                return Complex.one;
            }
            else if(b==Complex.one)
            {
                return a;
            } else if (b.imag==0&&b.real%1==0) {
                return Complex.pow(a,Double.valueOf(b.real).intValue());
            }
            double mag = a.magnitude();
            double arg = a.argument();
            double log_mag=Math.log(mag);
            Complex log_a=new Complex(log_mag,arg);
            Complex b_log_a=log_a*b;
            double e_real=Math.exp(b_log_a.real);
            return round(new Complex(e_real*Math.cos(b_log_a.imag),e_real*Math.sin(b_log_a.imag)),10);
        }
        catch(RuntimeException e)
        {
            throw new RuntimeException(e+"\n"+a+"\n"+b);
        }

    }

    private static Complex pow(Complex a, int b)
    {
        Complex result= Complex.one;
        for (int j = 0; j < b; j++) {
            result*=a;
        }

        return result;

    }

    public static Complex round(Complex c,int digits)
    {
        return new Complex(MathUtil.round(c.real,digits),MathUtil.round(c.imag,digits));
    }
    public boolean equals(Complex other)
    {
        return real==other.real && imag==other.imag;
    }

    public Complex conjugate()
    {
        return new Complex(
                real,-imag
        );
    }
    public Complex unaryMinus()
    {
        return new Complex(
                -real,-imag
        );
    }


    public String toString(){
        if(imag == 0.0)
        {
            if(real%1.0==0)
            {

                return Integer.toString(Math.round(Double.valueOf(real).floatValue()));
            }
            else
            {
                return Double.toString(real);
            }

        } else if (real==0.0) {
            if (imag==1.0)
            {
                return "i";
            }
            else if (imag == -1)
            {
                return "-i";
            }
            else if(imag%1.0==0)
            {

                return Integer.toString(Math.round(Double.valueOf(imag).floatValue()))+"i";
            }
            else
            {
                return Double.toString(imag)+"i";
            }
        } else if (imag==1.0) {
            if(real%1.0==0)
            {

                return Integer.toString(Math.round(Double.valueOf(real).floatValue()))+" + i";
            }
            else
            {
                return Double.toString(real)+" + i";
            }
        }
        else if(imag==-1.0)
        {
            if(real%1.0==0)
            {

                return Integer.toString(Math.round(Double.valueOf(real).floatValue()))+" - i";
            }
            else
            {
                return Double.toString(real)+" - i";
            }
        } else if (imag<0.0) {
            String realStr;
            if(real%1.0==0)
            {

                realStr= Integer.toString(Math.round(Double.valueOf(real).floatValue()));
            }
            else
            {
                realStr= Double.toString(real);
            }
            String imagStr;
            if(imag==1.0)
            {
                imagStr = "";
            } else if (imag==-1.0) {
                imagStr = "-";
            } else if(imag%1.0==0)
            {

                imagStr= Integer.toString(Math.round(Double.valueOf(Math.abs(imag)).floatValue()));
            }
            else
            {
                imagStr= Double.toString(Math.abs(imag));
            }

            return realStr+" - "+imagStr+"i";
        } else {
            String realStr;
            if(real%1.0==0)
            {

                realStr= Integer.toString(Math.round(Double.valueOf(real).floatValue()));
            }
            else
            {
                realStr= Double.toString(real);
            }
            String imagStr;
            if(real%1.0==0)
            {

                imagStr= Integer.toString(Math.round(Double.valueOf(imag).floatValue()));
            }
            else
            {
                imagStr= Double.toString(imag);
            }

            return realStr+" + "+imagStr+"i";
        }

    }
    public Complex times(double other)
    {
        return new Complex(real*other,imag*other);
    }
    public static Complex sqrt(Complex other)
    {

        return Complex.root(other,2*one);
    }
    public static Complex root(Complex other, Complex power)
    {
        return Complex.pow(other,one/power);
    }
    public static Complex cbrt(Complex other)
    {
        return Complex.root(other,new Complex(3));
    }
    public static Complex exp(Complex other)
    {
        return round(Math.exp(other.real)*new Complex(Math.cos(other.imag),Math.sin(other.imag)),10);
    }
    public static List<Complex> rootsOfUnity(int power)
    {
        List<Complex> roots = new ArrayList<>();
        for (int j = 0; j < power; j++) {
            roots.add(exp(new Complex(0,2*Math.PI*j/power)));
        }
        return roots;
    }


    @Override
    public int compareTo(Complex other) {

        if(this.real!=other.real)
        {
            return (int) Math.round(this.real-other.real);
        }
        else
        {
            return (int) Math.round(this.imag - other.imag);
        }
    }
    @Override
    public boolean compareToUsing(Complex other,Operator op)
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

    @Override
    public T add(T other) {
        return null;
    }

    @Override
    public T subtract(T other) {
        return null;
    }

    @Override
    public T multiply(T other) {
        return null;
    }

    @Override
    public T divide(T other) {
        return null;
    }

    @Override
    public T remainder(T other) {
        return null;
    }

    @Override
    public T negate() {
        return null;
    }

    @Override
    public Double doubleVal() {
        return 0.0;
    }

    @Override
    public T ln() {
        return null;
    }

    @Override
    public T exp() {
        return null;
    }
}
