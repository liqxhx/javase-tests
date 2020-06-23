package io.linecounter;

import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * <p> 类描述: Dir Node
 *
 * @author qhlee
 * @version 1.0
 * @date 2020/06/23 21:32
 * @since 2020/06/23 21:32
 */
public class LineCounterTest {
    @Test
    public void testLineCounter() throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Node node = Node.getInstance("/Users/liqh/src/java/javase-tests/src/main/java/io/linecounter") ;
        node.countLine();
        node.output();

    }
}
