import java.io.*;
import java.net.URL;

public class CopyGoogle {
    //public static void main(String[] args) throws IOException {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new URL("https://google.com").openStream();
        //File file = new File ("C:\\test\\test.txt");
        //InputStream inputStream = new FileInputStream(file);
        OutputStream outputStream = System.out;
        copy(inputStream, outputStream);

        File file = new File ("C:\\test\\"+"myfile.txt");
        //file.mkdirs();
        FileWriter writer = new FileWriter(file);
        writer.write("new text");
        writer.flush();
        writer.close();



    }

    private static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {

            byte[] buff = new byte[64 * 1024];

            while (inputStream.available() > 0) {
                int count = inputStream.read(buff);
                outputStream.write(buff, 0, count);
            }
            inputStream.close();
            outputStream.close();
        }

}
