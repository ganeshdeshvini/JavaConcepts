package httpclientexample;

public class BaseNameDTO extends BaseIdDTO {

    private String name;

    public BaseNameDTO() {
    }

    public BaseNameDTO(Long id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}