package jp.ac.isc.cloud;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class UserInsertServlet {

protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {

	 Connection users = null;
	 try {
		 users = DBConnection.openConnection();
	 String id = request.getParameter("insertId");
	 String name = request.getParameter("insertName");
	 String picture = request.getParameter("insertPicture");
	 Statement state = users.createStatement();
	 state.executeUpdate("INSERT INTO user_table VALUE('" + id + "','" + name +
	 "','" + picture + "')");
	 DBConnection.closeConnection(users, state);
	 response.sendRedirect("/select"); //UserSelectServletを呼び出す

	 }catch(SQLException e){
	 e.printStackTrace();
	 }
}
}