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
    public void myTest() {
        Pattern p = Pattern.compile("(?i)name:(\\w+)\\Wprice:(\\w+[.]\\w+)");
        Matcher m = p.matcher(jerkSONText);

        while (m.find()) {
            System.out.println(m.group(1) + "\t\t" + m.group(2));
        }

    }

}
