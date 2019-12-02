
import org.apache.commons.io.IOUtils;

import java.util.Objects;


public class Main{

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
