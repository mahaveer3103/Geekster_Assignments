package implementations;

import enums.CarType;
import interfaces.IService;

import java.util.HashMap;
import java.util.Map;

public class ClutchServicing implements IService {

    private CarType carType;

    private Map<CarType,Integer> carTypePrice = new HashMap<>();

    public ClutchServicing(CarType carType){
        this.carType = carType;
        carTypePrice.put(CarType.Sedan,2500);
        carTypePrice.put(CarType.Hatchback,3000);
        carTypePrice.put(CarType.SUV,3500);
    }

    @Override
    public float getPrice() {
        return carTypePrice.get(this.carType);
    }

}
