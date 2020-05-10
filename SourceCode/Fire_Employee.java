import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.json.simple.JSONObject; 
import org.json.simple.JSONArray; 
import org.json.simple.parser.JSONParser; 
import org.json.simple.parser.ParseException;
public class Fire_Employee{
	public static void fire_employee(){
		System.out.println("Please provide id of employee!!");
		Scanner scan = new Scanner(System.in);
		int id = scan.nextInt();
		try{ 
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader("employees.json"));
			JSONObject a = (JSONObject)obj;

			JSONObject b = (JSONObject)a.get(String.valueOf(id));
			System.out.println("Are you sure you want to fire "+ b.get("name")+" with data : ");
			System.out.println(a.get(String.valueOf(id)));
			String y_n = new String(scan.next());
			if(y_n.equals("y"))
				a.remove(String.valueOf(id));
			else
				return;
        
            FileWriter fileWriter = new FileWriter("employees.json");         // writing back to the file
            fileWriter.write(a.toJSONString());
            fileWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}