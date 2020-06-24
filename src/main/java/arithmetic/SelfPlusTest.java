package arithmetic;

import org.junit.Assert;
import org.junit.Test;

/**
 * <p> 类描述:
 *
 * @author qhlee
 * @version 1.0
 * @date 2020/06/24 18:08
 * @since 2020/06/24 18:08
 */
public class SelfPlusTest {
    @Test
    public void testPostPlusPlus() {
        int a = 1;
        Assert.assertTrue(a++ < 2);
        Assert.assertEquals(a, 2);
    }
}
