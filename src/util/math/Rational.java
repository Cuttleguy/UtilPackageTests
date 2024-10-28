package util.math;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

import static util.math.MathUtil.findGCD;

public class Rational<T extends Arithmetic<T>> implements Arithmetic<Rational<T>> {
    public T numerator;
    public T denominator;
    T test;
    public Rational(T newNumerator, T newDenominator)
    {

        numerator=newNumerator;
        test=numerator.from(0.0);
        if(Objects.equals(newDenominator,test.from(0.0)))
        {
            throw new RuntimeException("Cannot Divide By Zero");
        }
        denominator=newDenominator;
        T gcd = test.gcf(numerator,denominator);
        numerator=numerator.divide(gcd);
        denominator=denominator.divide(gcd);


    }
    public Rational(T newNumerator)
    {

        numerator=newNumerator;
        denominator=numerator.from(1.0);
        test=numerator.from(0.0);
    }
    @Override
    public Rational<T> add(Rational<T> other) {
        return new Rational<>(numerator.multiply(other.denominator).add(other.numerator.multiply(denominator)),denominator.multiply(other.denominator));
    }
    public Rational<T> plus(Rational<T> other)
    {
        return this.add(other);
    }

    @Override
    public Rational<T> subtract(Rational<T> other) {
        return this+other.negate();
    }
    public Rational<T> minus(Rational<T> other)
    {
        return this.subtract(other);
    }

    @Override
    public Rational<T> multiply(Rational<T> other) {
        return new Rational<>(numerator.multiply(other.numerator),denominator.multiply(other.denominator));
    }
    public Rational<T> times(Rational<T> other)
    {
        return this.multiply(other);
    }
    @Override
    public Rational<T> divide(Rational<T> other) {
        return this*other.invert();
    }
    public Rational<T> invert()
    {
        return new Rational<>(denominator,numerator);
    }
    public Rational<T> div(Rational<T> other)
    {
        return this.divide(other);
    }
    public Rational<T> unaryMinus()
    {
        return this.negate();
    }
    @Override
    public Rational<T> remainder(Rational<T> other) {
        if(Objects.equals(other,test.from(1.)))
        {
            if(denominator==test.from(1))
            {
                return new Rational<>(test.from(0));
            }
            else
            {
                return new Rational<>(test.from(1));
            }

        }
        return null;
    }

    @Override
    public Rational<T> negate() {
        return new Rational<>(numerator.negate(),denominator);
    }

    @Override
    public Double doubleVal() {
        return numerator.divide(denominator).doubleVal();
    }

    @Override
    public Rational<T> ln(Rational<T> other) {
        return new Rational<>(test.ln(numerator).subtract(test.ln(denominator)));
    }

    @Override
    public Rational<T> exp(Rational<T> other) {
        return new Rational<>(test.from(1).add(test.from(2).divide(test.from(-1).add(test.coth(other.numerator.divide(test.from(2).multiply(other.denominator)))))));
    }

    @Override
    public Rational<T> cos(Rational<T> other) {
        return new Rational<>(test.cos(other.numerator.divide(other.denominator)));
    }

    @Override
    public Rational<T> sin(Rational<T> other) {
        return new Rational<>(test.sin(other.numerator.divide(other.denominator)));

    }

    @Override
    public Rational<T> cosh(Rational<T> other) {
        return new Rational<>(test.cosh(other.numerator.divide(other.denominator)));

    }

    @Override
    public Rational<T> sinh(Rational<T> other) {
        return new Rational<>(test.sinh(other.numerator.divide(other.denominator)));
    }

    @Override
    public Rational<T> sec(Rational<T> other) {
        return new Rational<>(test.sec(other.numerator.divide(other.denominator)));

    }

    @Override
    public Rational<T> csc(Rational<T> other) {
        return new Rational<>(test.csc(other.numerator.divide(other.denominator)));

    }

    @Override
    public Rational<T> tan(Rational<T> other) {
        return new Rational<>(test.tan(other.numerator.divide(other.denominator)));

    }

    @Override
    public Rational<T> tanh(Rational<T> other) {
        return new Rational<>(test.tanh(other.numerator.divide(other.denominator)));

    }

    @Override
    public Rational<T> cot(Rational<T> other) {
        return new Rational<>(test.cot(other.numerator.divide(other.denominator)));

    }

    @Override
    public Rational<T> coth(Rational<T> other) {
        return new Rational<>(test.coth(other.numerator.divide(other.denominator)));

    }

    @Override
    public Rational<T> sech(Rational<T> other) {
        return new Rational<>(test.sech(other.numerator.divide(other.denominator)));

    }

    @Override
    public Rational<T> csch(Rational<T> other) {
        return new Rational<>(test.csch(other.numerator.divide(other.denominator)));

    }

    @Override
    public boolean lt(Rational<T> other) {
        return this.numerator.multiply(other.denominator).lt(other.numerator.multiply(this.denominator));
    }

    @Override
    public boolean le(Rational<T> other) {
        return this.numerator.multiply(other.denominator).le(other.numerator.multiply(this.denominator));
    }
    public String toString()
    {
        if(test instanceof Double || test instanceof Integer)
        {
            return "("+numerator.doubleVal().toString()+"/"+denominator.doubleVal().toString()+")";

        }
        return "("+numerator.toString()+"/"+denominator.toString()+")";

    }


