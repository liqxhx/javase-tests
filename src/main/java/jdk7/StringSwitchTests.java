package jdk7;

import org.junit.Test;

/**
 * 每个case是使用String的equals方法来进行比较的，对大小写敏感。
 * 和一连串的if-else-then想比，使用switch来计较String，Java编译器会生成更加有效的字节码
 * 可以使用javap来比较两者字节码
 * http://www.iteye.com/topic/1113267
 */
public class StringSwitchTests {
    @Test
    public void testSwitch() {
        //项目状态
        String status = "approval";
        //我们之前经常根据项目状态不同来进行不同的操作
        //目前已经换成enum类型

        switch (status) {
            case "shouli":
                System.out.println("状态是受理");
                break;
            case "approval":
                System.out.println("状态是审批");
                break;
            case "finish":
                System.out.println("状态是结束");
                break;
            default:
                System.out.println("状态未知");
        }
    }

}
