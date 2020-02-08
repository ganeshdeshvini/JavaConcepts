package httpclientexample.replica;

import javax.ws.rs.client.ResponseProcessingException;
import javax.ws.rs.core.Response;


abstract class BaseWebService<S> {
    private final S service;

    public BaseWebService(Class<S> interfaceClass) {
        service = new RemoteServiceFactory().createWebService(interfaceClass);
    }

    protected S getService() {
        return service;
    }

    protected <T> T call(ServiceCall<T, S> method) throws Exception {
        try {
            T call = method.call(getService());
            return call;
        } catch (ResponseProcessingException pe) {
            Response response = pe.getResponse();
            System.out.println("ERORRRR");
            System.out.println(response.getStatus());
            // System.out.println(response.getEntity());

            System.out.println(pe.getMessage());
            System.out.println(pe.getCause());
            throw new Exception(pe);
        } catch (Exception e1) {
            throw new Exception(e1);
        }
    }

}