    @Override
    public boolean gt(Rational<T> other) {
        return this.numerator.multiply(other.denominator).gt(other.numerator.multiply(this.denominator));
    }

    @Override
    public boolean ge(Rational<T> other) {
        return this.numerator.multiply(other.denominator).ge(other.numerator.multiply(this.denominator));
    }

    @Override
    public Rational<T> sqrt() {
        return new Rational<>(numerator.sqrt(),denominator.sqrt());

    }

    @Override
    public Rational<T> from(Double other) {
        Long numerator2 = Math.round(other * 1000000000L); // Adjust precision as needed
        Long denominator2 = 1000000000L;

        Long gcd = findGCD(numerator2, denominator2);
        numerator2 /= gcd;
        denominator2 /= gcd;
        return new Rational<>(test.from(numerator2.intValue()),test.from(denominator2.intValue()));
    }

    @Override
    public Rational<T> from(Integer other) {
        return new Rational<>(test.from(other));
    }



//    public Polynomial numerator;
//    public Polynomial denominator;
//    public Rational(Polynomial newNumerator, Polynomial newDenominator)
//    {
//        if (newDenominator.isZero())
//        {
//
//            throw new ArithmeticException("Cannot Divide By Zero. Fraction is: "+newNumerator+"/"+newDenominator);
//        }
//
//        Polynomial gcf=Polynomial.gcf(newNumerator,newDenominator);
//
//        numerator=newNumerator/gcf;
//        denominator=newDenominator/gcf;
////        List<Complex> coefficients = newNum.coefficients();
////        List<Complex> denCoef = newDen.coefficients();
////        coefficients.addAll(denCoef);
////        double lcm=MathUtil.findLCMMultiplier(coefficients);
////        System.out.println("LCM: "+lcm);
////        numerator=newNum*(new Monomial(new Complex(lcm)));
////        denominator=newDen*(new Monomial(new Complex(lcm)));
//


//    }
//    public Complex plugIn(Complex x)
//    {
//        return numerator.plugIn(x)/denominator.plugIn(x);
//    }
//    public Rational derivative()
//    {
//        return new Rational(numerator.derivative()*denominator-numerator*denominator.derivative(),denominator*denominator);
//    }
//
//    public Rational(Polynomial newNumerator)
//    {
//        numerator=newNumerator;
//        denominator=Polynomial.one;
//
//
//    }
//    public boolean isPoly()
//    {
//        boolean found = false;
//        for(Monomial monomial : denominator.monomials)
//        {
//            if(!Objects.equals(monomial.coefficient, new Complex(0.0)))
//            {
//                if(found)
//                {
//                    return false;
//                }
//                else
//                {
//                    if(monomial.exponent!=0.0)
//                    {
//                        return false;
//                    }
//                    else {
//                        found = true;
//                    }
//                }
//            }
//        }
//        return true;
//    }
//    public String toString()
//    {
//        return "("+numerator.toString()+") / ("+denominator.toString()+")";
//    }
//
//    public static Rational pow(Rational a, Rational b)
//    {
//        if(!b.isPoly())
//        {
//            throw new RuntimeException("No Exponential Roots");
//        }
//        else if(!b.numerator.isConstant())
//        {
//            throw new RuntimeException("No Exponentials");
//        } else if (b.numerator.getConstant()%1.0!=0.0) {
//            throw new RuntimeException("No Rooting 2: "+b.numerator.getConstant());
//        }
//        else
//        {
//            int power = Double.valueOf(b.numerator.getConstant()).intValue();
//
//            Rational toReturn= new Rational(new Polynomial(new Monomial(new Complex(1.0),0)));
//            for (int i = 0; i < power; i++) {
//                toReturn*=a;
//            }
//            return toReturn;
//        }
//
//    }
//    public Rational plus(Rational other)
//    {
//        return new Rational(numerator*other.denominator+denominator*other.numerator,denominator*other.denominator);
//    }
//    public Rational minus(Rational other)
//    {
//
//        return this+ (-other);
//
//    }
//    public Rational unaryMinus()
//    {
//
//        return new Rational(-this.numerator,this.denominator);
//    }
//
//    public Rational times(Rational other)
//    {
//        return new Rational(numerator*other.numerator,denominator*other.denominator);
//    }
//    public Rational invert()
//    {
//        return new Rational(denominator,numerator);
//    }
//    public Rational div(Rational other)
//    {
//
//        return this*other.invert();
//    }
//    public Rational plus(Polynomial other)
//    {
//        return this+new Rational(other);
//    }
//    public Rational minus(Polynomial other)
//    {
//        return this-new Rational(other);
//    }
//    public Rational times(Polynomial other)
//    {
//        return this*new Rational(other);
//    }
//    public Rational div(Polynomial other)
//    {
//        return this/new Rational(other);
//    }
//    public List<Complex> solve() {
//        List<Complex> numSolutions = numerator.solve();
//        if (denominator.isConstant()) {
//            return numSolutions;
//        } else {
//            List<Complex> denSolutions = denominator.solve();
//            List<Complex> roots = new ArrayList<>();
//            for (Complex numRoot : numSolutions) {
//                if (!denSolutions.contains(numRoot)) {
//                    roots.add(numRoot);
//                }
//            }
//            return roots;
//        }
//    }

}
