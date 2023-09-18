package model;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;

import dao.CaluclateDao;

/**
 * @author nakano@cc.kumamoto-u.ac.jp
 * @version 2022-07-07 applied for DB / DB対応
 * @since 2015-05-07
 * 
 * database version
 */
public class CaluclateModel {
	private CaluclateDao dao = new CaluclateDao();
	
	public void setCaluclate(String name, String atime, String elapsed_time) {
		Caluclate c = new Caluclate();
		if(name == null) name = "";
		if(name.isEmpty()) name = "no name";
		c.setName(name.replaceAll("\\<.+?>", ""));
		if(atime == null) atime = "";
		if(atime.isEmpty()) atime = "no comment";
		c.setAtime(atime.replaceAll("\\<.*?>",""));
		if(elapsed_time == null) elapsed_time = "";
		if(elapsed_time.isEmpty()) elapsed_time = "no name";
		c.setElapsed_time(elapsed_time.replaceAll("\\<.*?>",""));
		dao.insert(c);
	}
	
	// for WebAPI (JSON)
	public ArrayList<LinkedHashMap<String,Object>> getHistoryJSON() {
		ArrayList<LinkedHashMap<String,Object>> ret = new ArrayList<LinkedHashMap<String,Object>>();
		ArrayList<Caluclate> clcs = dao.getAll();
		for(Caluclate c : clcs) {
			LinkedHashMap<String,Object> line = new LinkedHashMap<String,Object>();
			line.put("name", c.getName());
			line.put("atime", c.getAtime());
			line.put("elapsed_time", c.getElapsed_time());
			ret.add(line);
		}
		return ret;
	}

	// delete all data
	public void init() {
		dao.deleteAll();
	}
}