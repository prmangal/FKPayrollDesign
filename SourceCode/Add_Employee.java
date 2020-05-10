import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.json.simple.JSONObject; 
import org.json.simple.JSONArray; 
import org.json.simple.parser.JSONParser; 
import org.json.simple.parser.ParseException;
public class Add_Employee{
	public static void add_employee(){

		System.out.println("Please provide Employee_name, is_hourly, salary ,comission rate, method_of_payment separated by spaces");
		Scanner scan = new Scanner(System.in);
		String [] input = scan.nextLine().split(" ");
		
		Employee emp = new Employee(input[0], Boolean.parseBoolean(input[1]) , Integer.parseInt(input[2]), Float.parseFloat(input[3]), input[4]);
		//Employee emp = new Employee("Pranav Mangal", false , 3_00_000, 10.0 , "Bank Transfer");

		JSONObject details = new JSONObject();
		details.put("name",emp.get_name());
		details.put("is_hourly",emp.is_hourly);
		details.put("hour_rate",emp.get_hour_rate());
		details.put("com_rate",emp.get_com_rate());
		details.put("monthly_salary",emp.get_monthly_salary());
		details.put("total_salary",emp.get_total_salary());
		details.put("method_of_payment",emp.method_of_payment);
		try{ 
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader("employees.json"));
			JSONObject a = (JSONObject)obj;
			int No_of_emp = Integer.parseInt(a.get("total").toString());
			details.put("employee_id",No_of_emp+1);
			System.out.println("Please varify the details and press y if varified :");
			System.out.println(details);
			String y_n = new String(scan.next());
			if(y_n.equals("y")){
				a.put(No_of_emp+1,details);   // adding your created object into the array
				a.put("total",No_of_emp+1);
			}
			else
				return;
			


			// writing the JSONObject into a file(info.json)
        
            FileWriter fileWriter = new FileWriter("employees.json");         // writing back to the file
            fileWriter.write(a.toJSONString());
            fileWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}