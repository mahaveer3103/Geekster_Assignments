import enums.CarType;
import implementations.ServiceProvider;
import interfaces.IServiceProvider;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        List<String> services = new ArrayList<>();
        services.add("implementations.BrakeServicing");
        services.add("implementations.BasicServicing");
        services.add("implementations.ClutchServicing");
        services.add("implementations.EngineServicing");
        services.add("implementations.GearServicing");

        ServiceProvider serviceProvider = new ServiceProvider(CarType.Sedan,services);

        serviceProvider.Invoice();
    }
}