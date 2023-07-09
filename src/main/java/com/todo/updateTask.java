package com.todo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todo.dao.TaskDao;
import com.todo.dao.TaskDaoImp;

/**
 * Servlet implementation class updateTask
 */
@WebServlet("/updateTask")
public class updateTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public updateTask() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("updateTask is called");
		
		String idvalue = request.getParameter("taskId");
		String status = request.getParameter("status");
		System.out.println(idvalue);
		int id = Integer.parseInt(idvalue);
		
		TaskDaoImp td = new TaskDaoImp();
		td.updateTask(id, status);
		response.sendRedirect("todo.jsp");
	}


}
