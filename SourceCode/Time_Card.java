import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
public class Time_Card{
	public static void time_card(){
		try{
			System.out.println("Please provide employee_id and no. of hours worked");
			Scanner scan = new Scanner(System.in);
			String id = new String();
			String hours = new String();
			id = scan.next();
			hours = scan.next();
			File file = new File("Time_Card.txt");
			FileWriter fw=new FileWriter(file,true);
			fw.write(id + " " + hours+"\n");
			fw.close();
			System.out.println("Time card Posted Successfully");
		}catch(Exception e){
			System.out.println(e);
		}
	}
}