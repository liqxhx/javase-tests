package stream;

import lombok.Builder;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p> 类描述: TODO
 *
 * @author liqxhx
 * @version TODO
 * @date 2019/12/12 15:47
 * @since 2019/12/12 15:47
 */
public class ToMapTest {

    @Data
    @Builder
    static class User {
        private Integer deptId;
        private Integer id;
        private String name;
        public String toString() {
            return String.valueOf(id);
        }
    }

    private List<User> init(int size){
        List<User> list = new ArrayList(size);
        for(int i = 0 ;i < size; i++) {
            list.add(User.builder().id(i + 1).deptId((i +1) % 2).build());
        }

        return list;
    }

    @Test
    public void testToMap() {
        List<User> list = init(10);

        System.out.println(list.stream().collect(Collectors.groupingBy(User::getDeptId)));
    }

}
