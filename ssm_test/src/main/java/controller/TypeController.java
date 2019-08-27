package controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import model.Type;
import service.Type_service;

@Controller
@RequestMapping("Type")
public class TypeController {
	@Autowired
	Type_service service;

	@RequestMapping("aaa")
	public @ResponseBody String aaa(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest req) throws Exception {
		String oname = file.getOriginalFilename();
		String ex = oname.substring(oname.lastIndexOf("."), oname.length());
		String nname = UUID.randomUUID() + ex;

		String path = req.getSession().getServletContext().getRealPath("\\");
		path = new File(path).getParentFile().getPath() + "\\upload";
		File p = new File(path);		
		if(!p.exists()){
			p.mkdir();
		}
		System.out.println(path);
		file.transferTo(new File(path, nname));
		System.out.println("/upload/"+nname);
		return  "/upload/"+nname;
	}

	@ExceptionHandler
	public void ex(Exception e) {
		e.printStackTrace();
	}

	@RequestMapping("index")
	public String index(String txt, ModelMap m) {
		String where = "";
		if (txt != null)
			where = " where name like '%" + txt + "%'";
		m.put("typeList", service.select(where));
		return "Type/index";
	}

	@RequestMapping("add")
	public String add(ModelMap m) {
		return "Type/edit";
	}

	@RequestMapping("edit")
	public String edit(int id, ModelMap m) {
		m.put("info", service.selectById(id));
		return add(m);
	}

	@RequestMapping("insert")
	public String insert(Type b, ModelMap m) {
		service.insert(b);
		return index("", m);
	}

	@RequestMapping("update")
	public String update(Type b, ModelMap m) {
		service.update(b);
		return index("", m);
	}

	@RequestMapping("delete")
	public String delete(int id, ModelMap m) {
		service.delete(id);
		return index("", m);
	}

}
