package jp.ac.isc.cloud;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class UserUpdateServlet {

protected void doPost(HttpServletRequest request, HttpServletResponse response)
		 throws ServletException, IOException {
	try {
		Connection users = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
				users = DriverManager.getConnection("jdbc:mysql://localhost/servlet_db?useUnicode=true&characterEncoding=utf8","root","");
				String id = request.getParameter("updateId");
				String name = request.getParameter("updateName");
				String picture = request.getParameter("updatePicture");
				Statement state = users.createStatement();
				if(name.length() != 0){
					state.executeUpdate("UPDATE user_table SET name='" + name + "' WHERE id ='" + id + "'");
				}
				if(picture.length() != 0){
					state.executeUpdate("UPDATE user_table SET picture='" + picture + "' WHERE id ='" + id + "'");
				}
				state.close();
				users.close();
				response.sendRedirect("/select");	//UserSelectServletを呼び出す
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	}
}