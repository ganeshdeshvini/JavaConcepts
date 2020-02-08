package varargs;

import java.util.List;

public class SelectionPrototypeComponentDTO {
    private String partId;
    private List<SelectionDataSetContainerDTO> dataSetContainers;

    public SelectionPrototypeComponentDTO(String partId,
            List<SelectionDataSetContainerDTO> dataSetContainers) {
        this.partId = partId;
        this.dataSetContainers = dataSetContainers;
    }

    public String getPartId() {
        return partId;
    }

    public List<SelectionDataSetContainerDTO> getDataSetContainers() {
        return dataSetContainers;
    }

}