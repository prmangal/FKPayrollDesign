import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.json.simple.JSONObject; 
import org.json.simple.JSONArray; 
import org.json.simple.parser.JSONParser; 
import org.json.simple.parser.ParseException;
public class Change_Details{
	public static void change_details(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Please provide id of employee :");
		int id = scan.nextInt();
		System.out.println("Please provide field that you want to change :");
		String field = scan.next();
		try{
			if(field.equals("hour_rate")||field.equals("com_rate")||field.equals("monthly_salary")||field.equals("method_of_payment")){
				System.out.println("Please provide the value:");
				String method = new String();
				int val=0;
				double com=0.0;
				if(field.equals("method_of_payment")){
					method = scan.next();
				}
				else if(field.equals("com_rate"))
					com = Double.parseDouble(scan.next());
				else
					val = scan.nextInt();
				JSONParser parser = new JSONParser();
				Object obj = parser.parse(new FileReader("employees.json"));
				JSONObject a = (JSONObject)obj;
				JSONObject emp = (JSONObject)a.get(String.valueOf(id));
				if(field.equals("method_of_payment"))
					emp.put(field,method);
				else if(field.equals("com_rate"))
					emp.put(field,com);
				else
					emp.put(field,val);
				a.remove(String.valueOf(id));
				a.put(String.valueOf(id),emp);
				FileWriter fileWriter = new FileWriter("employees.json");         // writing back to the file
		        fileWriter.write(a.toJSONString());
		        fileWriter.flush();

			}
			else
				System.out.println("Invalid field");
		} catch (Exception e) {
            e.printStackTrace();
        }
	}
}