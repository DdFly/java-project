package com.example.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	Statement sta;
	Connection conn;
	
	public boolean openConnection(){
		try {  
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentcar","root","123456");
			sta = conn.createStatement();
            return true;
        } catch(ClassNotFoundException classnotfoundexception) {  
              classnotfoundexception.printStackTrace();  
            System.err.println("db: " + classnotfoundexception.getMessage());  
        } catch(SQLException sqlexception) {  
            System.err.println("db.getconn(): " + sqlexception.getMessage());  
        }
		return	false;
	}
	
	
	protected void finalize() throws Exception{
		try {
		if(null!=conn)
			conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
     }
	
	// ��ѯ���õ������
	public ResultSet execQuery(String sql) throws Exception {
		ResultSet rstSet = null;
		try {
			if (null == conn)
				throw new Exception("Database not connected!");
			Statement stmt = conn.createStatement();
			rstSet = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rstSet;
	}

	// ����һ���¼�¼������ȡ��ʶ�е�ֵ
	public ResultSet getInsertObjectIDs(String insertSql) throws Exception{
		ResultSet rst = null;
		try {
			if(null==conn)
				throw new Exception("Database not connected!");
			
			Statement stmt = conn.createStatement();
			
			stmt.executeUpdate(insertSql, Statement.RETURN_GENERATED_KEYS);
			rst = stmt.getGeneratedKeys();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rst;
	}

	// ���롢���¡�ɾ��
	public int execCommand(String sql) throws Exception{
		int flag = 0;
		try {
			if(null==conn)
				throw new Exception("Database not connected!");
			
			Statement stmt = conn.createStatement();
			flag = stmt.executeUpdate(sql);
			
			stmt.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	// �ͷ���Դ
	public void close(ResultSet rst) throws Exception {
		try {
			Statement stmt = rst.getStatement();
			rst.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	// �ͷ���Դ
	public void close(Statement stmt) throws Exception {
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// �ͷ���Դ
	public void close() throws SQLException, Exception{
		if(null!=conn){
			conn.close();
			conn=null;
		}
	}
	public Statement getSta() {
		return sta;
	}
	
}
