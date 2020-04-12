package software.awssupport.webapp.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import software.awssupport.webapp.service.Throttler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static java.util.Objects.nonNull;

/**
 *
 */
@Component
public class RateLimitInterceptor implements HandlerInterceptor {


    @Autowired
    Throttler apiThrottler;




    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
            String apiname=request.getParameter("name");
            if(nonNull(apiname) && apiThrottler.shouldRateLimit(apiname)){
                        System.out.println("throttled");
                        response.setStatus(HttpStatus.BAD_REQUEST.value()); // 400
                        response.getWriter().write(String.format(" %s API request is throttled as concurrent limit has been reached",apiname));
                        response.getWriter().flush();
                        response.getWriter().close();
                   return false;

            }else{
                return true;
            }
    }

}
