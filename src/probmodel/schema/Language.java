package schema;
import java.io.IOException;
import java.util.Properties;
import java.io.File;


/**
 * @author Andrés Giménez Perales
 */
public class Language extends Properties{
    
    private static final long serialVersionUID = 1L;
	        
    public Language(String Language){
    	
    	File miDir = new File (".");
      
    	//Choose aplication language
    	switch(Language){
    	
    	
    	
	    	case "Es":
                    getProperties("languages/Es.properties");
                    break;
	    	case "En":
                    getProperties("languages/En.properties");
                    break;
	    	case "It":
	                getProperties("languages/It.properties");
	                break;
	    	case "Cat":
                	getProperties("languages/Cat.properties");
                	break;
	    	default:
                    getProperties("languages/En.properties");
	   	}

    }

    private void getProperties(String Language) {
        try {
            this.load( getClass().getResourceAsStream(Language) );
        } catch (IOException ex) {
        	System.out.println(ex);
        }
   }
}