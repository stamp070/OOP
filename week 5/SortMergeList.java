import java.util.ArrayList;
import java.util.Scanner;
public class SortMergeList{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arry1 = new ArrayList<>();
        ArrayList<Integer> arry2 = new ArrayList<>();
        int A,B;
        do { 
            A = sc.nextInt();
            if(A!=0){
                arry1.add(A);
            }
        } while (A!=0);
        
        do { 
            B = sc.nextInt();
            if(B!=0){
                arry2.add(B);
            }
        } while (B!=0);
        System.out.println(sortmerge(arry1, arry2));
    }
    public static ArrayList sortmerge(ArrayList<Integer> a,ArrayList<Integer> b){
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<a.size();i++){
            for(int j=0;j<b.size();j++){
                if(a.get(i)==b.get(j)){
                    ans.add(a.get(i));
                    break;
                }
            }
        }
        ans.sort(null);
        return ans;
    }
}