import java.util.Scanner;

public class Car {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int t = sc.nextInt();

        int [][] road = new int[t][m];
        for(int i = 0; i < t; i++){
            for(int j = 0; j < m; j++){
                road[i][j] = sc.nextInt();
            }
        }

        int currentLane = n - 1;
        for (int i = 0; i < t; i++) {
            int move = 3; 
            if (road[i][currentLane] == 1) { 
                if (currentLane > 0 && road[i][currentLane - 1] == 0) {
                    move = 1; 
                    currentLane--; 
                } else if (currentLane < m - 1 && road[i][currentLane + 1] == 0) {
                    move = 2; 
                    currentLane++; 
                }
            }
            System.out.println(move);
        }
    }    
}
