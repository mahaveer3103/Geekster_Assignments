import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceStation {

    public static Map<String,Service> serviceMap;

    public ServiceStation(){
        serviceMap = new HashMap<>();
        serviceMap.put("BS01", new Service("BS01", "Basic Service", 2000, 4000, 5000));
        serviceMap.put("EF01", new Service("EF01", "Engine Fixing", 5000, 8000, 10000));
        serviceMap.put("CF01", new Service("CF01", "Clutch Fixing", 2000, 4000, 6000));
        serviceMap.put("BF01", new Service("BF01", "Break Fixing", 1000, 1500, 2500));
        serviceMap.put("GF01", new Service("GF01", "Gear Fixing", 3000, 6000, 8000));
    }

    public static Service getService(String code) {
        return serviceMap.get(code);
    }

    public static void printBill(CarType carType, List<String> serviceCodes) {
        double bill = 0;
        for (String code : serviceCodes) {
            Service service = getService(code);
            bill += service.getPrice(carType);
            System.out.println(service.getName() + " : " + service.getPrice(carType));
        }
        if (bill >= 10000) {
            System.out.println("In Additional You Get a FREE Car Cleaning ");
            System.out.println("Total Service Bill  : " + bill);
        } else {
            System.out.println("Total Service Bill : " + bill);
        }
    }
}
