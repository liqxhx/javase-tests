package dict;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * <p> 类描述: TODO
 *
 * @author liqinghui
 * @version TODO
 * @date 2019/02/26 17:01
 * @since 2019/02/26 17:01
 */
public class DictionaryGeneratorTest {

    @Test
    public void testDictionary() {
        System.err.println(Dictionary.Binary.Bool.exists("true", true));
        System.err.println(Dictionary.Binary.Bool.exists("false", true));
        System.err.println(Dictionary.Binary.Bool.exists("假", false));
        System.err.println(Dictionary.Binary.Bool.exists(1, true));
        System.err.println(Dictionary.Binary.Bool.exists(true, true));
        System.err.println(Dictionary.Binary.Bool.exists(false, false));
        System.err.println(Dictionary.Binary.Bool.exists(false));
        System.err.println(Dictionary.Binary.Bool.exists("true"));
        System.err.println(Dictionary.Binary.Bool.exists("假"));
        System.err.println(Dictionary.Binary.Bool.exists("6"));
    }

    @Test
    public void testGenFromFile() throws Exception {

        File file = new File(System.getProperty("user.dir"), "src/main/java/dict/dict.txt");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));


        String line = null;

        List<Dict> dictList = new ArrayList<Dict>();
        while((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
            if(line == null || "".equals(line.trim())) continue;

            String[] arr = line.split(",");
            if("1".equals(arr[6])) continue;
// 4, 0, Blacklist, Direction, 0, 双向, 2, BOTH, 0, 0, , , 2019-02-21 15:15:13, 2019-02-21 15:15:13
            Dict dict = new Dict();
            dict.setId(Integer.valueOf(arr[0].trim()));
            dict.setPid(Integer.valueOf(arr[1].trim()));
            dict.setDomain(arr[2]);
            dict.setType(arr[3]);
            dict.setValue(arr[4]);
            dict.setName(arr[5]);
            dict.setEnable(Integer.valueOf(arr[6].trim()));
            dict.setLabel(arr[7]);
            dictList.add(dict);

        }

        System.out.println(DictionaryGenerator.gen(dictList));


    }
}
