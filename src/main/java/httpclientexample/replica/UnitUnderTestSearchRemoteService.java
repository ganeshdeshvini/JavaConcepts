package httpclientexample.replica;

import httpclientexample.IUnitUnderTestSearchWebService;
import httpclientexample.PartSearchResultDTO;

import java.util.List;

public class UnitUnderTestSearchRemoteService extends BaseWebService<IUnitUnderTestSearchWebService>
        implements IUnitUnderTestSearchService {

    public UnitUnderTestSearchRemoteService() {
        super(IUnitUnderTestSearchWebService.class);
    }

    @Override
    public List<PartSearchResultDTO> searchPartByNumber(String partNumber) throws Exception {
        return call(service -> service.searchPartByNumber(partNumber));
    }

}