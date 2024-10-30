package util.math;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;

public class Algebraic<T extends Arithmetic<T>> implements Arithmetic<Algebraic<T>>{
    T constant;
    List<Radical<T>> radicals;
    public Algebraic(List<Radical<T>> newRadicals)
    {
        radicals=newRadicals;
    }
    public Algebraic()
    {
        radicals=new ArrayList<>();
    }

    @Override
    public Algebraic<T> add(Algebraic<T> other) {
        return null;
    }

    @Override
    public Algebraic<T> subtract(Algebraic<T> other) {
        return null;
    }

    @Override
    public Algebraic<T> multiply(Algebraic<T> other) {
        return null;
    }

    @Override
    public Algebraic<T> divide(Algebraic<T> other) {
        return null;
    }

    @Override
    public Algebraic<T> remainder(Algebraic<T> other) {
        return null;
    }

    @Override
    public Algebraic<T> negate() {
        return null;
    }

    @Override
    public Double doubleVal() {
        return 0.0;
    }

    @Override
    public Algebraic<T> ln(Algebraic<T> other) {
        return null;
    }

    @Override
    public Algebraic<T> exp(Algebraic<T> other) {
        return null;
    }

    @Override
    public Algebraic<T> cos(Algebraic<T> other) {
        return null;
    }

    @Override
    public Algebraic<T> sin(Algebraic<T> other) {
        return null;
    }

    @Override
    public Algebraic<T> cosh(Algebraic<T> other) {
        return null;
    }

    @Override
    public Algebraic<T> sinh(Algebraic<T> other) {
        return null;
    }

    @Override
    public Algebraic<T> sec(Algebraic<T> other) {
        return null;
    }

    @Override
    public Algebraic<T> csc(Algebraic<T> other) {
        return null;
    }

    @Override
    public Algebraic<T> tan(Algebraic<T> other) {
        return null;
    }

    @Override
    public Algebraic<T> tanh(Algebraic<T> other) {
        return null;
    }

    @Override
    public Algebraic<T> cot(Algebraic<T> other) {
        return null;
    }

    @Override
    public Algebraic<T> coth(Algebraic<T> other) {
        return null;
    }

    @Override
    public Algebraic<T> sech(Algebraic<T> other) {
        return null;
    }

    @Override
    public Algebraic<T> csch(Algebraic<T> other) {
        return null;
    }

    @Override
    public boolean lt(Algebraic<T> other) {
        return false;
    }

    @Override
    public boolean le(Algebraic<T> other) {
        return false;
    }

    @Override
    public boolean gt(Algebraic<T> other) {
        return false;
    }

    @Override
    public boolean ge(Algebraic<T> other) {
        return false;
    }

    @Override
    public Algebraic<T> sqrt() {
        return null;
    }

    @Override
    public Algebraic<T> from(Double other) {
        return null;
    }

    @Override
    public Algebraic<T> from(Integer other) {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Algebraic<?> that = (Algebraic<?>) o;
        return Objects.equals(radicals, that.radicals) && Objects.equals(constant,that.constant);
    }



    @Override
    public int hashCode() {
        return Objects.hashCode(radicals);
    }

}
