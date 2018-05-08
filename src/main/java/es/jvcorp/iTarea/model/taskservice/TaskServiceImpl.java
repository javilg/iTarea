package es.jvcorp.iTarea.model.taskservice;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.jvcorp.iTarea.model.task.Task;
import es.jvcorp.iTarea.model.task.TaskDao;

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
}
