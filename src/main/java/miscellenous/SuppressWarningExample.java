package miscellenous;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SuppressWarningExample {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        Object someObject = hashMap;
        if(someObject instanceof HashMap) {
            HashMap<String, String> theHash = (HashMap<String, String>)someObject;
        }


    }

    private void handleDataSetsContainerRemoved(PropertyChangeEvent evt) {
        List<String> dataSetContainerCompositeIds = new ArrayList<>();
        List<String> newDataSetContainerIds = (List<String>) evt.getNewValue();
    }
}
