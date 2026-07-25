package org.example.util;

import com.google.protobuf.Timestamp;
import ru.tinkoff.piapi.contract.v1.MoneyValue;
import ru.tinkoff.piapi.contract.v1.Quotation;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public final class TBankUtils {

    private TBankUtils() {
    }

    /**
     * Quotation -> double
     */
    public static double toDouble(Quotation quotation) {

        return quotation.getUnits()
                + quotation.getNano() / 1_000_000_000.0;
    }

    /**
     * MoneyValue -> double
     */
    public static double toDouble(MoneyValue money) {

        return money.getUnits()
                + money.getNano() / 1_000_000_000.0;
    }

    /**
     * Timestamp -> LocalDate
     */
    public static LocalDate toLocalDate(Timestamp timestamp) {

        return Instant.ofEpochSecond(timestamp.getSeconds())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    /**
     * Цена облигации в рублях
     * (price приходит в процентах от номинала)
     */
    public static double cleanPrice(
            Quotation quotation,
            MoneyValue nominal) {

        return toDouble(nominal) * toDouble(quotation) / 100.0;
    }

    /**
     * Полная цена покупки
     */
    public static double dirtyPrice(
            Quotation quotation,
            MoneyValue nominal,
            MoneyValue aci) {

        return cleanPrice(quotation, nominal)
                + toDouble(aci);
    }

    /**
     * Округление денежных значений
     */
    public static double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

}
