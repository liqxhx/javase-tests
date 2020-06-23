package random;

import org.junit.Test;

import java.util.Random;

public class RandomTests {
    @Test
    public void test1() {
        // 种子一样每次运行结果也一样
        Random r = new Random(1000);
        for (int i = 1; i < 4; i++) {
            System.out.println("第" + i + "次:" + r.nextInt());

//            第1次:-1244746321
//            第2次:1060493871
//            第3次:-1826063944
        }
    }
}
