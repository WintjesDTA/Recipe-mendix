package src;
import java.util.*;
import java.util.stream.Collectors;

public abstract class ResourceAssembler<DomainType, ResourceType> {
    
	public abstract ResourceType toResource(DomainType domainObject);
    
    public Collection<ResourceType> toResourceCollection(Collection<DomainType> domainObjects) {
        return domainObjects.stream().map(o -> toResource(o)).collect(Collectors.toList());
    }
}
