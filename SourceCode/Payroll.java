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

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		if(n==1){
			Add_Employee.add_employee();
		}
		if(n==2){
			Fire_Employee.fire_employee();
		}


		
	}
}