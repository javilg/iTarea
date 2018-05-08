package es.jvcorp.iTarea.model.taskservice;

import es.jvcorp.iTarea.model.task.Task;
import es.jvcorp.iTarea.model.util.exceptions.InstanceNotFoundException;

/**
 * The TaskService interface contains the personal 
 * task manager public methods
 * @author: Javier Lozano
 * @version: 08/05/2018
 */
public interface TaskService {

	/**
     * The method that creates a task and save in database
     * @param taskDescription The parameter defines the description 
     * of the task that is being created
     * @return The created task
     */
	public Task createTask(String taskDescription);
	
	/**
     * The method marked a task as done
     * @param taskId The parameter defines the ID of the task 
     * that will be marked as done
     * @exception InstanceNotFoundException The exception occurs when 
     * the task does not exist
     */
	public void markTaskAsDone(Long taskId) throws InstanceNotFoundException;
	
	/**
     * The method deleted the specific task
     * @param taskId The parameter defines the ID of the task 
     * that will be deleted
     * @exception InstanceNotFoundException The exception occurs when 
     * the task does not exist
     */
	public void deleteTask(Long taskId) throws InstanceNotFoundException;
	
	/**
     * The method that find all tasks created with pattern page-by-page iterator
     * @param startIndex The parameter defines the start position 
     * of the search for tasks
     * @param count The parameter defines the number of elements 
     * to the result of the search for tasks
     * @return The tasks list with page-by-page iterator
     */
	public TaskBlock findAllTasks(int startIndex, int count);
	
	/**
     * The method that returns the total number of tasks for 
     * the pattern page-by-page iterator
     * @return The total number of tasks
     */
	public int getNumberOfTasks();
}
