import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.Stream;

public class FileObserver {
	
	private static final String YOUR_FOLDER_PATH = "C:\\BTU_DOCUMENT";
	
	public static void observeFolder(String folderName) {
	    new Thread(() -> { 
	          while(true) {
	          try (Stream<Path> paths = Files.walk(Paths.get(folderName))) {
	        	    System.out.println(paths.filter(Files::isRegularFile).count());
	        	} catch (IOException e1) {
					e1.printStackTrace();
				} 
	          try {
	             Thread.sleep(3000);
	          } catch(Exception e) {
	             e.printStackTrace();
	          }
	    }
	    }).start();
	}
	
    public static void main(String[] args) throws IOException {
    	boolean callFlag = false;
    	while(true) {
    		System.out.println("Please enter searching word");
    		BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
    		String str = inp.readLine();
    		System.out.println("Entered word is:" +  str);
    		try (Stream<Path> paths = Files.walk(Paths.get(YOUR_FOLDER_PATH))) {
    			Iterator<Path> pathFiles = paths.filter(Files::isRegularFile).iterator();
    		    while(pathFiles.hasNext()) {
    		    	String fileName = pathFiles.next().getFileName().toString();
    		    	if(fileName.contains(str)) {
    		    		System.out.println("Was found " + fileName);
    		    	}
    		    }
    			
    		}
    		if(!callFlag) {
    			observeFolder(YOUR_FOLDER_PATH);
    			callFlag = true;
    		}
    	}
    }
}
