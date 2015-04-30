package business;

import java.util.ArrayList;

/**
 *
 * @author Rafael Garcia
 */
public abstract class Dec2Num implements Conversion
{
    private ArrayList<String> resultsteps;
    private ArrayList<Integer> remainders;
    private String emsg;
    private int base;
    private String value;
    private boolean validvalue;
    
    public Dec2Num(String value, int base) {
        emsg = "";
        this.value = value;
        this.base = base;
        try {
           long n = Long.parseLong(value);
           if (n < 0) {
               emsg = "Bad decimal value: must be positive.";
               this.validvalue = false;
           } else {
               resultsteps = new ArrayList<>();
               remainders = new ArrayList<>();
               this.validvalue = true;
               
                   convertByRecur(n);    
                              
           }    
        } catch (NumberFormatException e) {
           emsg = "Illegal value: not a decimal integer";
           this.validvalue = false;
        }    
    }//end of constructor
    
    private void convertByRecur(long n) {
        int r = 0;
        
        r = (int)(n % this.base);
        long newval = n / this.base;
        resultsteps.add(n + " divided by " + this.base + " = " + 
                        newval + " w/remainder of: "  + r);
        
        if (newval > 0) {
            convertByRecur(newval);
        } 
        remainders.add(r);
    }
    
    @Override
    public String getValue() {
        return this.value;
    }
    
    @Override
    public String getErrorMsg() {
        return this.emsg;
    }
    
    @Override
    public ArrayList<String> getProcessLog() {
        return this.resultsteps;    
    }
    
    @Override
    public boolean isValid() {
        return this.validvalue;
    }
    
    @Override
    public abstract String getResult();
    
    protected ArrayList<Integer> getRemainders() {
        return this.remainders;
    }
}
