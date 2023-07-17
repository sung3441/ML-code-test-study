import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class test {
    public static void main(String[] args) throws Exception{
        byte[] bytes = {1,2,3,4,5,6,76,7,4};
        InputStream inputStream = new ByteArrayInputStream(bytes);
        int data;
        while((data = inputStream.read()) != -1) {
            System.out.print(data);
        }
        System.out.println();
        while((data = inputStream.read()) != -1) {
            System.out.println(data);
        }

    }
}
