package practice;
import java.util.ArrayList;
import java.util.List;


public class CSVParser {

    public List<String> parse(String line) {
        List<String> result = new ArrayList<String>();
        int index = 0;
        boolean inQuote = false;
        StringBuilder sb = new StringBuilder();
        while (index < line.length()) {
            char c = line.charAt(index);
            
            if (c == '\"') {
                inQuote = !inQuote;
                sb.append(c);
            } else if (c == ',' && !inQuote) {
                result.add(sb.toString());
                sb = new StringBuilder();
            } else if (index == line.length() - 1) {
                sb.append(c);
                result.add(sb.toString());
                break;
            } else {
                sb.append(c);
            }
            index++;
        }
        return result;
    }
    
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        //String test = "a,b,\"cd,de\",e\n";
        String test2 = "a,b,\"d \n, , \",\n,\"c\",d,e,k\n";
        List<String> result = new CSVParser().parse(test2);
        System.out.println(result.size());
        System.out.println(result);
    }

}

