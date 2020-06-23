package string;

import org.junit.Test;

/**
 * <p> 类描述: TODO
 *
 * @author qhlee
 * @version TODO
 * @date 2019/12/24 15:17
 * @since 2019/12/24 15:17
 */
public class IndexOfTests {
    @Test
    public void testIndexOf() {
        String content = "1,2,3,4";
        System.out.println(content.indexOf(","));

        System.out.println(content.substring(0, content.indexOf(",")));

        content = "2";
        System.out.println(content.indexOf(","));
//        System.out.println(content.substring(0, content.indexOf(",")));
    }
}
