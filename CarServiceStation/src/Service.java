import java.util.HashMap;

public class Service {

    private String code;
    private String serviceName;
    private HashMap<CarType,Integer> prices;

    public Service(String code, String serviceName, Integer priceHatchback, Integer priceSedan, Integer priceSUV){
        this.code = code;
        this.serviceName = serviceName;
        this.prices = new HashMap<>();
        this.prices.put(CarType.HATCHBACK,priceHatchback);
        this.prices.put(CarType.SEDAN,priceSedan);
        this.prices.put(CarType.SUV,priceSUV);
    }

    public String getCode() {
        return code;
    }
    public String getName() {
        return serviceName;
    }
    public int getPrice(CarType carType) {
        return this.prices.get(carType);
    }

}
