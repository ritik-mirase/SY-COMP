package Puzzle;

import java.util.Scanner;
class base{
String brand;
String model;
int days;
int rate;
base(int days,int rate,String brand,String model){
this.model = model;
this.brand = brand;
this.days = days;
this.rate = rate;
}
public int cal_rent() {
int res = rate * days;
return res;
}
public void display() {
System.out.println("\n----VEHICLE DETAILS-----");
System.out.println("Model : "+ model);


System.out.println("Brand : "+ brand);
System.out.println("Duration : "+ days);
System.out.println("Total Rent : "+ cal_rent());
System.out.println("----Thank you for using Vehicle Rental System !-----");
}
}
class car extends base{
car(int days,int rate,String brand,String model){
super(days, rate, brand , model);
}
public int cal_rent() {
// calculating car rent
rate = 1500;
int res = rate * days;
return res;
}
}
class truck extends base{
truck(int days,int rate,String brand,String model){
super(days, rate, brand , model);
}
public int cal_rent() {
// calculating truck rent
rate = 3500;
int res = rate * days;
return res;
}
}
class bike extends base{
bike(int days,int rate,String brand,String model){


super(days, rate, brand , model);
}
public int cal_rent() {
// calculating bike rent
rate = 1000;
int res = rate * days;
return res;
}
}
public class vehicle {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
int choice,d;
String b,m;
System.out.println("---- Welcome to vehicle rental system !----");
System.out.println("Please enter the details for renting a vehicle - ");
System.out.println("1)Car 2) Truck 3) Bike 4) Exit");
do {
System.out.println("\nEnter the choice of vehicle : ");
choice = sc.nextInt();
switch(choice) {
case 1:
System.out.println("Enter the model of vehicle : ");
m = sc.next();
System.out.println("Enter the Brand of vehicle : ");
b = sc.next();
System.out.println("Enter the number of days to rent the vehicle");
d = sc.nextInt();
base car = new car(d,1500,b,m);



car.cal_rent();
car.display();
break;
case 2:
System.out.println("Enter the model of vehicle : ");
m = sc.next();
System.out.println("Enter the Brand of vehicle : ");
b = sc.next();
System.out.println("Enter the number of days to rent the vehicle");
d = sc.nextInt();
base truck = new truck(d,3500,b,m);
truck.cal_rent();
truck.display();
break;
case 3:
System.out.println("Enter the model of vehicle : ");
m = sc.next();
System.out.println("Enter the Brand of vehicle : ");
b = sc.next();
System.out.println("Enter the number of days to rent the vehicle");
d = sc.nextInt();
base bike = new bike(d,1000,b,m);
bike.cal_rent();
bike.display();
break;
case 4:
System.out.println("Exiting....");
System.out.println("----Thank you for using Vehicle Rental System !-----");



break;
default:
System.out.println("Please enter a valid choice");
break;
}
}while(choice!=4);
}
}

