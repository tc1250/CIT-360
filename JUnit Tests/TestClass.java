
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author tcchr
 */
public class TestClass {

    public String[] stringArray1;
    public String[] stringArray2;
    public double test1;
    public double test2;
    public boolean bool;
    public ArrayList stringArray3 = new ArrayList();

    public String[] getStringArray1() {
        return stringArray1;
    }

    public void setStringArray1(String[] stringArray1) {
        this.stringArray1 = stringArray1;
    }

    public String[] getStringArray2() {
        return stringArray2;
    }

    public void setStringArray2(String[] stringArray2) {
        this.stringArray2 = stringArray2;
    }

    public double getTest1() {
        return test1;
    }

    public void setTest1(double test1) {
        this.test1 = test1;
    }

    public double getTest2() {
        return test2;
    }

    public void setTest2(double test2) {
        this.test2 = test2;
    }

    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }

    public ArrayList getStringArray3() {
        return stringArray3;
    }

    public void setStringArray3(ArrayList stringArray3) {
        this.stringArray3 = stringArray3;
    }

    public double add(double input1, double input2) {
        return input1 + input2;
    }

    public double subtract(double input1, double input2) {
        return input1 + input2;
    }

    public static int compareArrays(String[] array1, String[] array2) {
        return Arrays.toString(array1).compareTo(Arrays.toString(array2));
    }

}
