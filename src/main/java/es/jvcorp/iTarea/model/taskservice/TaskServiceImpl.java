package es.jvcorp.iTarea.model.taskservice;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.jvcorp.iTarea.model.task.Task;
import es.jvcorp.iTarea.model.task.TaskDao;
import es.jvcorp.iTarea.model.util.exceptions.InstanceNotFoundException;

@Service("taskService")
@Transactional
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskDao taskDao;
	
	public Task createTask(String taskDescription){
		
		/* Create task object. */
		Calendar startDate = Calendar.getInstance();
		Task task = new Task(taskDescription, startDate);
		
		/* Save task entity in DB. */
		taskDao.save(task);
		
		return task;
	}

	public void markTaskAsDone(Long taskId) throws InstanceNotFoundException {
		
		/* Find task in DB. */
		Task task = taskDao.find(taskId);
		
		/* Set finish date to mark task. */
		Calendar finishDate = Calendar.getInstance();
		task.setFinishDate(finishDate);
	}

	public void deleteTask(Long taskId) throws InstanceNotFoundException {
		
		/* Delete task. */
		taskDao.remove(taskId);
	}

	public TaskBlock findAllTasks(int startIndex, int count) {
		
		/*
		 * Find count+1 tasks to determine if there exist more tasks
		 * above the specified range.
		 */
		List<Task> tasks = taskDao.findAllTasks(startIndex, count + 1);
		
		boolean existMoreTasks = tasks.size() == (count + 1);
		
		/*
		 * Remove the last task from the returned list if there exist
		 * more tasks above the specified range.
		 */
		if (existMoreTasks) {
			tasks.remove(tasks.size() - 1);
		}
		
		/* Return TaskBlock */
		return new TaskBlock(tasks, existMoreTasks);
	}
	
	@Transactional(readOnly = true)
	public int getNumberOfTasks(){
		
		int numberOfTasks = taskDao.getNumberOfTasks();
		return numberOfTasks;
	}
}
