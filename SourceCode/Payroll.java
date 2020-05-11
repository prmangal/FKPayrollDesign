import java.util.*;
import java.util.Map;
import java.util.HashMap;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser; 
import org.json.simple.parser.ParseException;

public class Payroll{
	public static void payroll(){
		try{
			File file = new File("Time_Card.txt");
			Scanner scan = new Scanner(file);
			HashMap<Integer,Integer> t_card = new HashMap<>();

			while(scan.hasNextLine()){
				if(!scan.hasNextInt())
					break;
				int id = scan.nextInt();
				int hours = scan.nextInt();
				t_card.put(id,hours);
			}
			scan.close();
			file = new File("Sales_Recipt.txt");
			scan = new Scanner(file);
			HashMap<Integer,Integer> s_recipt = new HashMap<>();

			while(scan.hasNextLine()){
				if(!scan.hasNextInt())
					break;
				int id = scan.nextInt();
				int sale = scan.nextInt();	
				s_recipt.put(id,sale);
			}
			scan.close();
			Calendar calendar = Calendar.getInstance();
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader("employees.json"));
			JSONObject a = (JSONObject)obj;
			for(Iterator iterator = a.keySet().iterator(); iterator.hasNext();) {
			    String key = (String) iterator.next();
			    if(key.equals("total"))
			    	continue;
			    int id = Integer.parseInt(key);
			    Employee emp = new Employee(id);
			    int overtime = 0;
			    int sales = 0;
			    if(t_card.get(id)!=null)
					overtime = t_card.get(id)-8;
				if(s_recipt.get(id)!=null)
					sales = s_recipt.get(id);

			    emp.calculate_salary(overtime,sales);

			    Change_Details.change(id,"total_salary", String.valueOf(emp.get_total_salary()));
			    if(emp.get_dues()>0)Change_Details.change(id,"dues", "0");
			    Change_Details.change(id,"com_salary", String.valueOf(emp.get_com_salary()));
			    //System.out.println(emp.get_total_salary()+ " "+ emp.get_com_salary());

			    if(calendar.get(Calendar.DAY_OF_WEEK)==6){
			    	if(emp.is_hourly){
			    		System.out.println("Pay " +emp.get_name()+" (id="+emp.get_employee_id()+") Rs."+emp.get_total_salary()+" by "+emp.method_of_payment);
			    		Change_Details.change(id,"total_salary", "0.0");
			    	}
			    }
			    if(calendar.get(Calendar.DATE)==nthWeekdayOfMonth(6,2)||calendar.get(Calendar.DATE)==nthWeekdayOfMonth(6,4)){
			    	if(emp.get_com_salary()>0.0){
			    		System.out.println("Pay " +emp.get_name()+" (id="+emp.get_employee_id()+") Rs."+emp.get_com_salary()+" by "+emp.method_of_payment);
			    		Change_Details.change(id,"com_salary", "0.0");
			    	}
			    }
			    //System.out.println(lwd());
			    if(calendar.get(Calendar.DATE)==lwd()){
			    	if(emp.is_hourly==false){
			    		System.out.println("Pay " +emp.get_name()+" (id="+emp.get_employee_id()+") Rs."+emp.get_total_salary()+" by "+emp.method_of_payment);
			    		Change_Details.change(id,"total_salary", "0.0");
			    	}
			    }

			}
			PrintWriter pw = new PrintWriter("Time_Card.txt");
			pw.close();
			pw = new PrintWriter("Sales_Recipt.txt");
			pw.close();

		}catch(Exception e){
			System.out.println(e);
		}
	}


	public static int nthWeekdayOfMonth(int dayOfWeek,int week) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, dayOfWeek);
        calendar.set(Calendar.DAY_OF_WEEK_IN_MONTH, week);
        return calendar.get(Calendar.DATE);
    }
    public static int lwd(){
    	Calendar calendar = Calendar.getInstance();
    	int res = calendar.getActualMaximum(Calendar.DATE);
    	calendar.set(Calendar.DATE,res);
    	if(calendar.get(Calendar.DAY_OF_WEEK)==7)
    		return res-1;
    	else if(calendar.get(Calendar.DAY_OF_WEEK)==1)
    		return res-2;
    	else
    		return res;
    }
	public static void main(String [] args){
		System.out.println("Please choose one of the following options :");
		System.out.println("Adding a new employee : press 1 and hit enter");
		System.out.println("Firing an employee : press 2 and hit enter");
		System.out.println("Changing data of an employee : press 3 and hit enter");
		System.out.println("Post Time Card of an employee : press 4 and hit enter");
		System.out.println("Post Sales Recipt of an employee : press 5 and hit enter");
		System.out.println("Post union dues of an employee : press 6 and hit enter");
		System.out.println("Run payroll : press 7 and hit enter");

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
		if(n==7){
			payroll();
		}
		
	}
}