package es.jvcorp.iTarea.model.taskservice;

import java.util.List;

import es.jvcorp.iTarea.model.task.Task;

public class TaskBlock {

	private List<Task> tasks;
	private boolean existMoreTasks;
	
	public TaskBlock(List<Task> tasks, boolean existMoreTasks){
		
		this.tasks = tasks;
		this.existMoreTasks = existMoreTasks;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public boolean isExistMoreTasks() {
		return existMoreTasks;
	}

	public void setExistMoreTasks(boolean existMoreTasks) {
		this.existMoreTasks = existMoreTasks;
	}
}
