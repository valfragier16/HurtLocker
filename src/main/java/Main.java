
import org.apache.commons.io.IOUtils;

import java.util.Objects;


public class Main{
    private String file;

    public Main(String file) {
        this.file = file;
    }

    public Main() {

    }

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        return IOUtils.toString(Objects.requireNonNull(classLoader.getResourceAsStream("RawData.txt")));
    }
    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        String parsed = (new JerkSONParser(output)).parse();
        System.out.println(parsed);
    }




}
