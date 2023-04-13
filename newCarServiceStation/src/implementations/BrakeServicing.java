package implementations;

import enums.CarType;
import interfaces.IService;

import java.util.HashMap;
import java.util.Map;

public class BrakeServicing implements IService {
    private CarType carType;

    private Map<CarType,Integer> carTypePrice = new HashMap<>();

    public BrakeServicing(CarType carType){
        this.carType = carType;
        carTypePrice.put(CarType.Sedan,1500);
        carTypePrice.put(CarType.Hatchback,2000);
        carTypePrice.put(CarType.SUV,2500);
    }

    @Override
    public float getPrice() {
        return carTypePrice.get(this.carType);
    }
}
