package com.todo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todo.dao.TaskDaoImp;

@WebServlet("/deleteTask")
public class deleteTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public deleteTask() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idvalue = request.getParameter("taskId");
		int id = Integer.parseInt(idvalue);
		TaskDaoImp td = new TaskDaoImp();
		td.deleteTask(id);
		response.sendRedirect("todo.jsp");
	}

}
