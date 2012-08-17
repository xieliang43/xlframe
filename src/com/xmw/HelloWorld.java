package com.xmw;

import java.io.IOException;

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
		System.out.println(sqlSession);
		sqlSession.selectList("example.getVoucherNo");
		ServletOutputStream os = getResponse().getOutputStream();
		os.print(name);
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
