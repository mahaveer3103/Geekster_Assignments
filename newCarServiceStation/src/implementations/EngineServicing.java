package implementations;

import enums.CarType;
import interfaces.IService;

import java.util.HashMap;
import java.util.Map;

public class EngineServicing implements IService {
    private CarType carType;

    private Map<CarType,Integer> carTypePrice = new HashMap<>();

    public EngineServicing(CarType carType){
        this.carType = carType;
        carTypePrice.put(CarType.Sedan,4000);
        carTypePrice.put(CarType.Hatchback,5000);
        carTypePrice.put(CarType.SUV,7000);
    }

    @Override
    public float getPrice() {
        return carTypePrice.get(this.carType);
    }
}
