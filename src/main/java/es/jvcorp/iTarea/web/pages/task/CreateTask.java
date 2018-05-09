package es.jvcorp.iTarea.web.pages.task;

import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;

import es.jvcorp.iTarea.model.taskservice.TaskService;
import es.jvcorp.iTarea.model.util.exceptions.InstanceNotFoundException;
import es.jvcorp.iTarea.web.pages.SuccessfulOperation;

public class CreateTask {
	
	@Property
	private String taskDescription;
	
	@Inject
	private TaskService taskService;
	
	@InjectPage
	private SuccessfulOperation successfulOperation;
	
	@Component
	private Form createTaskForm;
	
	@Inject
	private Messages messages;
	
	void onValidateFromCreateTaskForm() throws InstanceNotFoundException{

        if (!createTaskForm.isValid()) {
            return;
        }

        taskService.createTask(taskDescription);
    }
	
	Object onSuccessFromCreateTaskForm(){
		
		return successfulOperation;
	}
}
