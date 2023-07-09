package com.todo;

import java.util.List;

import com.todo.dao.TaskDaoImp;
import com.todo.dto.Task;

public class taskMain {
public static void main(String[] args) {
	
	for(;;) {
		
		TaskDaoImp TaskDaoImp = new TaskDaoImp();
		List<Task> Tasks = TaskDaoImp.getTasks();
		for(Task e :Tasks) {
		System.out.println(e);
		}
	}

	}
}
