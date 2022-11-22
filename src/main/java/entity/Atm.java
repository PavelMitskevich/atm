package entity;

import java.math.BigDecimal;

public class Atm {

    private BigDecimal cash;

    public BigDecimal getCash() {
        return cash;
    }

    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Atm{");
        sb.append("cash=").append(cash);
        sb.append('}');
        return sb.toString();
    }
}
