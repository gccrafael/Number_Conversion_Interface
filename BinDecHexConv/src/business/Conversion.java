package business;

import java.util.ArrayList;

/**
 *
 * @author Rafael Garcia
 */
public interface Conversion
{
    String getValue();
    String getResult();
    ArrayList<String> getProcessLog();
    boolean isValid();
    String getErrorMsg();
    
}
