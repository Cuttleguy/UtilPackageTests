package util.math;

public class Radical<T extends Arithmetic<T>> implements Multipliable<Radical<T>>,Dividable<Radical<T>>{
    public Algebraic<T> body;
    public Rational<T> coefficient;
    public Integer power;

    Integer intTest=0;
    Algebraic<T> algTest=new Algebraic<>();
    Rational<T> ratTest= new Rational<T>();
    public Radical(Algebraic<T> newBody, Rational<T> newCoefficient,Integer newPower)
    {
        intTest=0;
        algTest=newBody.from(0);
        ratTest=newCoefficient.from(0);
        coefficient=newCoefficient;
        body=newBody;
        power=newPower;
    }
//    public Radical(Algebraic<T> newBody,Integer newPower)
//    {
//        intTest=0;
//        algTest=newBody.from(0);
//        ratTest=newCoefficient.from(0);
//        coefficient=ratTest.from(1.0);
//        body=newBody;
//        power=newPower;
//
//    }
//    public Radical(Algebraic<T> newBody,Rational<T> newCoefficient)
//    {
//        coefficient=newCoefficient;
//        body=newBody;
//        power=1;
//
//    }
//    public Radical(Rational<T> newCoefficient)
//    {
//        new Radical<T>();
//    }
    @Override
    public Radical<T> divide(Radical<T> other) {
        return multiply(other.invert());
    }

    @Override
    public Radical<T> multiply(Radical<T> other) {
        int LCM = intTest.lcm(power,other.power);
        int pow1 = LCM/power;
        int pow2 = LCM/other.power;
        return new Radical<>(algTest.pow(body,pow1).multiply(algTest.pow(other.body,pow2)),coefficient.multiply(other.coefficient),LCM);

    }

    @Override
    public Radical<T> from(Double other) {
        return new Radical<T>(algTest.from(other),ratTest,1);
    }

    @Override
    public Radical<T> from(Integer other) {
        return new Radical<T>(algTest.from(other),ratTest,1);

    }

    public Radical<T> invert()
    {
        return new Radical<>()
    }
}
