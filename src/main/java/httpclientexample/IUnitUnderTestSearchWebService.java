package httpclientexample;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;


@Path("/rest-api")
public interface IUnitUnderTestSearchWebService {

    @GET
    @Path("/searchPart/{partNumber}")
    @Produces("application/json;charset=UTF-8")
    List<PartSearchResultDTO> searchPartByNumber(@PathParam("partNumber") String partNumber);

}