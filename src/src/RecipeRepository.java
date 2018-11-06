package src;

import java.util.*;


public class RecipeRepository extends InMemoryRepository<Recipeml> {
	
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
