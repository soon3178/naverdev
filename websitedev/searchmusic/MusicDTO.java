package searchmusic;
import java.sql.Date;
import java.util.ArrayList;

/**
 * @author Administrator
 *
 */
public class MusicDTO {
	private String musicid;
	private String musicname;
	private String musicianid;
	private String albumid;
	private String genre;
	private int playtime;
	private String musicvideo;
	private String musicroute;
	
	public MusicDTO() {
		super();
	}
	
	public MusicDTO(String musicid, String musicname, String musicianid,
			String albumid, String genre, int playtime, String musicvideo,
			String musicroute) {
		super();
		this.musicid = musicid;
		this.musicname = musicname;
		this.musicianid = musicianid;
		this.albumid = albumid;
		this.genre = genre;
		this.playtime = playtime;
		this.musicvideo = musicvideo;
		this.musicroute = musicroute;
	}
	public String getMusicid() {
		return musicid;
	}
	public void setMusicid(String musicid) {
		this.musicid = musicid;
	}
	public String getMusicname() {
		return musicname;
	}
	public void setMusicname(String musicname) {
		this.musicname = musicname;
	}
	public String getMusicianid() {
		return musicianid;
	}
	public void setMusicianid(String musicianid) {
		this.musicianid = musicianid;
	}
	public String getAlbumid() {
		return albumid;
	}
	public void setAlbumid(String albumid) {
		this.albumid = albumid;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getPlaytime() {
		return playtime;
	}
	public void setPlaytime(int playtime) {
		this.playtime = playtime;
	}
	public String getMusicvideo() {
		return musicvideo;
	}
	public void setMusicvideo(String musicvideo) {
		this.musicvideo = musicvideo;
	}
	public String getMusicroute() {
		return musicroute;
	}
	public void setMusicroute(String musicroute) {
		this.musicroute = musicroute;
	}
	
	

	
	
	

}
