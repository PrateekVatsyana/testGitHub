package org.kaushik.javabrains.messanger.database;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReader {
	   public static void main(String[] args) {

			JSONParser parser = new JSONParser();

			try {

				Object obj = parser.parse(new FileReader("Test.json"));
				
				JSONObject jsonObject = (JSONObject) obj;
				
				String swagger = (String) jsonObject.get("swagger");
				System.out.println("swagger"+swagger);

				
				// loop array
				JSONArray URI = (JSONArray) jsonObject.get("sites");
				System.out.println("URI are"+URI);
				Iterator<String> iterator = URI.iterator();
				while (iterator.hasNext()) {
					System.out.println(iterator.next());
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}

		     }
}
