import java.util.Scanner;
public class findlocation{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int k = sc.nextInt();
        int[][] arry = new int[row][col];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                arry[i][j] = sc.nextInt();
            }
        }
        algorithm A = new algorithm(arry,row,col,k);
        A.findlocation();
        A.print();
    }
}
class algorithm{
    int[][] arry;
    int row,col,size;
    int bestlocation=0,bestlocationidx;
    algorithm(int[][]a, int r,int c,int s){
        arry = a;
        row = r;
        col = c;
        size = s;
    }

    public void findlocation(){
        for(int i=0;i<=row-size;i++){
            for(int j=0;j<=col-size;j++){
                int population = 0;
                for(int k=i;k<i+size;k++){
                    for(int h=j;h<j+size;h++){
                        population +=arry[k][h];
                    }
                }

                if(bestlocation<population){
                    bestlocation = population;
                    bestlocationidx = arry[i][j];
                }
            }
        }
    }

    public void print(){
        System.out.println(bestlocation);
    }
}