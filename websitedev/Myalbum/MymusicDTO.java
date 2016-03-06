package Myalbum;
import java.sql.Date;
import java.util.ArrayList;

/**
 * @author Administrator
 *
 */
public class MymusicDTO {
	private String myalbumid;
	private String musicid;
	public MymusicDTO(String myalbumid, String musicid) {
		super();
		this.myalbumid = myalbumid;
		this.musicid = musicid;
	}
	public MymusicDTO() {
		super();
	}
	public String getMyalbumid() {
		return myalbumid;
	}
	public void setMyalbumid(String myalbumid) {
		this.myalbumid = myalbumid;
	}
	public String getMusicid() {
		return musicid;
	}
	public void setMusicid(String musicid) {
		this.musicid = musicid;
	}
	

	
	
	

}
