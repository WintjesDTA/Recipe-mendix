package src;

public interface Identifiable extends org.springframework.hateoas.Identifiable<String> {
    public void setId(String id);
}
