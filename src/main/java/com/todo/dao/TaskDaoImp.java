package com.todo.dao;

import com.todo.dto.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jni.Local;

import com.todo.connector.ConnectorFactory;
import com.todo.dto.Task;

public class TaskDaoImp implements TaskDao {

	@Override
	public List getTasks() {
		LocalDate currentDate = LocalDate.now();
		String ldate = currentDate.toString();
		ArrayList<Task> tasks = null;
		try {
			Connection con = ConnectorFactory.requestConnection();
			String query = "select * from tasks where date ='" + ldate+"'";
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);
			tasks = new ArrayList<Task>();
			while(res.next()){
				int id = res.getInt(1);
		 		String date = res.getString(2);
				String task = res.getString(3);
				boolean status = res.getBoolean(4);
				
				Task t = new Task(id,date,task,status);
//				System.out.println(t);
						tasks.add(t);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			return tasks;
		}
				


	@Override
	public Task getTask(String Date, String Task) {
		Task t = null;
		LocalDate currentDate = LocalDate.now();
		String date = currentDate.toString();
		try {
		Connection con = ConnectorFactory.requestConnection();
		String query = "select * from emp where date = ?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, date);
		ResultSet res = pstmt.executeQuery();
		res.next();
		t = new Task(res.getInt(1),res.getString(2),res.getString(3),res.getBoolean(4));
		} catch (Exception e2) {
		e2.printStackTrace();
		}
		return t;
		
	}

	@Override
	public void addTask(String NewTask, String Date) {
		
		LocalDate currentDate = LocalDate.now();
		
		try {
			  Connection con = ConnectorFactory.requestConnection();
			  PreparedStatement statement = con.prepareStatement("INSERT INTO tasks (`date`, `task`) VALUES (?, ?)");
		      statement.setDate(1, java.sql.Date.valueOf(currentDate));
		      statement.setString(2, NewTask);
		      statement.executeUpdate();
		      statement.close();

		      // Output success message
		      System.out.println("New Task added");
		     
		    } catch (SQLException | ClassNotFoundException e) {
		      e.printStackTrace();
		      // Handle the exception appropriately
		    }
	}

	@Override
	public void updateTask(int id, String status) {
		 try  {
			 	Connection con = ConnectorFactory.requestConnection();
	            String sql = "UPDATE tasks SET status = ? WHERE id = ?";
	            int taskId = id; // The ID of the task you want to update
	            boolean newStatus;
	            System.out.println(status);
	            if(status.equals("true")) {
	            	newStatus = false;
	            }
	            else {
	            	newStatus = true; 
	            }

	            PreparedStatement statement = con.prepareStatement(sql);
	            statement.setBoolean(1, newStatus);
	            statement.setInt(2, taskId);

	            int rowsUpdated = statement.executeUpdate();

	            if (rowsUpdated > 0) {
	                System.out.println("Status updated successfully!");
	            } else {
	                System.out.println("No task found with the given ID.");
	            }

	            statement.close();
	        } catch (SQLException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public void deleteTask(int id) {
		  try { Connection con = ConnectorFactory.requestConnection();
	            String sql = "DELETE FROM tasks WHERE id = ?";
	            int taskId = id; 

	            PreparedStatement statement = con.prepareStatement(sql);
	            statement.setInt(1, taskId);

	            int rowsDeleted = statement.executeUpdate();

	            if (rowsDeleted > 0) {
	                System.out.println("Task deleted successfully!");
	            } else {
	                System.out.println("No task found with the given ID.");
	            }

	            statement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}
