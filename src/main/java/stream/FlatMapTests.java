package stream;

import org.junit.Test;

import java.util.Arrays;

/**
 * <p> 类描述: TODO
 *
 * @author liqxhx
 * @version TODO
 * @date 2020/03/11 21:38
 * @since 2020/03/11 21:38
 */
public class FlatMapTests {
    @Test
    public void tetFlagtMap() {
        Arrays.asList("s1", "s2", "s3").stream()
                .map(s -> Arrays.asList(s))
                .flatMap(l -> l.stream())
                .forEach(System.out::println);

        Arrays.stream(new String[]{"s1", "s2", "s3"})
                .map(s -> Arrays.asList(s))
                .flatMap(l -> l.stream())
                .forEach(System.out::println);
    }

}
