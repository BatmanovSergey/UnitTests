package seminars.second.hw2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
    Car car;
    Motorcycle moto;
    @BeforeEach
    void setUp () {
        car = new Car("Dodge", "Ram", 2010);
        moto = new Motorcycle("Ural", "Sahara", 2015);
    }

    @Test
    public void testCarIsInstanceOfVehicle() {
        assertTrue(car instanceof Vehicle);

    }

    @Test
    public void testMotoIsInstanceOfVehicle() {
        assertTrue(moto instanceof Vehicle);
    }

    @Test
    public void testCarHaveFourWheels() {
        assertThat(car.getNumWheels()).isEqualTo(4); // AssertJ
        Assertions.assertEquals(4, car.getNumWheels());  // JUpiter
    }

    @Test
    public void testMotoHaveTwoWheels() {
        assertThat(moto.getNumWheels()).isEqualTo(2); // AssertJ
        Assertions.assertEquals(2, car.getNumWheels()); // JUpiter
    }

    @Test
    public void testCarDriveSpeed60() {
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60); // AssertJ
        Assertions.assertEquals(60, car.getSpeed()); // JUpiter
    }

    @Test
    public void testMotoDriveSpeed75() {
        moto.testDrive();
        assertThat(car.getSpeed()).isEqualTo(75); // AssertJ
        Assertions.assertEquals(75, car.getSpeed()); // JUpiter
    }

    @Test
    public void testCarParkSpeedIsZero() {
        car.testDrive();
        car.park();
        assertThat(car.getSpeed()).isEqualTo(0); // AssertJ
        Assertions.assertEquals(0, car.getSpeed()); // JUpiter
    }

    @Test
    public void testMotoParkSpeedIsZero() {
        moto.testDrive();
        moto.park();
        assertThat(moto.getSpeed()).isEqualTo(0); // AssertJ
        Assertions.assertEquals(0, moto.getSpeed()); // JUpiter
    }
}