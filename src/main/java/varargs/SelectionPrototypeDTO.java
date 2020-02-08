package varargs;

import java.util.List;

public class SelectionPrototypeDTO {
    private String prototypeId;
    private List<SelectionPrototypeComponentDTO> components;

    public SelectionPrototypeDTO(String prototypeId, List<SelectionPrototypeComponentDTO> components) {
        this.prototypeId = prototypeId;
        this.components = components;
    }

    public String getPrototypeId() {
        return prototypeId;
    }

    public List<SelectionPrototypeComponentDTO> getComponents() {
        return components;
    }
}