package src;
import org.springframework.hateoas.ResourceSupport;
import org.codehaus.jackson.annotate.JsonUnwrapped;

public class RecipemlResource extends ResourceSupport {
	
	@JsonUnwrapped
    private final Recipeml recipe;	
	
	public RecipemlResource (Recipeml recipe) {
		this.recipe = recipe;
	}
	
	public String getResourceID() {
		return this.recipe.getId();
	}
}
