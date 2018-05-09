package es.jvcorp.iTarea.web.pages.task;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.apache.tapestry5.annotations.Property;

import es.jvcorp.iTarea.model.task.Task;
import es.jvcorp.iTarea.model.taskservice.TaskBlock;
import es.jvcorp.iTarea.model.taskservice.TaskService;
import es.jvcorp.iTarea.model.util.exceptions.InstanceNotFoundException;

public class ViewAllTasks {
	
	private TaskBlock taskBlock;
	private int startIndex = 0;
	private int count = 10;
	
	@Property
	private int totalNumberOfTasks;
	
	@Property
	private List<Integer> pagesList;
	
	@Property
	private int pageInt;
	
	@Property
	private Task task;
	
	@Inject
	private TaskService taskService;
	
	@Inject
	private Locale locale;
	
	public DateFormat getDateFormat() {
		return DateFormat.getDateInstance(DateFormat.SHORT, locale);
	}
	
	public List<Task> getTasks() {
		return taskBlock.getTasks();
	}
	
	public boolean isTaskDone() {
		return task.getFinishDate() != null;
	}
	
	public Object[] getPreviousLinkContext() {
		
		if (startIndex-count >= 0) {
			return new Object[] {startIndex-count, count};
		} else {
			return null;
		}
		
	}
	
	public Object[] getNextLinkContext() {
		
		if (taskBlock.isExistMoreTasks()){
			return new Object[] {startIndex+count, count};
		} else{
			return null;
		}
	}
	
	public Object[] getPageIntLinkContext() {
		
		int startIndexPage = (this.pageInt-1) * count;
		
		if (startIndexPage != this.startIndex){
			return new Object[] {startIndexPage, count};
		}else{
			return null;
		}
	}
	
	void onActivate(int startIndex, int count) {

		this.startIndex = startIndex;
		this.count = count;
		
		/* Find all tasks. */
		taskBlock = taskService.findAllTasks(startIndex, count);
		
		/* Get total number of products for pagination. */
		totalNumberOfTasks = taskService.getNumberOfTasks();
		int pages=0;
		pagesList = new ArrayList<Integer>();
		if (totalNumberOfTasks % count == 0){
			pages = totalNumberOfTasks / count;
		}else{
			pages = (this.totalNumberOfTasks / count) + 1;
		}	
		
		for (int i=1; i<=pages; i++){
			this.pagesList.add(i);
		}
	
	}
	
	Object[] onPassivate() {
		return new Object[] {startIndex, count};
	}
	
	void onActionFromMarkTaskAsDone(long taskId) throws InstanceNotFoundException{
		
		taskService.markTaskAsDone(taskId);
	}
	
	void onActionFromDeleteTask(long taskId) throws InstanceNotFoundException{
		
		taskService.deleteTask(taskId);
	}
	
	void onActionFromDeleteTask2(long taskId) throws InstanceNotFoundException{
		
		taskService.deleteTask(taskId);
	}
}
