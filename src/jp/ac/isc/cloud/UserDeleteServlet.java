package jp.ac.isc.cloud;

import java.io.*;

import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class UserDeleteServlet {

protected void doPost(HttpServletRequest request, HttpServletResponse response)
		 throws ServletException, IOException {
		 try {
		 Connection users = null;
		 try {
			 users = DBConnection.openConnection();
		 String id = request.getParameter("deleteId");
		 Statement state = users.createStatement();
		 state.executeUpdate("DELETE FROM user_table WHERE id='" + id + "'");
		 DBConnection.closeConnection(users, state);
		 response.sendRedirect("/select"); //UserSelectServletを呼び出す
		 }
		 }catch(SQLException e){
		 e.printStackTrace();
		 }
}
}
