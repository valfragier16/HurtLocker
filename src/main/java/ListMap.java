import java.util.*;


public class ListMap {

    private LinkedHashMap<String, List<ListInventory>> listMap;
    private int errorCount;


    public ListMap() {
        errorCount = 0;
        listMap = new LinkedHashMap<>();
    }

    public void add(String name, ListInventory ListInventory) {

        if (listMap.containsKey(name)) {
            listMap.get(name).add(ListInventory);
        } else {
            List<ListInventory> list = new ArrayList<>();
            list.add(ListInventory);
            listMap.put(name, list);
        }
    }

    public String printPretty() {
        String result = "";
        for (Map.Entry<String, List<ListInventory>> e : listMap.entrySet()) {
            result += "name:  " + e.getKey().substring(0,1).toUpperCase()+ e.getKey().substring(1) + " \t\tseen: " + e.getValue().size() + "\ttimes\n";
            result += "===========\t\t\t=============\n";
            result += printPrices(e.getValue());
            result += "\n";
        }

        result += "Errors  \t\t\tseen: " + errorCount + "\ttimes\n";

        return result;
    }

    private String printPrices(List<ListInventory> list) {
        Map<Double, Integer> map = new LinkedHashMap<>();
        for (ListInventory l : list) {
            if(map.containsKey(l.getPrice())) {
                map.put(l.getPrice(), map.get(l.getPrice()) + 1);
            } else {
                map.put(l.getPrice(), 1);
            }
        }

        String result = "";
        for (Map.Entry<Double, Integer> e : map.entrySet()) {
            result += "price: " + e.getKey() + "\t\t\tseen: " + e.getValue() + "\ttimes\n";
            result += "-----------\t\t\t-------------\n";
        }

        return result;
    }

    public void addError() {
        errorCount++;
    }

    public Set<String> getKeys() {
        return listMap.keySet();
    }
}
