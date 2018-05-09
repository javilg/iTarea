package es.jvcorp.iTarea.model.task;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import es.jvcorp.iTarea.model.util.dao.GenericDaoHibernate;

@Repository("taskDao")
public class TaskDaoHibernate extends GenericDaoHibernate<Task, Long>
	implements TaskDao {

	@SuppressWarnings("unchecked")
	public List<Task> findAllTasks(int startIndex, int count) {
		
		/* Make query. */
		Query query = getSession().createQuery(
    			"SELECT t FROM Task t"
    			+ " ORDER BY t.startDate DESC")				
    			.setFirstResult(startIndex)
				.setMaxResults(count);;
    	
		return query.list();
	}

	public int getNumberOfTasks() {
		
		/* Make query. */
		Query query = getSession().createQuery(
    			"SELECT COUNT(t.taskId) FROM Task t");
    	
		int numberOfTasks = Integer.valueOf(query.uniqueResult().toString());
		return numberOfTasks;
	}
}