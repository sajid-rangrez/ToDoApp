package com.todo.dto;

public class Task {
	private int Id;
	private String Date;
	private String Task;
	private Boolean Status;
	
	public Task() {
		super();
		
	}
	public Task(int id, String date, String task, Boolean status) {
		super();
		Id = id;
		Task = task;
		Date = date;
		Status = status;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		this.Id = id;
	}
	public String getTask() {
		return Task;
	}
	public void setTask(String task) {
		Task = task;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public Boolean getStatus() {
		return Status;
	}
	public void setStatus(Boolean status) {
		Status = status;
	}
	public String toString() {
		return Id +" "+ Date +" "+ Task +" "+ Status;
	}
}
