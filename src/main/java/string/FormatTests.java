package string;

import org.junit.Test;

/**
 * <p> 类描述: TODO
 *
 * @author qhlee
 * @version TODO
 * @date 2019/12/25 10:25
 * @since 2019/12/25 10:25
 */
public class FormatTests {
    @Test
    public void testFormat() {
        String content = "a=%s,b=%s";
        System.out.println(String.format(content, 1, "h"));
    }
}
