package httpclientexample.replica;

import httpclientexample.PartSearchResultDTO;

import java.util.List;

public class TestRunner {
    public static void main(String[] args) {
        UnitUnderTestSearchRemoteService unitUnderTestSearchRemoteService = new UnitUnderTestSearchRemoteService();
        try {
            List<PartSearchResultDTO> partSearchResultDTOs = unitUnderTestSearchRemoteService.searchPartByNumber("A");
            partSearchResultDTOs.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //if commented then it works for the subsequent request
        unitUnderTestSearchRemoteService = new UnitUnderTestSearchRemoteService();
        try {
            List<PartSearchResultDTO> partSearchResultDTOs = unitUnderTestSearchRemoteService.searchPartByNumber("A");
            partSearchResultDTOs.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
