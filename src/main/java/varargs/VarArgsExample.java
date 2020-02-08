package varargs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VarArgsExample {
    public static void main(String[] args) {
        List<SelectionDataSetContainerDTO> selectionDataSetContainerDTOs = Arrays.asList(
                new SelectionDataSetContainerDTO("Container1"),
                new SelectionDataSetContainerDTO("Container2")
        );
        List<SelectionDataSetContainerDTO> selectionDataSetContainerDTOs2 = Arrays.asList(
                new SelectionDataSetContainerDTO("Container3"),
                new SelectionDataSetContainerDTO("Container4")
        );
        List<SelectionPrototypeComponentDTO> selectionPrototypeComponentDTOs = Arrays.asList(
                new SelectionPrototypeComponentDTO("Part2", selectionDataSetContainerDTOs2)
        );
        SelectionPrototypeDTO selectionPrototypeDTO = new SelectionPrototypeDTO("Prototype1",
                selectionPrototypeComponentDTOs);
        //
        List<SelectionPrototypeComponentDTO> selectionPrototypeComponentDTOs2 = selectionPrototypeDTO.getComponents();
        SelectionPrototypeComponentDTO[] selectionPrototypeComponentDTOS = selectionPrototypeComponentDTOs2
                .toArray(new SelectionPrototypeComponentDTO[selectionDataSetContainerDTOs.size()]);
        System.out.println(getDeletedDataSetContainers(selectionPrototypeComponentDTOS));
    }

    private static List<String> getDeletedDataSetContainers(
            SelectionPrototypeComponentDTO... selectionPrototypeComponentDTOs) {
        return Stream.of(selectionPrototypeComponentDTOs)
                .map(SelectionPrototypeComponentDTO::getDataSetContainers)
                .flatMap(Collection::stream)
                .map(selectionDataSetContainerDTO -> selectionDataSetContainerDTO.getContainerId())
                .collect(Collectors.toList());
    }

    public static void removePrototypes(SelectionPrototypeDTO... selectionPrototypeDTOs) {
        List<String> partDisplayNames = Stream.of(selectionPrototypeDTOs)
                .map(SelectionPrototypeDTO::getComponents)
                .flatMap(Collection::stream)
                .map(selectionPrototypeComponentDTO -> selectionPrototypeComponentDTO.getPartId())
                .collect(Collectors.toList());
        List<SelectionPrototypeComponentDTO> selectionPrototypeComponentDTOs = new ArrayList<>();
        for (SelectionPrototypeDTO selectionPrototypeDTO : selectionPrototypeDTOs) {
             selectionPrototypeComponentDTOs.addAll(selectionPrototypeDTO.getComponents());
        }
//        getDeletedDataSetContainers(selectionPrototypeDTOs.st)
    }
}



