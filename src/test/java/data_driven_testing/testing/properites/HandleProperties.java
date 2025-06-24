package data_driven_testing.testing.properites;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class HandleProperties {
	public static void main(String[] args) throws IOException {
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\testdata\\config.properties");
		Properties properties=new Properties();
		properties.load(file);
		
		String username=properties.getProperty("username");
		String password=properties.getProperty("password");
		String gmail=properties.getProperty("gmail");
		String address=properties.getProperty("address");
		
		System.out.println(username+" "+password+" "+gmail+" "+address);
		
		Set<String>keys=properties.stringPropertyNames();
		for (String string : keys) {
			System.out.println(string);
		}
		
		
		
	}

}
