package core.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class Exchange {

    private String base;
    private List<Rate> rates;
    private LocalDate date;

    @Override
    public String toString() {
        Collections.sort(rates);
        return String.format("Exchange { base = '%s', rates = {" + rates + "}, date = '%s' }", base, date);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exchange exchange = (Exchange) o;
        return Objects.equals(base, exchange.base) &&
                Objects.equals(rates, exchange.rates) &&
                Objects.equals(date, exchange.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(base, rates, date);
    }
}
