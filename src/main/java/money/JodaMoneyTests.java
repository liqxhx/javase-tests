package money;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.Test;

import java.math.RoundingMode;

/**
 * <p> ¿‡√Ë ˆ: Joda Money Tests
 *
 * @author liqxhx
 * @version 1.0
 * @date 2020/03/17 13:52
 * @since 2020/03/17 13:52
 */
public class JodaMoneyTests {
    @Test
    public void testSalary() {
        Money total = Money.parse("CNY 17050");

        CurrencyUnit cny = CurrencyUnit.of("CNY");
        Money dailyPay = total.dividedBy(26.0, RoundingMode.HALF_UP);
        System.out.println(dailyPay);
    }


    @Test
    public void testCalc() {
        //
        double a = 635.42;
        System.out.println(a);

        double b1 = a * 9;
        System.out.println(b1);

        double b2 = a * 5;
        System.out.println(b2);

        double c = a * 9 * 0.7;
        System.out.println(c);

        System.out.println(a * 0.7);

        System.out.println(b1 + b2 + c);

        System.out.println( 14698.95 - 349.61);

        System.out.println( 14698.95 - 349.61 -552.40 + 724.93);
    }

}
