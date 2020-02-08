package httpclientexample.replica;

/**
 * Generic interface for service calls, simplifies exception handling
 *
 * @param <R>
 *            result type of the call
 * @param <S>
 *            Type of Service that should be called
 */
interface ServiceCall<R, S> {

    R call(S service) throws Exception;
}