package com.xmw.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AppAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	protected String result;
	
	public HttpServletRequest getRequest(){
		ActionContext ctx = ActionContext.getContext();       
	    HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
	    return request;
	}
	
	public HttpServletResponse getResponse(){
		ActionContext ctx = ActionContext.getContext();       
		HttpServletResponse response = (HttpServletResponse)ctx.get(ServletActionContext.HTTP_RESPONSE);
	    return response;
	}

	public SqlSessionTemplate getSqlSession(){
		SqlSessionTemplate sqlSession = null;
		ActionContext ctx = ActionContext.getContext();       
	    HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		ApplicationContext springContext = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
		sqlSession = (SqlSessionTemplate)springContext.getBean("sqlSession");
		return sqlSession;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
