package business;

import java.util.ArrayList;

/**
 *
 * @author Rafael Garcia
 */

public class Bin2Dec implements Conversion {
    public static final String VALUEDESC = "Binary value:";
    public static final String RESULTDESC = "Decimal result:";
    
    private String result;
    private ArrayList<String> resultsteps;
    private String emsg;
    private String value; 
    private boolean validvalue;
    
    public Bin2Dec(String value) {
        emsg = "";
        this.value = value;
        this.validvalue = isValid(value);
        if (this.validvalue) {
            convert(value);
        } else {
            emsg = "Illegal value binary value (must be only zeros and ones";
        }
    }
    private boolean isValid(String v) {
        for (int i=0; i< v.length(); i++) {
            if (v.charAt(i) != '1' && v.charAt(i) != '0') {
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
            if (reverse.charAt(i) == '1') {
                int p = (int) Math.pow(2,i);
                r += p;
                resultsteps.add("There is a(n) " + p + " in the number (2^" + i + ")" );
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
