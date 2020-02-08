package httpclientexample.replica;

import httpclientexample.PartSearchResultDTO;

import java.util.List;

public interface IUnitUnderTestSearchService {

    /**
     * search parts by number using prefix search
     * @param partNumber part number as string e.g. A122334112, can be prefix of a number (A122)
     * @return Part search results matching given partnumber, filled substructure
     * @throws Exception
     */
    List<PartSearchResultDTO> searchPartByNumber(String partNumber) throws Exception;

}