public class hw8 {
    public static void main(String[] args) {
        Rectangle R1 = new Rectangle(5,5,1,1);
        Rectangle R2 = new Rectangle(5,5,2,3);
        Line L1 = new Line(-2,-2,2,2);
        Line L2 = new Line(2,2,-2,-2);
        System.out.println(contains(L1,R1));
        System.out.println(cross(L1,L2));
        System.out.println(overlap(R1,R2));
    }
    public static int contains(Line a,Rectangle b){
        int check_x = b.x + b.width;
        int check_y = b.y + b.height;
        if(a.x1 <= check_x && a.x2 <= check_x){
            if(a.y1 <= check_y && a.y2 <= check_y){
                return 1;
            }else{
                return 0;
            }
        }else{
            return 1;
        }
    }
    public static int cross(Line a,Line b){
        double m1 = (a.y1 - a.y2) / (a.x1 - a.x2); // หาความชัน a
        double c1 = a.y1 - m1 * a.x1; // c = y - mx
        double equation; // y1

        double m2 = (b.y1 - b.y2) / (b.x1 - b.x2); // หาความชัน b
        double c2 = b.y1 - m2 * b.x1; // c = y - mx
        double equation2; // y2
        if(a.x1 > a.x2){
            int temp = a.x2;
            a.x2 = a.x1;
            a.x1 = temp;
        }
        if(b.x1 > b.x2){
            int temp = b.x2;
            b.x2 = b.x1;
            b.x1 = temp;
        }
        for(int i = a.x1 ; i < a.x2 ; i++){
            equation = m1 * i + c1;
            for(int j=b.x1;i<b.x2;i++){
                equation2 = m2 * j + c2;
                if(equation == equation2){
                    return 1;
                }
            }
            
        }
        return 0;
    }
    public static int overlap(Rectangle box , Rectangle b){
        double check_width = b.width / 2.0;
        double check_x_max = b.x + check_width; 
        double check_x_min = b.x - check_width;
        int check_x_dot;
        double check_box_width = box.width / 2.0;
        double check_box_x_max = box.x + check_box_width;
        double check_box_x_min = box.x - check_box_width;
        if(box.x <= check_x_max && box.x >= check_x_min){
            check_x_dot = 1;
            if(check_x_max >= check_box_x_max && check_x_min <= check_box_x_min){
                // check 1 หมายถึงอยู่ในกรอบครบ
                check_x_dot = 1;
            }else{
                // check 2 หมายถึงจุดอยู่ในพื่้นที่อยู่นอก
                check_x_dot = 2;
            }
        }else{
            check_x_dot = 3;
            if( (check_box_x_min <= check_x_max && check_box_x_min >= check_x_min) || (check_box_x_max >= check_x_min && check_box_x_max <= check_x_max)){
                // check 3 จุดอยู่นอกแต่มีพื่นที่ทับกัน
                check_x_dot = 3;
            }else{
                // check -1 ไม่ทับกันเลย
                check_x_dot = -1;
            }
        }
        
        double check_height = b.height / 2.0;
        double check_y_max = b.y + check_height; 
        double check_y_min = b.y - check_height;
        int check_y_dot;
        double check_box_height = box.height / 2.0;
        double check_box_y_max = box.y + check_box_height;
        double check_box_y_min = box.y - check_box_height;
        if(box.y <= check_y_max && box.y >= check_y_min){
            // check 1 หมายถึงอยู่ในกรอบครบ
            check_y_dot = 1;
            if(check_y_max >= check_box_y_max && check_y_min <= check_box_y_min){
                check_y_dot = 1;
            }else{
                // check 2 หมายถึงจุดอยู่ในพื่้นที่อยู่นอก
                check_y_dot = 2;
            }
        }else{
            check_y_dot = 3;
            if( (check_box_y_min <= check_y_max && check_box_y_min >= check_y_min) || (check_box_y_max >= check_y_min && check_box_y_max <= check_y_max)){
                // check 3 จุดอยู่นอกแต่มีพื่นที่ทับกัน
                check_y_dot = 3;
            }else{
                // check -1 ไม่ทับกันเลย
                check_y_dot = -1;
            }
        }
        if(check_x_dot == 2 || check_x_dot == 3 || check_y_dot == 2 || check_y_dot == 3){
            return 1;
        }else{
            return 0;
        }
    }
    public static double distance(Line a,Rectangle b){
        int midXrec = b.x + (b.width / 2);
        int midYrec = b.y +(b.height / 2);
        int midLineX = (a.x1 + a.x2) / 2;
        int midLineY = (a.y1 + a.y2) / 2;
        return Math.sqrt(Math.pow((midLineX - midXrec) , 2) + Math.pow((midLineY - midYrec) , 2));
    } 
}
class Rectangle{
    int width,height;
    int x,y;
    Rectangle(){
        width = 0;
        height = 0;
        x = 0;
        y = 0;
    }
    Rectangle(int w,int h,int a,int b){
        width = w;
        height = h;
        x = a;
        y = b;
    }
    public double getArea(Rectangle a){
        return a.width*a.height;
    }
}
class Line{
    int x1,y1,x2,y2;
    Line(){
        x1 = 0;
        y1 = 0;
        x2 = 0;
        y2 = 0;
    }
    Line(int a,int b,int c,int d){
        x1 = a;
        y1 = b;
        x2 = c;
        y2 = d;
    }
    public double getLong(Line l){
        return Math.sqrt(Math.pow((l.x2 - l.x1) , 2) + Math.pow((l.y2 - l.y1) , 2));
    }
}
