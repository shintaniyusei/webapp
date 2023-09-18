package model;
import java.util.Date;

/**
 * @author nakano@cc.kumamoto-u.ac.jp
 * 2022-07-06: add constructor
 * @version 2022-07-06 from 2015-04-23
 * 
 * MVC sample program : Data object for Model
 *
 */
public class Caluclate {
	
	private String name;
	private String atime;
	private String elapsed_time;
	/**
	 * Constructor / コンストラクタ
	 */
	public Caluclate() {
	}
	public Caluclate(String name, String atime, String elapsed_time) {
		this.name = name;
		this.atime = atime;
		this.elapsed_time = elapsed_time;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAtime() {
		return atime;
	}
	public void setAtime(String atime) {
		this.atime = atime;
	}
	public String getElapsed_time() {
		return elapsed_time;
	}
	public void setElapsed_time(String elapsed_time) {
		this.elapsed_time = elapsed_time;
	}
	
}
