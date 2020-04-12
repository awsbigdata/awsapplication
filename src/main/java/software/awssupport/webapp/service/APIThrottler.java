package software.awssupport.webapp.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.Objects.nonNull;

/**
 * It is used to throttle based on API name
 */
@Component
public class APIThrottler implements Throttler  {

    private static Log LOG = LogFactory.getLog(APIThrottler.class);

    @Value("${apiname.threshold}")
    private long threshold ;

    @Value("${apiname.bucketsize}")
    private long bucketSize ;



    // Container for keeping track of all provisioned rate limits.
    private ConcurrentHashMap<String, RateLimit> rateLimitMap = new ConcurrentHashMap<String, RateLimit>();

    // Thread pool initialization to remove old api's to clean up
    private ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public void provisionRateLimit(String apiname)
    {

        RateLimit rateLimit=new RateLimit(bucketSize,threshold);

        rateLimitMap.put(apiname,rateLimit);
    }
    // To remove a rate limit policy
    public void deProvisionRateLimit (String instance_id)
    {
        try
        {
            rateLimitMap.remove(instance_id);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    // API Call to peg traffic and evaluate the rate limit provisioned
    public boolean shouldRateLimit(String apiName)
    {
        RateLimit rateLimit= rateLimitMap.get(apiName);
        if(nonNull(rateLimit)){
            return !rateLimit.tryConsume(1);
        }
        else{
            provisionRateLimit(apiName);
            return false;
        }

    }
}
