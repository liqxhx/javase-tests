package regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

/**
 * <p> 类描述: TODO
 *
 * @author qhlee
 * @version TODO
 * @date 2020/05/09 22:50
 * @since 2020/05/09 22:50
 */
public class TestPattern {
    @Test
    public void testString() {
        String ptn = "plat|oms|ums";
        System.out.println("platomsums".matches(ptn));
        System.out.println("plat".matches(ptn));
        System.out.println("plata".matches(ptn));
    }

    @Test
    public void testIntIn() {
        String ptn = "[1-4]{1}";

        System.out.println("1".matches(ptn));
        System.out.println("2".matches(ptn));
        System.out.println("123".matches(ptn));
        System.out.println("21".matches(ptn));
//        System.out.println(Pattern.compile(ptn).matcher("1").find());
    }

    @Test
    public void testInt() {
        String ptn = "[1]{1}";

        System.out.println("1".matches(ptn));
        System.out.println("123".matches(ptn));
        System.out.println("21".matches(ptn));
//        System.out.println(Pattern.compile(ptn).matcher("1").find());
    }

    @Test
    public void test() {
        //String content = "WX-33973-百度家电I";
        String content = "WX33973-百度家电I";

        Pattern channelPattern = compile("WX\\D{0,1}(\\d+)");
        Matcher m = channelPattern.matcher(content);

        if(m.find()) {
            System.out.println(m.group(1));
        } else {
            System.out.println("not find");
        }

    }
}
