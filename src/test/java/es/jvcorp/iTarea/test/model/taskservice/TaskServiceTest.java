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
}