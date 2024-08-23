import java.util.Scanner;
class FindPokemon {
    int arry[][];
    int A,B,countApprove = 0;
    int approve[][] = new int[100][2];
    int bestApproveidx;
    FindPokemon(int a[][],int num1,int num2){
        arry = a;
        A = num1;
        B = num2;
    }
    public void check(){
        for(int i=0;i<A-1;i++){
            for(int j=0;j<B;j++){
                if(Math.abs(arry[i][j]-arry[i+1][j])<10 ){
                    approve[countApprove][0] = arry[i][j];
                    approve[countApprove][1] = arry[i+1][j];
                    countApprove++;
                }
            }
        }
    }
    public void findbest(){
        int max = 0;
        for(int i=0;i<countApprove;i++){
            if(max<approve[i][0]+approve[i][1]){
                max = approve[i][0]+approve[i][1];
                bestApproveidx = i;
            }
        }
        
    }
    public void print(){
        for(int i=0;i<A-1;i++){
            for(int j=0;j<B;j++){
                if(approve[bestApproveidx][0]==arry[i][j] && approve[bestApproveidx][1]==arry[i+1][j]){
                    System.out.println((i+1)+" " +(j+1));
                    return;
                }
            }
        }
    }
}
public class pokemon{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int arry[][] = new int[a][b];
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                arry[i][j] = sc.nextInt();
            }
        }
        FindPokemon FP = new FindPokemon(arry,a,b);
        FP.check();
        FP.findbest();
        FP.print();
    }
}
