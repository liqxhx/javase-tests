package jdk7;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * 可以使用try-with-resources的资源有：
 * 任何实现了java.lang.AutoCloseable 接口java.io.Closeable 接口的对象
 * try (Closeable obj = new Closeable() {
 *
 * @Override public void close() throws IOException {
 * // do something
 * }
 * }) {
 * // do something
 * }
 * <p>
 * try (AutoCloseable obj = new AutoCloseable() {
 * @Override public void close() throws IOException {
 * // do something
 * }
 * }) {
 * // do something
 * }
 * <p>
 * 另外，一个try-with-resourcse声明了可以包含多个对象的声明，用分号隔开，和声明一个对象相同，
 * 会在结束后自动调用close方法，调用顺序和声明顺序相反
 */
public class TryWithResourceTests {

    public String readFirstLineFrom(String fileName) throws Exception {

        try (BufferedReader br = new BufferedReader(new FileReader(fileName));
             AutoCloseable autoCloseable = new AutoCloseable() {
                 @Override
                 public void close() throws Exception {

                     System.out.println("close");
                 }
             }
        )

        {
            return br.readLine();
        }


    }
}
