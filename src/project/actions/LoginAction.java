package project.actions;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.Cookie;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.CookieProvider;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import project.dao.LoginDao;

public class LoginAction extends ActionSupport implements Action, SessionAware, CookieProvider{
	private String userid;
	private String pwd;
	private String remember;
	
	private Set<Cookie> cookies;

	private SessionMap<String, Object> session;

	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getRemember() {
		return remember;
	}
	public void setRemember(String remember) {
		this.remember = remember;
	}
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = (SessionMap<String, Object>) arg0;
	}
	@Override
	public String execute(){
		/*String test = (String) session.get("userid");
		if (test != null) {
			return SUCCESS;
		}*/
		
		LoginDao loginDao = new LoginDao();
		boolean result = loginDao.checkLogin(userid,pwd);
		if(result){
			session.put("userid", userid);
			return SUCCESS;
		}
		addActionError("invalid userid or password");
		return ERROR;
	}

	@Override
	public void validate() {
		String test = (String) session.get("userid");
		if (test != null){
			return;
		}
		else {
			if (userid == null || userid.trim().length() == 0) {
				addActionError("userid cannot be empty");
			}
			if (pwd == null || pwd.trim().length() == 0) {
				addActionError("password cannot be empty");
			}
		}
	}
	
	
	@Override
	public Set<Cookie> getCookies() {
		/*System.out.println("get Cookies called");
		if (remember.equals("true")) {
			Cookie cookie = new Cookie("remember", userid);
			cookie.setMaxAge(365*24*60*60);
			cookies.add(cookie);
			return cookies;
		}*/
		return null;
	}
	
	

}
