package core.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Rate {
    private String exchange;
    private float cost;

    @Override
    public String toString() {
        return String.format("Rate { exchange = '%s', cost = %f }", exchange, cost);
    }
}
