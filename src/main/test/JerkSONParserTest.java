import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class JerkSONParserTest {
    private String jerkSONText;

    @Before
    public void setup() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        this.jerkSONText = IOUtils.toString(Objects.requireNonNull(classLoader.getResourceAsStream("RawData.txt")));

    }

    @Test
    public void nameTest() {
        Pattern p = Pattern.compile("(?i)name:(\\w+)");
        Matcher m = p.matcher(jerkSONText);

        while (m.find()) {
            System.out.println(m.group(1));
        }

    }

    @Test
    public void namepriceTest() {
        Pattern p = Pattern.compile("(?i)name:(\\w+)\\Wprice:(\\w+[.]\\w+)");
        Matcher m = p.matcher(jerkSONText);

        while (m.find()) {
            System.out.println(m.group(1) + "\t\t" + m.group(2));
        }

    }

    @Test
    public void expirationTest() {
        // expiration format 1/25/2016
        Pattern p = Pattern.compile("(?i)expiration:(\\w+[/]\\w+[/]\\w+)");
        Matcher m = p.matcher(jerkSONText);

        while (m.find()) {
            System.out.println(m.group(1));
        }

    }


}
