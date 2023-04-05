import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int p = sc.nextInt();
        int d = sc.nextInt();
        int[] res = new int[n];

        if(d==0){
            for(int i=p;i<n;i++){
                res[i-p] = arr[i];
            }
            for(int i=0;i<p;i++){
                res[n-p+i] = arr[i];
            }
        } else if (d==1) {
            int a=0;
            for(int i=n-p;i<n;i++){
                res[a++] = arr[i];
            }
            for(int i=0;i<n-p;i++){
                res[p+i] = arr[i];
            }
        }
        for(int i=0;i<n;i++){
            System.out.print(res[i]+" ");
        }
    }
}