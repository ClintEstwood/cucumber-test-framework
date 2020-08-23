package pages;

import java.util.Arrays;

public enum Pages {
    EUROPEAN_CENTRAL_BANK_MAIN("European Central Bank Main"),
    ECB_EUROSYSTEM_POLICY_AND_EXCHANGE_RATES("ECB/Eurosystem policy and exchange rates");

    private String pageLabel;

    Pages(String pageLabel){
        this.pageLabel = pageLabel;
    }

    public Pages getPageByLabel(String pageLabel){
        return Arrays.stream(values())
                .filter(e -> e.pageLabel.equals(pageLabel))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(String.format("Unknown page with label %s.", pageLabel)));
    }
}
