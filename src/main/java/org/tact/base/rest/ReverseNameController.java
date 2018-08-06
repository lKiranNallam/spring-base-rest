package org.tact.base.rest;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author N L Kiran
 *
 *This controller has request URL with 'name' in URL
 */
@RestController
@RequestMapping(value = "/name")
public class ReverseNameController {

	/**
	 * 
	 * @param name
	 * @return
	 * 
	 * This method is a GET method with accepts any string as 
	 * parameter in its request URL which is to be reversed
	 */
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public <T> T listUsers(@PathVariable("name") String name) {
		
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        StringBuilder reversed_name = new StringBuilder();
        try {
        	/**
        	 * condition to check the string
        	 */
        	if(name!=null && !name.trim().isEmpty()) {
        		int len = name.length();
        		/**
        		 * logic to reverse the string
        		 */
        		for(int i=len-1; i>=0; i--) {
        			reversed_name.append(name.charAt(i));
        		}
        	}
        	 map.put("name", name);
             map.put("reversed_name", reversed_name.toString());
        }catch(Exception e) {
        	e.printStackTrace();
        }
        return (T) map;
    }
}
