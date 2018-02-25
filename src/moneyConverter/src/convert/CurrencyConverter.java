package convert;

import currency.*;

public class CurrencyConverter {

    public static double convert(double count, MyCurrency currency1, MyCurrency currency2) {
        double result = count / currency1.getCourseRelativeToGold();
        result *= currency2.getCourseRelativeToGold();
        return result;
    }
}
