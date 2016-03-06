package Myalbum;
import java.sql.Date;
import java.util.ArrayList;

/**
 * @author Administrator
 *
 */
public class MyalbumDTO {
	private String myalbumid;
	private String myalbumname;
	public MyalbumDTO() {
		super();
	}
	public MyalbumDTO(String myalbumid, String myalbumname) {
		super();
		this.myalbumid = myalbumid;
		this.myalbumname = myalbumname;
	}
	public String getMyalbumid() {
		return myalbumid;
	}
	public void setMyalbumid(String myalbumid) {
		this.myalbumid = myalbumid;
	}
	public String getMyalbumname() {
		return myalbumname;
	}
	public void setMyalbumname(String myalbumname) {
		this.myalbumname = myalbumname;
	}
	
	
	
		

}
