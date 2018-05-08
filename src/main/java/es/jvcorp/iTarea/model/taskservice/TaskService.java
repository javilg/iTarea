package es.jvcorp.iTarea.model.taskservice;

import es.jvcorp.iTarea.model.task.Task;
import es.jvcorp.iTarea.model.util.exceptions.InstanceNotFoundException;

public interface TaskService {

	public Task createTask(String taskDescription);
	
	public void markTaskAsDone(Long taskId) throws InstanceNotFoundException;
	
	public void deleteTask(Long taskId) throws InstanceNotFoundException;
	
	public TaskBlock findAllTasks(int startIndex, int count);
	
	public int getNumberOfTasks();
}
