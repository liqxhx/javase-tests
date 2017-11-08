package jdk7;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 用一个catch处理多个异常，比用多个catch每个处理一个异常生成的字节码要更小更高效。
 * 在生成的异常表中，跳转target值都一样
 */
public class MutiCatchTests {


    public void 捕获多种异常(String sqlfile) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(sqlfile));
            Connection con = null;
            Statement stmt = con.createStatement();
        } catch (IOException | SQLException e) {
            //捕获多个异常，e就是final类型的
            e.printStackTrace();
        }
    }

    @Test
    public void 类型推断() {
        List<String> list = new ArrayList<>();
        list.add("A");

        list.addAll(new ArrayList<>());


        List<? extends String> list2 = new ArrayList<>();
        list.addAll(list2);
    }
}
