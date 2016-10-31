/**
 * 
 */
package com.wfhulk.common;

import java.util.Map;

/**
 * @author Shasanka
 *
 */
public interface ProcessorInterface {
	public String validate(Map<String,Object> parameterMap);
	public String processRequest(Map<String,Object> parameterMap);

}
