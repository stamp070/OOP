
class Account2 {
    private Date dateCreated;
    private Person objPerson;
    private int id;
    private double balance,interestRate; 
    private double MonthlyInterestRate;
    
    Account2(){
        id = 0;
        balance = 0.0;
        interestRate = 0.045;
        dateCreated = new Date();
    }
    public Account2(int id , double balance , Date date){
        this.id = id;
        this.balance = balance;
        interestRate = 0.045;
        dateCreated = date;

    }
    public int Getid(){
        return id;
    }
    public void Setid(int id){
        this.id = id;
    }
    public double Getbalance(){
        return balance;
    }
    public void Setbalance(double balance){
        this.balance = balance;
    }
    public double GetannualInterestRate(){
        return interestRate;
    }
    public void SetannualInterestRate(double annualInterestRate){
        this.interestRate = annualInterestRate;
    }
    public Date GetdateCreated(){
        return dateCreated;
    }
    public void SetdateCreated(Date dateCreated){
        this.dateCreated = dateCreated;
    }
    public double getMonthlyInterestRate() {
        MonthlyInterestRate  = interestRate / 12.0;
        return MonthlyInterestRate;
    }
    private double MonthlyRate;
    public double getMonthlyInterest() {
        double monthlyRate = getMonthlyInterestRate(); // Monthly interest rate
        int year_long = 2025 - dateCreated.getYear(); // Number of years since dateCreated
        
        double futureBalance = this.balance * Math.pow((1 + monthlyRate), 12 * year_long);
        
        double totalInterest = futureBalance - this.balance;
        
        return totalInterest/12;
    }
    
    public void withdraw(double money){
        if(balance < money){
            System.out.println("Can't Withdraw");
        }else{
            balance -= money;
        }
    }
    public void deposit(double money){
        if(money < 0){
            System.out.println("Can't deposit");
        }else{
            balance += money;
        }
    }
    public void transferMoney(Account2 acc1 , int amount){
        this.balance -= amount;
        acc1.Setbalance(acc1.Getbalance() + amount);
    }
    @Override
    public String toString(){
        double monthInterest = getMonthlyInterest();
        return "id = " + id + 
                " balance = " + balance + 
                " annualInterestRate = " + interestRate + 
                " MonthlyInterest = " + monthInterest;
    }
    
}
class Date{
    private int day;
    private String month;
    private int year;
    Date(){
        day = 0;
        month = "";
        year = 0;
    }
    Date(int day , String month , int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public int getDay(){
        return day;
    }
    public int getYear(){
        return year;
    }
    public String getMonth(){
        return month;
    }
    public void setDay(int day){
        this.day = day;
    }
    public void setYear(int year){
        this.year = year;
    }
    public void setMonth(String month){
        this.month = month;
    }
}
class Person{
    private String name;
    private String surname;
    private int age;
    private Date bDate;
    public Person(){
        name = "";
        surname = "";
        age= 0;
        bDate = new Date();
    }
    public Person(String name , String surname , int age , Date date){
        this.name = name;
        this.surname = surname;
        this.age = age;
        bDate = date;
    }
    public String getname(){
        return name;
    }
    public String getsurname(){
        return surname;
    }
    public int getage(){
        return age;
    }
    public Date getbDate(){
        return bDate;
    }
    public void setname(String name){
        this.name = name;
    }
    public void setsurname(String surname){
        this.surname = surname;
    }
    public void setage(int age){
        this.age = age;
    }
    public void setbDate (Date date){
        bDate = date;
    }
}
class SavingAccount extends Account2{
    SavingAccount(){
        super();
    }
    Person SavingP = new Person();
    SavingAccount(int id , double balance ,double rate , Date date , Person p){
        super(id , balance , date);
        this.SetannualInterestRate(rate);
        SavingP = p;
    }
    @Override
    public void transferMoney(Account2 acc1 , int amount){
        this.Setbalance(this.Getbalance() - amount - 20);
        acc1.Setbalance(acc1.Getbalance() + amount);
    }
}
class FixAccount extends Account2{
    FixAccount(){
        super();
    }
    Person SavingP = new Person();
    FixAccount(int id , double balance ,double rate , Date date , Person p){
        super(id , balance , date);
        this.SetannualInterestRate(rate);
        SavingP = p;
    }
    Date date = this.GetdateCreated();
    @Override
    public void transferMoney(Account2 acc1 , int amount){
        System.out.println("Can't TransferMoney");
    }
    public void withdraw(double money){
        int check = date.getYear() - 2025;
        if(check < 1){
            System.out.println("Can't Withdraw");
        }else{
            this.Setbalance(this.Getbalance() - money);
        }
    }
}
public class acc2{
    public static void main(String[] args){
        Date birth = new Date(2,"March",2005);
        Person a = new Person("john","mayer",25,birth);
        Date dateOpenAcc = new Date(1,"January",2023);
        
        SavingAccount acc1 = new SavingAccount(1123,20000,0.045,dateOpenAcc,a);
        SavingAccount acc2 = new SavingAccount(1100,1000,0.045,dateOpenAcc,a);
        
        System.out.println("------ withdraw 2500 ------");
        acc1.withdraw(2500);
        System.out.println(acc1.toString());
        
        System.out.println("------ deposit 3000 ------");
        acc1.deposit(3000);
        System.out.println(acc1.toString());

        System.out.println("------ Transfer 100 ------");
        acc1.transferMoney(acc2, 100);
        System.out.println(acc1.toString());
        System.out.println(acc2.toString());

        
        FixAccount acc3 = new FixAccount(1124,20000,0.07,dateOpenAcc,a);
        System.out.println("\n------ withdraw 2500 ------");
        acc3.withdraw(2500);

        System.out.println("------ deposit 3000 ------");
        acc3.deposit(3000);
        System.out.println(acc3.toString());

        System.out.println("------ Transfer 200 ------");
        acc3.transferMoney(acc2, 200);
        
        
    }
}