
package com.calpha.hospital.util;

import java.util.Date;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author CAlpha
 */
@WebFilter(filterName = "IpAddressInterceptionFilter", urlPatterns = {"/*"})
public class IpAddressInterceptionFilter implements Filter {
    
    private static final boolean debug = true;
    private static Logger LOGGER = LoggerFactory.getLogger(IpAddressInterceptionFilter.class);

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;
    
    public IpAddressInterceptionFilter() {
    }    
    

   
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
       HttpServletRequest req = ( HttpServletRequest)request;
        String ipAddress = req.getRemoteAddr();
        String hostAddress= req.getRemoteHost();
		String hostIP = "Ip Address" +ipAddress +"Host" + hostAddress + ",Time is" +new Date().toString();
        //System.out.println("Ip Address" +ipAddress +"Host" + hostAddress + ",Time is" +new Date().toString());
		LOGGER.info(hostIP);
		chain.doFilter(request, response);
    }
    /**
     * Return the filter configuration object for this filter.
     */

    /**
     * Return the filter configuration object for this filter.
     * @return
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    @Override
    public void destroy() {        
    }

    /**
     * Init method for this filter
     * @param filterConfig
     */
    @Override
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
       String myParameter = filterConfig.getInitParameter("Access-host");
       System.out.println("Test param:" +myParameter);
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);        
    }
    
}
