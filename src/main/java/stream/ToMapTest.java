package stream;

import lombok.Builder;
import lombok.Data;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
    @Rule
    public final TestName name = new TestName();

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
        Assert.assertEquals("testToMap", name.getMethodName());

        List<User> list = init(10);

        Map<Integer, List<User>> deptUsers = list.stream().collect(Collectors.groupingBy(User::getDeptId));
        Assert.assertEquals(deptUsers.size(), 2);
        System.out.println(deptUsers);
    }

}
