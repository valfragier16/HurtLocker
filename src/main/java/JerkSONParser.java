import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JerkSONParser {

    private String jerksonStr;

    public JerkSONParser(String jerksonStr) {
        this.jerksonStr = jerksonStr;
    }

    public String parse() {
        ListMap list = new ListMap();
        Pattern p = Pattern.compile(
                "(?i)name:(\\w+)" +
                        "\\Wprice:(\\w[.]\\w+)" +
                        "\\Wtype:(\\w+)" +
                        "\\Wexpiration:(\\w[/]\\w+[/]\\w+)");
        Matcher m = p.matcher(jerksonStr);

        while (m.find()) {
            String name = m.group(1).replace("0", "o").toLowerCase(); // convert letters to LowerCase
            Double price = Double.parseDouble(m.group(2));
            String type = m.group(3);
            String expiration = m.group(4);
            list.add(name, new ListInventory(type, price, expiration));
        }

        countErrors(list);

        return list.printPretty();
    }

    private void countErrors(ListMap list) {
        Pattern p = Pattern.compile(":\\W");
        Matcher m = p.matcher(jerksonStr);

        while (m.find()) {
            list.addError();
        }
    }
}
