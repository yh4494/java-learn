import java.io.*;

public class TryResrource {

    public static void main(String[] args) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File(""));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (InputStream inputStream2 = new FileInputStream(new File(""))) {
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
