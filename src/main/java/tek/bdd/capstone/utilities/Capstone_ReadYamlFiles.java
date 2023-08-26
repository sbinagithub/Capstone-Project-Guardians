package tek.bdd.capstone.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import org.yaml.snakeyaml.Yaml;



public class Capstone_ReadYamlFiles {
	
	private static Capstone_ReadYamlFiles capstone_readYamlFiles;
	private HashMap capstoneMap;
	
	// Constructor: we create to load our yml file
	private  Capstone_ReadYamlFiles(String filepath) throws FileNotFoundException{ 
	FileInputStream fileInputStream = Capstone_FileUtility.getFileInputStream(filepath);
		Yaml yaml = new Yaml();
		this.capstoneMap = yaml.load(fileInputStream);
		
	}
	
	// This method will return an instance of Capstone_ReadYamlFiles class
	// getInstance method will return instance of ReadYamlFiles when we provide the path
	public static Capstone_ReadYamlFiles getInstance(String filePath) throws FileNotFoundException{
		if(capstone_readYamlFiles == null)
			return new Capstone_ReadYamlFiles(filePath);
			
		return capstone_readYamlFiles;
		
	}
	// we get the property from the Yaml file and store it in a hashmap so that when we call this method
	// (getYamlProperty) we can pass the key and the method return the value for us
	public HashMap getYamlProperty(String key) {
		return(HashMap)this.capstoneMap.get(key);
	}

}
