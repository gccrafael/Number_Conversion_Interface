/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;

/**
 *
 * @author Rafael Garcia
 */
public class Dec2Hex extends Dec2Num
{
    public static final String VALUEDESC = "Decimal value:";
    public static final String RESULTDESC = "Hexadecimal result:";
    public static final int BASE = 16;
    private String result;
    private ArrayList<Integer> remainders;
    
    public Dec2Hex(String value) {
        super(value, Dec2Hex.BASE);
        if (super.isValid()) {
            this.result = "";
            remainders = super.getRemainders();
            for (int r : remainders) {
                
                switch (r) {
                    case 10:
                        result += "A";
                        break;
                    case 11:    
                        result += "B";
                        break;
                    case 12:    
                        result += "C";
                        break;
                    case 13:    
                        result += "D";
                        break;
                    case 14:    
                        result += "E";
                        break;
                    case 15:    
                        result += "F";
                        break;
                    default:
                        result += String.valueOf(r);
                        break;
                }    
                
            }
        }

    }

    @Override
    public String getResult() {
        return this.result;
    }
   
}
