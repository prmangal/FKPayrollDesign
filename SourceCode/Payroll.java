import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Payroll{
	public static void main(String [] args){
		System.out.println("Please choose one of the following options :");
		System.out.println("Adding a new employee : press 1 and hit enter");
		System.out.println("Firing an employee : press 2 and hit enter");
		System.out.println("Changing data of an employee : press 3 and hit enter");
		System.out.println("Post Time Card of an employee : press 4 and hit enter");
		System.out.println("Post Sales Recipt of an employee : press 5 and hit enter");
		System.out.println("Post union dues of an employee : press 6 and hit enter");

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		if(n==1){
			Add_Employee.add_employee();
		}
		if(n==2){
			Fire_Employee.fire_employee();
		}
		if(n==3){
			Change_Details.change_details();
		}
		if(n==4){
			Time_Card.time_card();
		}
		if(n==5){
			Sales_Recipt.sales_recipt();
		}
		if(n==6){
			Union_Dues.union_dues();
		}


		
	}
}