package service;

import java.util.List;



import model.Type;

public interface Type_service {

	public List<Type> select(String txt);
	
	public void insert(Type t);
	
	public void update(Type t);
	
	public void delete(int id);

	public Type selectById(int id);
}
