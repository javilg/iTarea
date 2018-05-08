package es.jvcorp.iTarea.model.task;

import java.util.List;

import es.jvcorp.iTarea.model.util.dao.GenericDao;

public interface TaskDao extends GenericDao<Task, Long> {

	List<Task> findAllTasks(int startIndex, int count);

	int getNumberOfTasks();
}
