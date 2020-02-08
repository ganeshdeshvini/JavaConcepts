package wildcards.capture.helper;

import java.util.List;

public class CaptureAndHelperMethodRunner {

    static void wildCardError(List<?> i) {
        //uncomment to see the ERROR
//        i.set(0, i.get(0));
    }

    static void wildCardFixed(List<?> i) {
        wildCardFixedHelper(i);
    }
    static <T> void wildCardFixedHelper(List<T> t){
        t.set(0, t.get(0));
    }
    public static void main(String[] args) {

    }
}
