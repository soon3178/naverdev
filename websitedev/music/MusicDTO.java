package music;

public class MusicDTO {
	private String musicID;
	private String musicName;
	private String musicianID;
	private String albumID;
	private String genre;
	private int playtime;
	private String musicVideo;
	private String musicRoute;
	
	public MusicDTO(String musicID, String musicName, String musicianID,
			String albumID, String genre, int playtime, String musicvideo,
			String musicRoute) {
		super();
		this.musicID = musicID;
		this.musicName = musicName;
		this.musicianID = musicianID;
		this.albumID = albumID;
		this.genre = genre;
		this.playtime = playtime;
		this.musicVideo = musicvideo;
		this.musicRoute = musicRoute;
	}
	
	public String getMusicID() {
		return musicID;
	}
	public void setMusicID(String musicID) {
		this.musicID = musicID;
	}
	public String getMusicName() {
		return musicName;
	}
	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}
	public String getMusicianID() {
		return musicianID;
	}
	public void setMusicianID(String musicianID) {
		this.musicianID = musicianID;
	}
	public String getAlbumID() {
		return albumID;
	}
	public void setAlbumID(String albumID) {
		this.albumID = albumID;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getPlayTime() {
		return playtime;
	}
	public void setPlayTime(String playTime) {
		this.playtime = playtime;
	}
	public String getMusicvideo() {
		return musicVideo;
	}
	public void setMusicvideo(String musicvideo) {
		this.musicVideo = musicvideo;
	}
	public String getMusicRoute() {
		return musicRoute;
	}
	public void setMusicRoute(String musicRoute) {
		this.musicRoute = musicRoute;
	}
	@Override
	public String toString() {
		return "musicDTO [musicID=" + musicID + ", musicName=" + musicName
				+ ", musicianID=" + musicianID + ", albumID=" + albumID
				+ ", genre=" + genre + ", playtime=" + playtime
				+ ", musicVideo=" + musicVideo + ", musicRoute=" + musicRoute
				+ "]";
	}
	
	
}
