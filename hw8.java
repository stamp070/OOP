/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2;

/**
 *
 * @author studentcs
 */
import java.lang.Math;
public class hw8 {
    public static void main(String[] args) {
        Rectangle R1 = new Rectangle(10,5,10,5);
        Rectangle R2 = new Rectangle(10,5,10,5);
        Line L1 = new Line(1,1,8,4);
        Line L2 = new Line(1,1,2,2);
        System.out.println("Contain: "+contains(L1,R1));
        System.out.println("cross: "+cross(L1,L2));
        System.out.println("overlap: "+overlap(R1,R2));
        System.out.println("distance: "+distance(L1,R1));
    }
    public static int contains(Line a,Rectangle b){
        double check_x = b.x + b.width;
        double check_y = b.y - b.height;
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
            double temp = a.x2;
            a.x2 = a.x1;
            a.x1 = temp;
        }
        if(b.x1 > b.x2){
            double temp = b.x2;
            b.x2 = b.x1;
            b.x1 = temp;
        }
        for(double i = a.x1 ; i < a.x2 ; i++){
            equation = m1 * i + c1;
            for(double j=b.x1;i<b.x2;i++){
                equation2 = m2 * j + c2;
                if(a.x1!=b.x1){
                    if(equation == equation2){
                    return 1;
                }
                }
                
            }
            
        }
        return 0;
    }
    public static int overlap(Rectangle a , Rectangle b){
        if(a.x + a.width <=b.x || b.x+b.width<=a.x||a.y+a.height<=b.y||b.y+b.y+b.height<=a.y){
            return 0;
        }else{
            return 1;
        }
        
    }
    public static double distance(Line a,Rectangle b){
        double midXrec = b.x + (b.width / 2);
        double midYrec = b.y -(b.height / 2);
        double midLineX = (a.x1 + a.x2) / 2;
        double midLineY = (a.y1 + a.y2) / 2;
        
        return Math.sqrt(Math.pow((midLineX - midXrec) , 2) + Math.pow((midLineY - midYrec) , 2));
    } 
}
class Rectangle{
    double width,height;
    double x,y;
    Rectangle(){
        width = 0;
        height = 0;
        x = 0;
        y = 0;
    }
    Rectangle(double w,double h,double a,double b){
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
    double x1,y1,x2,y2;
    Line(){
        x1 = 0;
        y1 = 0;
        x2 = 0;
        y2 = 0;
    }
    Line(double a,double b,double c,double d){
        x1 = a;
        y1 = b;
        x2 = c;
        y2 = d;
    }
    public double getLong(Line l){
        return Math.sqrt(Math.pow((l.x2 - l.x1) , 2) + Math.pow((l.y2 - l.y1) , 2));
    }
}
