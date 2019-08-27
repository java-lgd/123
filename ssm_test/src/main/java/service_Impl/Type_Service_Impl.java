package service_Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Type_Dao;
import model.Type;
import service.Type_service;
@Service
public class Type_Service_Impl implements Type_service {
    @Autowired
    Type_Dao dao;
	public List<Type> select(String txt) {
		return dao.select(txt);
	}
	
	public Type selectById(int id) {
		return dao.selectById(id);
	}

	public void insert(Type t) {
		dao.insert(t);
	}

	public void update(Type t) {
		dao.update(t);
	}

	public void delete(int id) {
		dao.delete(id);
	}

}
