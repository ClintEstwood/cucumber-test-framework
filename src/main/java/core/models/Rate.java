package core.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
public class Rate implements Comparable<Rate> {
    private String exchange;
    private float cost;

    @Override
    public String toString() {
        return String.format("Rate { exchange = '%s', cost = %f }", exchange, cost);
    }

    @Override
    public int compareTo(Rate rate) {
        if (getExchange() == null || rate.getExchange() == null) {
            return 0;
        }
        return getExchange().compareTo(rate.getExchange());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rate rate = (Rate) o;
        return Float.compare(rate.cost, cost) == 0 &&
                Objects.equals(exchange, rate.exchange);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exchange, cost);
    }
}
