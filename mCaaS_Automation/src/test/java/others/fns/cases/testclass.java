package others.fns.cases;

import java.io.File;



public class testclass extends latestfile {
  public static void main(String[] args) {
	  
	    File getLatestFile = getLatestFilefromDir("C:\\Users\\sudhakar.koduri\\Downloads");
		String fileName = getLatestFile.getName();
		System.out.println(fileName);
	  //obj.getLastModifiedFile("C:\\Users\\sudhakar.koduri\\Downloads");
	
}
}
