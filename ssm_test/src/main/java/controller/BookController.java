package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Book;
import service.Book_service;
import service.Type_service;

@Controller
@RequestMapping("Book")
public class BookController {
	@Autowired
	Book_service service;
	
	@Autowired
	Type_service tservice;
	
	@ExceptionHandler
	public void ex(Exception e) {
		e.printStackTrace();
	}
	
	@RequestMapping("index")
	public String index(String txt,ModelMap m) {
		String where = "";
		if(txt!=null)
			where = " where book.name like '%"+txt+"%'";
		m.put("bookList", service.select(where));
		return "Book/index";
	}
	
	@RequestMapping("add")
	public String  add(ModelMap m) {
		m.put("typelist", tservice.select(""));
		m.put("sexs", Book.sexs);
		return "Book/edit";
	}
	
	@RequestMapping("edit")
	public String  edit(int id,ModelMap m) {
		m.put("info", service.selectById(id));
		return add(m);
	}
	
	@RequestMapping("insert")
	public String  insert(Book b,ModelMap m) {
		service.insert(b);
		return index("",m);
	}
	@RequestMapping("update")
	public String  update(Book b,ModelMap m) {
		service.update(b);
		return index("",m);
	}
	@RequestMapping("delete")
	public String  delete(int id,ModelMap m) {
		service.delete(id);
		return index("",m);
	}

}

