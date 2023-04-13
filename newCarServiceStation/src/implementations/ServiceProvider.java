package implementations;

import enums.CarType;
import interfaces.IService;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class ServiceProvider implements IService{
    private CarType carType;
    private List<IService> services=new ArrayList<>();


    @Override
    public float getPrice(){
        float totalPrice=0.0f;
        for(IService service: services){
            totalPrice+=service.getPrice();
        }
        return totalPrice;
    }

    public ServiceProvider(CarType carType, List<String> services) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, InvocationTargetException {
        this.carType=carType;
        for(String serviceName: services){
            Class<?> clazz= Class.forName(serviceName);
            Constructor<?> cons=clazz.getConstructor(CarType.class);
            IService iService=(IService) cons.newInstance(carType);
            this.services.add(iService);
        }
    }

    public void Invoice(){
        List<String> bill=new ArrayList<>();
        for(IService service: services){
            String s="Charge for "+service.getClass().toString().substring(22)+" is "+service.getPrice();
            bill.add(s);
        }
        for(String s:bill){
            System.out.println(s);
        }
        System.out.println("Total invoice bill is : "+getPrice());
        if(getPrice()>10000) {
            System.out.println("You got free complementary cleaning service as your invoice bill goes above 10,000 rs ");
        }
    }

}
