import java.util.Scanner;
public class PointDistance{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double[] arryX = new double[N];
        double[] arryY = new double[N];
        for(int i=0;i<N;i++){
            arryX[i] = sc.nextDouble();
            arryY[i] = sc.nextDouble();
        }
        Distance obj = new Distance();
        System.out.println(obj.distance(arryX,arryY));
    }
    
}
class Distance{
    public double distance(double[] arryX,double[] arryY){
        double cal = 1000;
        double before;
        for(int i=0;i<arryX.length-1;i++){
            for(int j=i+1;j<arryX.length;j++){
                before = Math.sqrt(Math.pow((arryX[i]-arryX[j]),2)+Math.pow((arryY[i]-arryY[j]),2));
                if(before<cal){
                    cal = before;
                }
            }
        }
        return cal;
    }

}