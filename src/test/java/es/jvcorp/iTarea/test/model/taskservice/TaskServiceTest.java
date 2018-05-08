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
import es.jvcorp.iTarea.model.taskservice.TaskBlock;
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
	
	@Test
	public void testFindAllTasks(){
		
		/* Create tasks. */
		String taskDescription1 = "Buy a new laptop";
		Task task1 = taskService.createTask(taskDescription1);
		
		String taskDescription2 = "Go to the gym on Tuesday";
		Task task2 = taskService.createTask(taskDescription2);
		
		String taskDescription3 = "Book restaurant weekend.";
		Task task3 = taskService.createTask(taskDescription3);
		
		/* Find two tasks. */
		int startIndex = 0;
		int count = 2;
		TaskBlock taskBlock = taskService.findAllTasks(startIndex, count);
		
		/* Check data. */
		assertEquals(2, taskBlock.getTasks().size());
		assertTrue(taskBlock.getTasks().contains(task1));
		assertTrue(taskBlock.getTasks().contains(task2));
		assertFalse(taskBlock.getTasks().contains(task3));
		assertEquals(true, taskBlock.isExistMoreTasks());
		
		/* Find more tasks. */
		int startIndex2 = 2;
		int count2 = 10;
		TaskBlock taskBlock2 = taskService.findAllTasks(startIndex2, count2);
		
		/* Check data. */
		assertEquals(1, taskBlock2.getTasks().size());
		assertTrue(taskBlock2.getTasks().contains(task3));
		assertEquals(false, taskBlock2.isExistMoreTasks());
	}
	
	@Test
	public void testGetNumberOfTasks(){
		
		/* Create tasks. */
		String taskDescription1 = "Buy a new laptop";
		taskService.createTask(taskDescription1);
		
		String taskDescription2 = "Go to the gym on Tuesday";
		taskService.createTask(taskDescription2);
		
		String taskDescription3 = "Book restaurant weekend.";
		taskService.createTask(taskDescription3);
		
		/* Get number of tasks. */
		int numberOfTasks = taskService.getNumberOfTasks();
		
		/* Check data. */
		assertEquals(3, numberOfTasks);
	}
}