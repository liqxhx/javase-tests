package collection;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <p> todo 写点注释吧
 *
 * @author liqh
 * @version 1.0
 * @date 2021/7/13 0013 14:57
 * @since 2021/7/13 0013 14:57
 */
public class MapTests {
    @Test
    public void testComputeIfPresent() {
        List<String> list = Arrays.asList("aa", "bbb", "aa", "bb", "ccc");
        Map<String, Integer> counter = new HashMap<>(8);

        list.forEach(item -> {
            counter.computeIfPresent(item, (k, v) -> v + 1);

            Integer c = counter.computeIfAbsent(item, k -> {
                System.out.println("key: " + item + ", value:" + null);
                return 1;
            });
            System.out.println("key: " + item + ", value:" + c);
        });

        System.out.println(counter);
    }

    @Test
    public void testcollectToMap() {
        List<String> list = Arrays.asList("aa", "bbb", "aa", "bb", "ccc");

        Map<String, Integer> counter1 = list.stream().collect(Collectors.toMap((k) -> k, (k) -> 1,  (o, n) -> o + n));
        System.out.println(counter1);

        Map<String, Integer> counter2 = list.stream().collect(Collectors.toMap((k) -> k, (k) -> 1,  (o, n) -> o + n , HashMap::new));
        System.out.println(counter2);

    }

    @Test
    public void testJoining() {
        List<String> list = Arrays.asList("aa", "bbb", "aa", "bb", "ccc");

        System.out.println(list.stream().collect(Collectors.joining(",")));
    }

    @Test
    public void testReduce() {
        List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5, 6);
        ArrayList<String> result = numList.stream().reduce(new ArrayList<String>(), (a, b) -> {
            System.out.println(a.getClass().getName());
            System.out.println(a);
            System.out.println(b);
            a.add("element-" + Integer.toString(b));
            return a;
        }, (a, b) -> null);
        System.out.println(result);



        List<Integer> numList2 = Arrays.asList(Integer.MAX_VALUE,Integer.MAX_VALUE);
        System.out.println(numList2.stream().reduce(0, (a,b) ->  a + b)); // -2
        long result2 = numList2.stream().reduce(0L,(a,b) ->  a + b, (a,b)-> 0L ); // 4294967294
        System.out.println(result2);
    }
}
