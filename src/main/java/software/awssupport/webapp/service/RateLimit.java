package software.awssupport.webapp.service;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * RateLimit bean
 */
public class RateLimit {

    private static Log LOG = LogFactory.getLog(RateLimit.class);

    private final long capacity;
    private final double refillTokensPersecond;

    private double availableTokens;
    private long lastRefillTimestamp;

    /**
     * Creates token-bucket with specified capacity and refill rate equals to refillTokens/refillPeriodMillis
     */
    public RateLimit(long capacity, long refillTokens) {
        this.capacity = capacity;
        this.refillTokensPersecond = refillTokens;

        this.availableTokens = capacity;
        this.lastRefillTimestamp = System.currentTimeMillis()/1000;
    }

    synchronized public boolean tryConsume(int numberTokens) {
        refill();
        if (availableTokens < numberTokens) {
            return false;
        } else {
            availableTokens -= numberTokens;
            return true;
        }
    }

    private void refill() {
        long currentTimesec = System.currentTimeMillis()/1000;
        if (currentTimesec > lastRefillTimestamp) {
            long millisSinceLastRefill = currentTimesec - lastRefillTimestamp;
            double refill = millisSinceLastRefill * refillTokensPersecond;
            this.availableTokens = Math.min(capacity, availableTokens + refill);
            this.lastRefillTimestamp = currentTimesec;
        }
    }
}
