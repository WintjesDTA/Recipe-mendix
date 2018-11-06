package src;
import org.springframework.hateoas.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;

@CrossOrigin(origins = "*")
@RestController
@ExposesResourceFor(Recipeml.class)
@RequestMapping(value = "/recipeml", produces = "application/json")
public class RecipemlController {
	
	 	@Autowired
	    private RecipemlRepository repository;
	 
	    @Autowired	    
	    private RecipemlResourceAssembler assembler;
	    
	    @RequestMapping(method = RequestMethod.GET)
	    public ResponseEntity<Collection<RecipemlResource>> findAllRecipemls() {
	        List<Recipeml> Recipemls = repository.findAll();
	        return new ResponseEntity<>(assembler.toResourceCollection(Recipemls), HttpStatus.OK);
	    }
	    
	    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	    public ResponseEntity<RecipemlResource> createRecipeml(@RequestBody Recipeml Recipeml) {
	        Recipeml createdRecipeml = repository.create(Recipeml);
	        return new ResponseEntity<>(assembler.toResource(createdRecipeml), HttpStatus.CREATED);
	    }
	    
	    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	    public ResponseEntity<RecipemlResource> findRecipemlById(@PathVariable String id) {
	        Optional<Recipeml> Recipeml = repository.findById(id);
	        if (Recipeml.isPresent()) {
	            return new ResponseEntity<>(assembler.toResource(Recipeml.get()), HttpStatus.OK);
	        }
	        else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	    
	    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Void> deleteRecipeml(@PathVariable String id) {
	        boolean wasDeleted = repository.delete(id);
	        HttpStatus responseStatus = wasDeleted ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND;
	        return new ResponseEntity<>(responseStatus);
	    }
	    
	    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
	    public ResponseEntity<RecipemlResource> updateRecipeml(@PathVariable String id, @RequestBody Recipeml updatedRecipeml) {
	        boolean wasUpdated = repository.update(id, updatedRecipeml);
	        if (wasUpdated) {
	            return findRecipemlById(id);
	        }
	        else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
}
