package model;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;

import dao.Dao;

/**
 * @author nakano@cc.kumamoto-u.ac.jp
 * @version 2022-07-07 applied for DB / DB対応
 * @since 2015-05-07
 * 
 * database version
 */
public class Model {
	private Dao dao = new Dao();
	
	public void setComment(String name, String atime, String btime, String com) {
		Comment c = new Comment();
		if(name == null) name = "";
		if(name.isEmpty()) name = "no name";
		c.setName(name.replaceAll("\\<.+?>", ""));
		if(atime == null) atime = "";
		if(atime.isEmpty()) atime = "no comment";
		c.setAtime(atime.replaceAll("\\<.*?>",""));
		if(btime == null) btime = "";
		if(btime.isEmpty()) btime = "no name";
		c.setBtime(btime.replaceAll("\\<.*?>",""));
		if(com == null) com = "";
		if(com.isEmpty()) com = "no comment";
		c.setCom(com.replaceAll("\\<.*?>",""));
		c.setDate(new Date());
		dao.insert(c);
	}
	
	// for WebAPI (JSON)
	public ArrayList<LinkedHashMap<String,Object>> getHistoryJSON() {
		ArrayList<LinkedHashMap<String,Object>> ret = new ArrayList<LinkedHashMap<String,Object>>();
		ArrayList<Comment> cmts = dao.getAll();
		for(Comment c : cmts) {
			LinkedHashMap<String,Object> line = new LinkedHashMap<String,Object>();
			line.put("name", c.getName());
			line.put("date", c.getDate().getTime());
			line.put("atime", c.getAtime());
			line.put("btime", c.getBtime());
			line.put("com", c.getCom());
			ret.add(line);
		}
		return ret;
	}

	// delete all data
	public void init() {
		dao.deleteAll();
	}
}