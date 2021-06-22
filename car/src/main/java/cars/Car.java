package cars;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private String producerName;
    private String type;
    private int age;
    private StateOfCar stateOfCar;
    private List<KmState> kmStates = new ArrayList<>();

    public Car(String producerName, String type, int age, StateOfCar stateOfCar, List<KmState> kmStates) {
        this.producerName = producerName;
        this.type = type;
        this.age = age;
        this.stateOfCar = stateOfCar;
        this.kmStates = kmStates;
    }

    public String getProducerName() {
        return producerName;
    }

    public String getType() {
        return type;
    }

    public int getAge() {
        return age;
    }

    public StateOfCar getStateOfCar() {
        return stateOfCar;
    }

    public List<KmState> getKmStates() {
        return kmStates;
    }
}
