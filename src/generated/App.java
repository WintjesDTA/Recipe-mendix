package generated;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;;

public class App {
	public static void main( String[] args )
    {
        System.out.println( "Hello World!" ); 
        try {
    		File file = new File("src/Amaretto_Cake.xml");
    		JAXBContext jaxbContext = JAXBContext.newInstance(Recipeml.class);
    		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
    		// output pretty printet    		
    		Recipeml recipe = (Recipeml) jaxbUnmarshaller.unmarshal(file);
    		System.out.println(recipe.getRecipe().ingredients.ingDiv.get(0).title);
    	      } catch (JAXBException e) {
    		e.printStackTrace();
    	      }
    }
}
