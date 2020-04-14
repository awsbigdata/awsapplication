package software.awssupport.webapp.service;

/**
 * it is used  to throttle request
 *
 */
public interface Throttler  {

    boolean shouldRateLimit(String name);
}
