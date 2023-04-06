import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ServiceStation serviceStation = new ServiceStation();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your car_type : ");
        String carType = sc.nextLine();

        System.out.println("Enter codes : BS01 ,EF01 ,CF01 ,BF01 ,GF01: \n To Print Bill After Code Enter : 0  ");
        ArrayList<String> serviceCodes = new ArrayList<String>();
        while(true) {
            String code=sc.nextLine();
            if(code.equals("0")) {
                break;
            }
            else if(code.equals("BS01")  || code.equals("EF01") || code.equals("CF01") || code.equals("BF01") || code.equals("GF01")) {
                serviceCodes.add(code);
            }
            else {
                System.out.println("Invalid Code Plz Check !");
            }
        }
//        sc.close();

        if(carType.equals("Hatchback")) {
            ServiceStation.printBill(CarType.HATCHBACK, serviceCodes);
        }
        else if(carType.equals("Sedan")) {
            ServiceStation.printBill(CarType.SEDAN, serviceCodes);
        }
        else if(carType.equals("SUV")) {
            ServiceStation.printBill(CarType.SUV, serviceCodes);
        }
        else {
            System.out.println("Invalid Car Type");
        }

    }
}