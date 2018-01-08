package project.interceptors;

import java.util.Map;

import org.apache.struts2.interceptor.CookiesAware;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class CookieInterceptor implements CookiesAware, Interceptor {
	Map<String, String> cookies;

	@Override
	public void setCookiesMap(Map<String, String> cookies) {
		this.cookies = cookies;
	}

	@Override
	public void destroy() {

	}

	@Override
	public void init() {
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		try{
			//if cookie exists
			if (cookies.containsKey("remember")) {
				return "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return invocation.invoke();
	}

}
