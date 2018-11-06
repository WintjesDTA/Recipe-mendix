package src;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.*;


@Component
public class RecipemlResourceAssembler extends ResourceAssembler<Recipeml, RecipemlResource> {
	
	@Autowired
	protected EntityLinks entityLinks;
	
	private static final String UPDATE_REL = "update";
    private static final String DELETE_REL = "delete";
    @Override
    public RecipemlResource toResource(Recipeml recipe) {
        RecipemlResource resource = new RecipemlResource(recipe);
        final Link selfLink = entityLinks.linkToSingleResource(recipe);
        resource.add(selfLink.withSelfRel());
        resource.add(selfLink.withRel(UPDATE_REL));
        resource.add(selfLink.withRel(DELETE_REL));
        return resource;
    }

}
