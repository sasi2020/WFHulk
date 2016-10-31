/**
 * 
 */
package com.wfhulk.common;

import java.util.Map;

/**
 * @author simalla
 *
 */
public class JSONRequest {
	
	private String actionName;
	private Map<String,Object> parameterMap;
	public String getActionName() {
		return actionName;
	}
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	public Map<String, Object> getParameterMap() {
		return parameterMap;
	}
	public void setParameterMap(Map<String, Object> parameterMap) {
		this.parameterMap = parameterMap;
	}
	
	
	

}
