package generic.wildcards.upperbound;

import java.util.ArrayList;
import java.util.List;

public class MultipleClassExample {
    interface ICar {
        void drive(ICar iCar);
    }

    static class Audi implements ICar {
        @Override
        public void drive(ICar iCar) {
            System.out.println("I drive Audi");
        }
    }

    static class BMW implements ICar {

        @Override
        public void drive(ICar iCar) {
            System.out.println("I drive BMW");
        }
    }

    static void restrictive(List<ICar> iCars) {

    }

    static void lessRestrictive(List<? extends ICar> iCars) {

    }

    public static void main(String[] args) {
        Audi audi = new Audi();
        BMW bmw = new BMW();
        ICar iCar = audi;
        List<ICar> iCars = new ArrayList<>();
        iCars.add(audi);
        iCars.add(bmw);

        List<Audi> audis = new ArrayList<>();
        audis.add(audi);

        restrictive(iCars);
        //won't compile as it is restricitive
//        restrictive(audis);

        lessRestrictive(iCars);
        lessRestrictive(audis);
    }
}

