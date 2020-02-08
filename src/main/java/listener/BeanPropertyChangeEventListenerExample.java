package listener;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class BeanPropertyChangeEventListenerExample {
    public static void main(String[] args) {
        MyBean myBean = new MyBean();
        myBean.addPropertyChangeListener(new MyPropertyChangeListener());
        myBean.addPropertyChangeListener(BeanPropertyChangeEventListenerExample::propertyChange);
        myBean.addPropertyChangeListener(evt -> callingLambdaMethod(evt));

        myBean.setProperty1("setting property1 1st time");
        myBean.setProperty2(1);

        myBean.setProperty1("setting property1 2st time");
        myBean.setProperty2(2);
    }

    private static void demo() {
        System.out.println("came here demo");
    }

    private static void propertyChange(PropertyChangeEvent evt) {
        demo();
    }

    private static void callingLambdaMethod(PropertyChangeEvent propertyChangeEvent){
        System.out.println(String.format("Inside LambdaMethod, Name=%s, OldValue=%s, NewValue=%s", propertyChangeEvent.getPropertyName(),
                propertyChangeEvent.getOldValue(), propertyChangeEvent.getNewValue()));
    }
}

class MyBean {
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    private String property1;
    private int property2;

    public String getProperty1() {
        return property1;
    }

    public void setProperty1(String property1) {
        String old = this.property1;
        this.property1 = property1;
        propertyChangeSupport.firePropertyChange("property1", old, property1);
    }

    public int getProperty2() {
        return property2;
    }

    public void setProperty2(int property2) {
        int old = this.property2;
        this.property2 = property2;
        propertyChangeSupport.firePropertyChange("property2", old, property2);
    }

    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        propertyChangeSupport.addPropertyChangeListener(propertyChangeListener);
    }
}

class MyPropertyChangeListener implements PropertyChangeListener {

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        System.out.println(String.format("Name=%s, OldValue=%s, NewValue=%s", propertyChangeEvent.getPropertyName(),
                propertyChangeEvent.getOldValue(), propertyChangeEvent.getNewValue()));
    }
}
