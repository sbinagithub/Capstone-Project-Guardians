package tek.bdd.capstone.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;



public class Capstone_FileUtility {
	
	public static FileInputStream getFileInputStream(String filePath)
	throws FileNotFoundException{
		return new FileInputStream(new File(filePath));
	}
}
		
	


