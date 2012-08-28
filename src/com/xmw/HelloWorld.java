package com.xmw;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;

import org.mybatis.spring.SqlSessionTemplate;

public class HelloWorld extends AppAction {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private SqlSessionTemplate sqlSession;
	
	public String execute(){
		return SUCCESS;
	}
	
	public void sayHello() throws IOException{
		SqlSessionTemplate sqlSession = getSqlSession();
		ArrayList<Object> list = (ArrayList<Object>)sqlSession.selectList("example.getVoucherNo");
		
		System.out.println(list.size());
		
		ServletOutputStream os = getResponse().getOutputStream();
		os.print("<html><head></head><body>");
		for(int i=0;i<list.size();i++){
			
			@SuppressWarnings("unchecked")
			HashMap<String, String> map = (HashMap<String, String>)list.get(0);
			name = (String)map.get("V_KEY");
			os.print(name+"<br/>");
			
		}
		os.print("</body></html>");
		os.flush();
		os.close();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

}
