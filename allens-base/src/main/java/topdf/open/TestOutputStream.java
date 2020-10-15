package topdf.open;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Description 普通类
 * @Author Allens
 * @Date 2020-10-14 16:52
 * @Version V1.0
 */
public class TestOutputStream {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/allens/package/test.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        String a = "11222212112";
        fileOutputStream.write(a.getBytes());

    }

}
