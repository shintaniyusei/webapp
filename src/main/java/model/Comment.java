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
public class Comment {
	
	private Date date;
	private String name;
	private String atime;
	private String btime;
	private String com;

	/**
	 * Constructor / コンストラクタ
	 */
	public Comment() {
	}
	public Comment(String name, String atime, String btime, String com, Date date) {
		this.name = name;
		this.atime = atime;
		this.btime = btime;
		this.com = com;
		this.date = date;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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
	public String getBtime() {
		return btime;
	}
	public void setBtime(String btime) {
		this.btime = btime;
	}
	public String getCom() {
		return com;
	}
	public void setCom(String com) {
		this.com = com;
	}
	
}
