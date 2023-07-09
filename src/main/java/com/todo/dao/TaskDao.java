package com.todo.dao;

import java.util.List;

import com.todo.dto.Task;

public interface TaskDao {
	List getTasks();
	Task getTask(String Date, String Task);
	void addTask(String Task, String Date);
	void updateTask(int id, String status);
	void deleteTask(int id);
	
}
