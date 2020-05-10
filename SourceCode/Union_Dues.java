import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.json.simple.JSONObject; 
import org.json.simple.JSONArray; 
import org.json.simple.parser.JSONParser; 
import org.json.simple.parser.ParseException;
public class Union_Dues{
	public static void union_dues(){
		try{
			System.out.println("Please provide employee_id and amount of dues");
			Scanner scan = new Scanner(System.in);
			String id = new String();
			String dues = new String();
			id = scan.next();
			dues = scan.next();
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader("employees.json"));
			JSONObject a = (JSONObject)obj;
			JSONObject emp = (JSONObject)a.get(id);
			int prev = Integer.parseInt(emp.get("dues").toString());
			emp.put("dues",prev+Integer.parseInt(dues));
			a.remove(String.valueOf(id));
			a.put(String.valueOf(id),emp);
			FileWriter fileWriter = new FileWriter("employees.json");         // writing back to the file
	        fileWriter.write(a.toJSONString());
	        fileWriter.flush();
		}catch(Exception e){
			System.out.println(e);
		}
	}
}