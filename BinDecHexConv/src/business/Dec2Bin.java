
package business;

import java.util.ArrayList;

/**
 *
 * @author Rafael Garcia
 */
public class Dec2Bin extends Dec2Num {
    public static final String VALUEDESC = "Decimal value:";
    public static final String RESULTDESC = "Binary result:";
    public static final int BASE = 2;
    private String result;
    private ArrayList<Integer> remainders;
    
    public Dec2Bin(String value) {        
        super(value, Dec2Bin.BASE);
        if (super.isValid()) {
            this.result = "";
            remainders = super.getRemainders();
            for (int r : remainders) {
                result += String.valueOf(r);
            }
        }

    }

    @Override
    public String getResult() {
        return this.result;
    }

}
