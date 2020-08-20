package modernjavainaction.modernjavabook.chap11;

import java.util.Optional;

public class Car {

  private Optional<Insurance> insurance;

  public Optional<Insurance> getInsurance() {
    return insurance;
  }

  Car(Optional<Insurance> insurance) {
    this.insurance = insurance;
  }
}
