package src;

import java.util.*;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.annotation.PostConstruct;

public class RecipemlRepository extends InMemoryRepository<Recipeml> {
	
	@PostConstruct
	public void Initialize() {
		try {
			File amaretto = new File("src/Amaretto_Cake.xml");
			File chili = new File("src/30_Minute_Chili.xml");
			File another = new File("src/Another_Zucchini_Dish.xml");
    		JAXBContext jaxbContext = JAXBContext.newInstance(Recipeml.class);
    		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();   		
    		Recipeml recipe1 = (Recipeml) jaxbUnmarshaller.unmarshal(amaretto);
    		Recipeml recipe2 = (Recipeml) jaxbUnmarshaller.unmarshal(chili);
    		Recipeml recipe3 = (Recipeml) jaxbUnmarshaller.unmarshal(another);
    		this.create(recipe1);
    		this.create(recipe2);
    		this.create(recipe3);
    	      } catch (JAXBException e) {
    		e.printStackTrace();
    	      }
	}
	
	protected void updateIfExists(Recipeml original, Recipeml updated) {
        original.setId(updated.getId());
    }
	
	public List<Recipeml> findAllInCategory(String category) {
		List<Recipeml> returnList = new ArrayList<Recipeml>();
		List<Recipeml> allrecipes = this.findAll();
		for (Recipeml temp: allrecipes) {
			List<String> cats = temp.getCategories();
			for (String str : cats) {
				if (str.contains(category)) {
					returnList.add(temp);
				}
			}
		}
		return returnList;
	}
	
	public List<Recipeml> findAll(String searchString) {
		List<Recipeml> returnList = new ArrayList<Recipeml>();
		List<Recipeml> allrecipes = this.findAll();
		for (Recipeml temp: allrecipes) {
			String recipeName = temp.getRecipeName();
			if (recipeName.contains(searchString)) {
				returnList.add(temp);
				break;
			}
			List<String> cats = temp.getCategories();
			for (String str : cats) {
				if (str.contains(searchString)) {
					returnList.add(temp);
				}
			}
		}
		return returnList;
	}
	
	public Set<String> findCategories() {
		Set<String> returnSet = new HashSet<String>();
		for (Recipeml temp: this.findAll()) {
			returnSet.addAll(temp.getCategories());
		}
		return returnSet;
	}
}
