package string;

/**
 * 类描述: TODO
 *
 * @author liqh
 * @version TODO
 * @date 2019/01/23 15:12
 * @since 2019/01/23 15:12
 */
public class SplitTest {
    /**
    * main
    */
    public static void main(String[] args){
        String str = "a,b,c,,";
        System.out.println(str.split(",").length);              // 3
        System.out.println(str.split(",", -1).length);    // 5
    }
}
