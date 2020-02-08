package httpclientexample;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PartSearchResultDTO extends BaseIdDTO {

    private final String partNumber;

    private List<PartSearchResultDTO> children = new ArrayList<>();

    public PartSearchResultDTO() {
        partNumber = "";
    }

    /**
     *
     * @param id
     *            of the structure level entity
     * @param partNumber
     *            part number and version in display format
     * @param children
     *            tbd !
     */
    public PartSearchResultDTO(@JsonProperty("id") Long id,
                               @JsonProperty("partNumber") String partNumber,
                               @JsonProperty("children") List<PartSearchResultDTO> children) {
        super(id);
        this.partNumber = partNumber;
        this.children = Collections.unmodifiableList(children);
    }

    public String getPartNumber() {
        return partNumber;
    }

    public List<PartSearchResultDTO> getChildren() {
        return children;
    }

    @Override public String toString() {
        return "PartSearchResultDTO{" +
                "partNumber='" + partNumber + '\'' +
                '}';
    }
}
