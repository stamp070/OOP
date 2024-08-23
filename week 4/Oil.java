import java.util.Scanner;

public class Oil {
    static int m, n;
    static String[][] grid;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            m = sc.nextInt();
            n = sc.nextInt();

            if (m == 0 && n == 0) break;

            grid = new String[m][n];
            visited = new boolean[m][n];


            for (int i = 0; i < m; i++) {
                String row = sc.next();
                for (int j = 0; j < n; j++) {
                    grid[i][j] = String.valueOf(row.charAt(j));
                }
            }

            int oilPockets = 0;


            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j].equals("@") && !visited[i][j]) {
                        dfs(i, j);
                        oilPockets++;
                    }
                }
            }

            System.out.println(oilPockets);
        }
    }


static void dfs(int x, int y) {

    int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    visited[x][y] = true;

    for (int i = 0; i < 8; i++) {
        int newX = x + dx[i];
        int newY = y + dy[i];

        if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY] && grid[newX][newY].equals("@")) {
            dfs(newX, newY);
        }
    }
}
}
