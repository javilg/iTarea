package es.jvcorp.iTarea.test.model.taskservice;

import static es.jvcorp.iTarea.model.util.GlobalNames.SPRING_CONFIG_FILE;
import static es.jvcorp.iTarea.test.util.GlobalNames.SPRING_CONFIG_TEST_FILE;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import es.jvcorp.iTarea.model.task.Task;
import es.jvcorp.iTarea.model.task.TaskDao;
import es.jvcorp.iTarea.model.taskservice.TaskService;
import es.jvcorp.iTarea.model.util.exceptions.InstanceNotFoundException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { SPRING_CONFIG_FILE, SPRING_CONFIG_TEST_FILE })
@Transactional
public class TaskServiceTest {	
	
	private final long NON_EXISTENT_TASK_ID = -1;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private TaskDao taskDao;
	
	@Test
	public void testCreateTask() throws InstanceNotFoundException{
		
		/* Create task. */
		String taskDescription = "Buy a new laptop";
		Task task = taskService.createTask(taskDescription);
		
		/* Find task. */
		Task taskFound = taskDao.find(task.getTaskId());

		/* Check data. */
		assertEquals(task, taskFound);
	}
	
	@Test 
	public void testMarkTaskAsDone() throws InstanceNotFoundException{
		
		/* Create task. */
		String taskDescription = "Buy a new laptop";
		Task task = taskService.createTask(taskDescription);
		
		/* Mark task as done. */
		taskService.markTaskAsDone(task.getTaskId());
		
		/* Find task. */
		Task taskFound = taskDao.find(task.getTaskId());
		
		/* Check data. */
		assertEquals(task.getTaskId(), taskFound.getTaskId());
		assertTrue(taskFound.getFinishDate() != null);
	}
	
	@Test(expected = InstanceNotFoundException.class)
	public void testMarkTaskAsDoneWithNonExistentTask() throws InstanceNotFoundException{
		
		/* Mark task as done with non existent task id. */
		taskService.markTaskAsDone(NON_EXISTENT_TASK_ID);
	}
	
	@Test(expected = InstanceNotFoundException.class)
	public void testDeleteTask() throws InstanceNotFoundException{
		
		/* Create task. */
		String taskDescription = "Buy a new laptop";
		Task task = taskService.createTask(taskDescription);
		
		/* Delete task. */
		taskService.deleteTask(task.getTaskId());
		
		/* Check data. */
		taskDao.find(task.getTaskId());
	}
	
	@Test(expected = InstanceNotFoundException.class)
	public void testDeleteTaskWithNonExistentTaskId() throws InstanceNotFoundException{
		
		/* Delete task with non existent task id. */
		taskService.deleteTask(NON_EXISTENT_TASK_ID);
	}
}