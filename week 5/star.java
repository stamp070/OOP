import java.util.ArrayList;
import java.util.Scanner;

public class star {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            if (input.matches("\\d+")) {
                int command = Integer.parseInt(input); // string to integer
                if (command == 1) {
                    addStars(list);
                    System.out.println(list);

                } else if (command == 2) {
                    removeStars(list);
                    System.out.println(list);

                }else if(command == 0){
                    break;
                }
            } else {
                list.add(input);
            }
        }
        
    }
    
    public static void addStars(ArrayList<String> list) {
        ArrayList<String> modifiedList = new ArrayList<>();
        for (String i : list) {
            modifiedList.add(i);
            modifiedList.add("*");
        }
        list.clear();
        list.addAll(modifiedList);
    }

    
    public static void removeStars(ArrayList<String> list) {
        list.removeIf(item -> item.equals("*"));
    }
}
