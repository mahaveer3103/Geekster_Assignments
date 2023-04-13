package implementations;

import enums.CarType;
import interfaces.IService;

import java.util.HashMap;
import java.util.Map;

public class BasicServicing implements IService {

    private CarType carType;

    private Map<CarType,Integer> carTypePrice = new HashMap<>();

    public BasicServicing(CarType carType){
        this.carType = carType;
        carTypePrice.put(CarType.Sedan,2000);
        carTypePrice.put(CarType.Hatchback,4000);
        carTypePrice.put(CarType.SUV,5000);
    }

    @Override
    public float getPrice() {
        return carTypePrice.get(this.carType);
    }
}
