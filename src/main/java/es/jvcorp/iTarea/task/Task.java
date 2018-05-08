package es.jvcorp.iTarea.task;

import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
public class Task {

	private Long taskId;
	private String taskDescription;
	private Calendar startDate;
	private Calendar finishDate;
	private long version;
	
	public Task () {}
	
	public Task (String taskDescription, Calendar startDate) {
		
		/**
		 * NOTE: "taskId" *must* be left as "null" since its value is
		 * automatically generated.
		 */
		this.taskDescription = taskDescription;
		this.startDate = startDate;
	}

	@SequenceGenerator(             // It only takes effect for
	     name="TaskIdGenerator", // databases providing identifier
	     sequenceName="TaskSeq") // generators.
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO,
    				generator="TaskIdGenerator")
	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}
		
	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Calendar getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Calendar finishDate) {
		this.finishDate = finishDate;
	}
		
	@Version
    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

	@Override
	public String toString() {
    	
    	String string = "Task [taskId=" + taskId
    			+ ", productDescription=" + taskDescription;
    	
    	if (startDate != null){
    		string = string + ", startDate=" + startDate.toString();
    	}else{
    		string = string + ", startDate=null";
    	}
    	
    	if (finishDate != null){
    		string = string + ", finishDate=" + finishDate.toString();
    	}else{
    		string = string + ", finishDate=null";
    	}
    	
    	string = string + "]";
    	
		return string;
	}
}
