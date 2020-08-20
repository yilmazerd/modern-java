package modernjavainaction.modernjavabook.chap11;

import org.junit.Test;
import static java.util.Optional.of;

import java.util.Optional;
import java.util.Properties;

public class ERDTestCar {

    @Test
    public void test_Car_Simple() {
        Optional<Insurance> insurance = of( new Insurance());
        Car newCar = new Car(insurance);
        Optional<Insurance> insuranceToGet = newCar.getInsurance();
        Car someCar = new Car(null);
        Optional<Insurance> insuranceToGetFromSome = someCar.getInsurance();
        int ss = 23;
    }
}
