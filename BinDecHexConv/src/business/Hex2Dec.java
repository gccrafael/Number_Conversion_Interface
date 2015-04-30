package business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;

/**
 *
 * @author Rafael Garcia
 */
public class Hex2Dec implements Conversion
{
    public static final String VALUEDESC = "Hexadecimal value:";
    public static final String RESULTDESC = "Decimal result:";
    
    private String result;
    private ArrayList<String> resultsteps;
    private String emsg;
    private String value; 
    private boolean validvalue;
    
    String[] hexakey = {"0", "1", "2", "3", "4", "5", "6",
                "7", "8", "9", "A", "B", "C", "D", "E", "F"};
    int[] hexavalue = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
                           12, 13, 14, 15};
    
    public Hex2Dec(String value) {
        emsg = "";
        this.value = value;
        this.validvalue = isValid(value);
        if (this.validvalue) {
            convert(value);
        } else {
            emsg = "Illegal value. Must use only 0 to 9 and A to F";
        }
    }
    private boolean isValid(String v) {       
        for (int i=0; i< v.length(); i++) {
            String part = Character.toString(v.charAt(i));
            int index = -1;
            index = Arrays.asList(hexakey).indexOf(part);            
            if (index == -1)
            {                
                return false;
            }
        }
        return true;
    }
    
    @Override
    public boolean isValid() {
        return this.validvalue;
    }
    private void convert(String v) {
        int r = 0;
        
        String reverse = new StringBuilder(v).reverse().toString();
        resultsteps = new ArrayList<>();
  
        for (int i=0; i < reverse.length(); i++) {
            String part = Character.toString(reverse.charAt(i));
            int index = Arrays.asList(hexakey).indexOf(part);            
            int num = hexavalue[index];
            if (reverse.charAt(i) != '0') {     
                int p = (int)Math.pow(16, i);
                r += p * num;            
                resultsteps.add("There is a(n) " + p + " in the number (16^" + i + ")" );
            }

        }
        this.result = String.valueOf(r);
    }
    @Override
    public String getResult() {
        return this.result;
    }
    
    @Override
    public ArrayList<String> getProcessLog() {
        return this.resultsteps;
    }
    
    @Override
    public String getErrorMsg() {
        return this.emsg;
    }
    @Override
    public String getValue() {
        return this.value;
    }
  
}
