package autoDownloadMp3;

import java.io.File;

import org.junit.Test;

import com.mpatric.mp3agic.ID3v1Tag;
import com.mpatric.mp3agic.Mp3File;

public class TestJunit {

	
	
	
	
	
	
	@Test
	public void TestMp3title () {
		
		
		File dir = new File("H:");
		  File[] directoryListing = dir.listFiles();
		  if (directoryListing != null) {
		    for (File child : directoryListing) {
		    
				System.out.println(child.getName());
	
		    
				if(child.getName().contains(".mp3"))
        try {

 
        	Mp3File mp3file = new Mp3File(child.getAbsoluteFile());
        	
        	String[] file = child.getName().replace("my-free-mp3s.com", "").replace(".mp3", "").split("-", 2);
        	
        	ID3v1Tag id3v1Tag = new ID3v1Tag();
        	  mp3file.setId3v1Tag(id3v1Tag);
        	  
        	  id3v1Tag.setArtist(file[0]);
        	  id3v1Tag.setTitle(file[1]);
        	  
        	  
        	mp3file.save("H:/"+file[0]+" - "+file[1]+".mp3");
        	child.delete(); 
        }
        catch (Exception e) {
			e.printStackTrace();
		}
        
		   }}
		
	}
}
