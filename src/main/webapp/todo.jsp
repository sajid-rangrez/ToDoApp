
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.todo.dao.TaskDaoImp"%>
<%@ page import="com.todo.dto.Task"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Todo List</title>
<link rel="stylesheet" href="todo.css">
</head>
<body>
	<div class="container">
		<div class="todo-app">
			<h2>TO DO LIST</h2>
			<form class="row" action="addItem">
				<input name="task" type="text" id="input-box"
					placeholder="Add items">
				<button class="AddButton" type="submit">Add</button>
			</form>

			<%!TaskDaoImp td = new TaskDaoImp();%>
			<%
			List<Task> Tasks = td.getTasks();
			for (Task e : Tasks) {
			%>
			<div class="listBox">
				<div class="con">
					<%
						if (e.getStatus().equals(false)) {
						%>
						<p  class="text">
						<%
						out.println(e.getTask());
						%>
						</p>
						<%
						} else {
						%>
						<p style="text-decoration: line-through;" class="text">
						<%
						out.println(e.getTask());
						%>
					</p>
						<%
						}
						%>
					
				</div>
				<div class="con2">
					<form action="updateTask">
						<input type="hidden" name="taskId"
							value="<%out.print(e.getId());%>"> <input type="hidden"
							name="status" value="<%out.print(e.getStatus());%>">
						<%
						if (e.getStatus().equals(false)) {
						%>
						<button class="DoButton" type="submit">Done!</button>
						<%
						} else {
						%>
						<button class="deleteButton" type="submit">Undo</button>
						<%
						}
						%>
					</form>
					<form action="deleteTask">
						<input type="hidden" name="taskId"
							value="<%out.print(e.getId());%>">
						<button class="deleteButton" type="submit">Delete</button>
					</form>
				</div>
			</div>
			<br>
			<%
			}
			%>

		</div>

	</div>
</body>
</html>