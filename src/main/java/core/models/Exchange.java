package core.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Exchange {

    private String base;
    private List<Rate> rates;
    private String date;

    @Override
    public String toString() {
        return String.format("Exchange { base = '%s', rates = {" + rates + "}, date = '%s' }", base, date);
    }

}
