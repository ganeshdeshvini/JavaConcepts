package generic.selftest;

class Car { }

class Audi extends Car { }

class BMW extends Car { }

class Demo { }

class Test<T extends Car>{
    T t;
    Test(){
        System.out.println("I am here");
    }
    T getData(){
        return t;
    }
    void setData(T t){
        this.t = t;
    }
}

public class Runner {
    public static void main(String[] args) {
        Audi audi = new Audi();
        BMW bmw = new BMW();
        Car car = audi;

        Test<Car> carTest = new Test<>();
        carTest.setData(audi);
        Car data = carTest.getData();

        Demo demo = new Demo();
//        Test<Demo> demoTest = new Test<>();
//        demoTest.setData(demo);
    }
}