import java.util.Scanner;
public class concessivefour {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int arry[][] = new int[B][A];
        for(int i=0;i<B;i++){
            for(int j=0;j<A;j++){
                arry[i][j] = sc.nextInt();
            }
        }
        if(isConsecutiveFour(arry, B, A)==true){
            System.out.println("1");
        }else if(isConsecutiveFour(arry, A, B)==false) {
            System.out.println("0");
        }

    }

    public static boolean isConsecutiveFour(int[][] values,int a,int b){
        // Horizontal
        for(int i=0;i<a;i++){
            for(int j=0;j<b-3;j++){
                int temp = values[i][j];
                boolean check = true;
                for(int k=j;k<j+4;k++){
                    if(values[i][k]!=temp){
                        check = false;
                    }
                }
                if(check == true){
                    return check;
                }
            }
        }
        // Vertical
        for(int i=0;i<a-3;i++){
            for(int j=0;j<b;j++){
                int temp = values[i][j];
                boolean check = true;
                for(int k=i;k<i+4;k++){
                    if(values[k][j]!=temp){
                        check = false;
                    }
                }
                if(check == true){
                    return check;
                }
            }
        }
        // right diagonal
        for(int i=0;i<a-3;i++){
            for(int j=0;j<b-3;j++){
                int temp = values[i][j];
                boolean check = true;
                for(int k=i;k<i+4;k++){
                    for(int h=j;h<j+4;h++){
                        if(k==h){
                            if(values[k][h]!=temp){
                                check = false;
                            }
                        }
                    }
                }
                if(check == true){
                    return check;
                }
            }
        }
        // left diagonal
        for(int i=a-1;i>=a-3;i--){
            for(int j=0;j<b-3;j++){
                int temp = values[i][j];
                boolean check = true;
                for(int k=i;k>i-4;k--){
                    for(int h=j;h<j+4;h++){
                        if(k==h){
                            if(values[k][h]!=temp){
                                check = false;
                            }
                        }
                    }
                }
                if(check == true){
                    return check;
                }
            }
        }

        return false;
    }
}
