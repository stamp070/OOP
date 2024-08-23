/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication2;

/**
 *
 * @author studentcs
 */
public class Account {
    public static void main(String[] args){
        int id;
        double balance,annualinterestRate;
        String dateCreated;

        acc ac = new acc(1122,20000,4.5,"24/7/67");
        System.out.println(("MonthlyinterestRate = ") +ac.getMonthlyinterestRate());
        ac.withdraw(2500);
        System.out.println("withdraw = "+2500);
        System.out.println("balance = "+ac.getBalance());
        
        ac.deposit(3000);
        System.out.println("deposit = "+3000);
        System.out.println("balance = "+ac.getBalance());
        
        
    }
}
class acc{
    private int id;
    private double balance;
    private double annualinterestRate;
    private String dateCreated;
    
    acc(){
        this.id = 0;
        this.balance = 0;
        this.annualinterestRate = 0;
        this.dateCreated = "";
    }
    acc(int id,double balance,double annualinterestRate,String dateCreated){
        this.id = id;
        this.balance = balance;
        this.annualinterestRate = annualinterestRate;
        this.dateCreated = dateCreated;
    }
    //get
    public int getId(){
        return this.id;
    }
    public double getBalance(){
        return this.balance;
    }
    public double getAnnualInterestRate(){
        return this.annualinterestRate;
    }
    public String getDateCreated(){
        return this.dateCreated;
    }
    //set
    public void setId(){
        this.id = id;
    }
    public void setBalance(){
        this.balance = balance;
    }
    public void setAnnualInterestRate(){
        this.annualinterestRate = annualinterestRate;
    }
    public void setDateCreated(){
        this.dateCreated = dateCreated;
    }
    //method
    public double getMonthlyinterestRate(){
        return annualinterestRate/12;
    }
    public double getMonthlyinterest(){
        return (balance * annualinterestRate/12);
    }
    public void withdraw(double wd){
        this.balance -= wd;
    }
    public void deposit(double dp){
        this.balance += dp;
    }
}
