package collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 类描述: TODO
 *
 * @author liqh
 * @version TODO
 * @date 2019/01/23 15:08
 * @since 2019/01/23 15:08
 */
public class RemoveTests {

    /**
    * main
    */
    public static void main(String[] args){

//        arrayListRemove();

        linkedListRemove();
    }

    /**
     * 总结：array list.remove只能删除index=size-2(倒数第二个)的不重复的元素，删除其他元素会报ConcurrentModificationException
     */
    private static void arrayListRemove(){
        List<String> list = new ArrayList<>();
        list.add("1");
//        list.add("2");
        list.add("2");
        list.add("3");

        for (String item : list) {
//            if("1".equals(item)) list.remove(item); // Exception in thread "main" java.util.ConcurrentModificationException
            if ("2".equals(item)) list.remove(item); // [1, 3]
//            if("3".equals(item)) list.remove(item);     // Exception in thread "main" java.util.ConcurrentModificationException
        }

        System.out.println(list);
    }

    private static void linkedListRemove(){
        List<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
//        list.add("2");

        for (String item : list) {
            // ConcurrentModificationException
//            if ("1".equals(item)) {
//                list.remove(item);
//            }

            // 如果有重复元素 报ConcurrentModificationException
            // 非首个元素，且没有重复元素，删除成功
//            if ("2".equals(item)) {
//                list.remove(item);
//            }


            if ("3".equals(item)) {
                list.remove(item);
            }
        }

        System.out.println(list);

    }
}
