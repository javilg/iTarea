package es.jvcorp.iTarea.model.task;

import org.springframework.stereotype.Repository;

import es.jvcorp.iTarea.model.util.dao.GenericDaoHibernate;

@Repository("taskDao")
public class TaskDaoHibernate extends GenericDaoHibernate<Task, Long>
	implements TaskDao {

}