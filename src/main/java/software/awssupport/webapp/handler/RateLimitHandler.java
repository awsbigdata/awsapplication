package software.awssupport.webapp.handler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import software.awssupport.webapp.interceptor.RateLimitInterceptor;

/**
 * it is used to filter before hitting controller
 * @ToDO implement priority filter
 */
@Configuration
public class RateLimitHandler implements WebMvcConfigurer {

    private static Log LOG = LogFactory.getLog(RateLimitHandler.class);


    @Autowired
    RateLimitInterceptor rateLimitInterceptor;

    /**
     * Interceptor to shape the API request rate
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        registry.addInterceptor(rateLimitInterceptor).addPathPatterns("/api/**");

    }


}
