package stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p> 类描述: TODO
 *
 * @author liqxhx
 * @version 1.0
 * @date 2020/03/11 21:38
 * @since 2020/03/11 21:38
 */
public class FlatMapTests {
    @Test
    public void testFlagtMap() {
        Arrays.asList("s1", "s2", "s3").stream()
                .map(s -> Arrays.asList(s))
                .flatMap(l -> l.stream())
                .forEach(System.out::println);

//        Arrays.stream(new String[]{"s1", "s2", "s3"})
//                .map(s -> Arrays.asList(s))
//                .flatMap(l -> l.stream())
//                .forEach(System.out::println);

        //
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        List<Integer> b = new ArrayList<>();
        b.add(3);
        b.add(4);
        List<Integer> figures = Stream.of(a, b).flatMap(u -> u.stream()).collect(Collectors.toList());
        figures.forEach(System.out::println);
    }

}
