/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2;

/**
 *
 * @author studentcs
 */
public class Account2 {
    Date dateCreated;
    Person objPerson;
    int id;
    double balance,interestRate; 
    
    Account2(){
        
    }
    public Account2(int id,double balance,double interestRate,Date dateCreated,Person objPerson){
        this.dateCreated = dateCreated;
        this.objPerson = objPerson;
        this.balance = balance;
        this.id = id;
        this.interestRate = interestRate;

    }
    public Date getDate(){
        return this.dateCreated;
    }
    public Person getPerson(){
        return this.objPerson;
    }
    
    public void transferMoney(Account2 acc,double amount){
        if(this.balance>acc.balance){
            acc.balance+=amount;
            this.balance-=amount;
        }else{
            System.out.println("Can't Transfer");
        }
    }
    
}
class Date{
        int day;
        String month;
        int year;
        Date(){
            
        }
        Date(int d, String m,int y){
            this.day = d;
            this.month = m;
            this.year = y;
        }
        @Override
        public String toString(){
            return ""+this.day+"/"+this.month+"/"+this.year;
        }
}
class Person{
    String name;
    String surname;
    int age;
    Date bDate;
    Person(){
        
    }
    public Person(String n,String s,int a,Date b){
        this.name = n;
        this.surname = s;
        this.age = a;
        this.bDate = b;
    }
    @Override
    public String toString(){
        return "name: "+this.name+" surname: "+this.surname+" age: "+this.age+" date: "+bDate;
    }
}
class SavingAccount extends Account2{
    public SavingAccount(){
        super();
    }
    SavingAccount(int id,double balance,double interestRate,Date dateCreated,Person objPerson){
        super(id,balance,interestRate,dateCreated,objPerson);
        this.balance = balance;
    }
    public double getBalance(){
        return this.balance;
    }
    public void withdraw(double wd){
        this.balance -= wd;
    }
    public void deposit(double dp){
        this.balance += dp;
    }
    
    
    public double getMonthlyInterest(){
        return this.interestRate/12;
    }
    public void print(){
        System.out.println("ID :"+this.id+" balance :"+this.balance+" rate :"+getMonthlyInterest());
    }
    @Override
    public String toString(){
        return " balance: "+balance;
    }
    public void transferAmount(Account2 acc,double amount){
        if(this.balance>acc.balance+20){
            acc.balance+=amount;
            this.balance-=amount;
            this.balance-=20;
            

        }else{
            System.out.println("Can't Transfer");
        }
    }
}
class FixAccount extends Account2{
    public FixAccount(){
        super();
    }
    FixAccount(int id,double balance,double interestRate,Date dateCreated,Person objPerson){
        super(id,balance,interestRate,dateCreated,objPerson);
    }
    public void withdraw(double wd){
        this.balance -= wd;
    }
    public void deposit(double dp){
        this.balance += dp;
    }
    
    @Override
    public String toString(){
        return " balance: "+balance;
    }
    public void transferAmount(Account2 acc,double amount, Date now){
        if(now.year-){
            acc.balance+=amount;
            this.balance-=amount;
            this.balance-=20;
            

        }else{
            System.out.println("Can't Transfer");
        }
    }
    
}
class Test{
    public static void main(String[] args){
        Date birth = new Date(2,"March",2005);
        Person a = new Person("john","mayer",25,birth);
        Date dateOpenAcc = new Date(1,"January",2023);
        
        SavingAccount acc1 = new SavingAccount(1123,20000,4.5,dateOpenAcc,a);
        SavingAccount acc2 = new SavingAccount(1100,1000,4.5,dateOpenAcc,a);
        
        acc1.withdraw(2500);
        System.out.println("------ withdraw 2500 ------");
        acc1.print();
        
        System.out.println("------ deposit 3000 ------");
        acc1.deposit(3000);
        acc1.print();

        System.out.println("------ Transfer 100 ------");
        acc1.transferAmount(acc2, 100);
        acc1.print();
        acc2.print();
        
        Date now = new Date(14,"Aug",2024);
        FixAccount acc3 = new FixAccount(1124,20000,7,dateOpenAcc,a);

            
        
    }
}