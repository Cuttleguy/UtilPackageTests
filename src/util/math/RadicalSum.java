package util.math;

import java.util.List;
import java.util.Objects;

public class RadicalSum<T extends Arithmetic<T>> implements Arithmetic<RadicalSum<T>>{
    List<Radical<T>> radicals;
    public RadicalSum(List<Radical<T>> newRadicals)
    {
        radicals=newRadicals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RadicalSum<?> that = (RadicalSum<?>) o;
        return Objects.equals(radicals, that.radicals);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(radicals);
    }

}
