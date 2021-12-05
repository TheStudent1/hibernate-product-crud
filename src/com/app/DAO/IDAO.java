package com.app.DAO;

import java.util.List;

public interface IDAO<E> {

	boolean create(E e);

	E getOne(Long id);

	boolean update(E e);

	boolean delete(E e);

	List<E> getAll();

	List<E> getAll(String mc);
}
