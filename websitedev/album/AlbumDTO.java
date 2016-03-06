package album;

import java.util.Date;
import java.sql.*;

public class AlbumDTO {
	private String albumID;
	private String albumName;
	private String release;
	private String musicianID;
	public AlbumDTO(String albumID, String albumName, String release,
			String musicianID) {
		super();
		this.albumID = albumID;
		this.albumName = albumName;
		this.release = release;
		this.musicianID = musicianID;
	}
	public String getAlbumID() {
		return albumID;
	}
	public void setAlbumID(String albumID) {
		this.albumID = albumID;
	}
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public String getRelease() {
		return release;
	}
	public void setRelease(String release) {
		this.release = release;
	}
	public String getMusicianID() {
		return musicianID;
	}
	public void setMusicianID(String musicianID) {
		this.musicianID = musicianID;
	}
	@Override
	public String toString() {
		return "albumDTO [albumID=" + albumID + ", albumName=" + albumName
				+ ", release=" + release + ", musicianID=" + musicianID + "]";
	}
	
	
	
}
