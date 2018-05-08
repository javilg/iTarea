package es.jvcorp.iTarea.model.util.dao;

import java.io.Serializable;

import es.jvcorp.iTarea.model.util.exceptions.InstanceNotFoundException;

public interface GenericDao <E, PK extends Serializable>{

	void save(E entity);

	E find(PK id) throws InstanceNotFoundException;

	void remove(PK id) throws InstanceNotFoundException;

}
