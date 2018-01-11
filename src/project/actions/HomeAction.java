package project.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware {
	
	private Map<String, Object> sessionMap;
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.sessionMap = session;
	}
	
	@Override
	public String execute() throws Exception {
		Object key = sessionMap.get("userid");
		if (key == null) {
			addActionError("Please login first");
			return LOGIN;
		}
		return SUCCESS;
	}
}
