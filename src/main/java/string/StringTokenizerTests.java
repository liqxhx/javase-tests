package string;

import org.junit.Test;

import java.util.StringTokenizer;

/**
 * <p> ¿‡√Ë ˆ: TODO
 *
 * @author liqinghui
 * @version TODO
 * @date 2020/03/23 9:56
 * @since 2020/03/23 9:56
 */
public class StringTokenizerTests {

    @Test
    public void test() {
        String str = "09:27 ~ 17:00";
        StringTokenizer stringTokenizer = new StringTokenizer(str, " ~");
        while (stringTokenizer.hasMoreElements()) {
            System.out.println(stringTokenizer.nextElement());
        }
    }
}
