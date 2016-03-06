package inform;

public class InformDTO {
	private String musicID;
	private String musicianID;
	private String albumID;
	private String genre;
	private String team;
	private String release;
	private String musicName;
	private String musicianName;
	private String albumName;
	private String gender;
	private String musicVideo;
	private String musicRoute;
	private int playtime;
	
	

	
	
	
	public InformDTO(String musicID, String musicianID, String albumID,
			String genre, String team, String release, String musicName,
			String musicianName, String albumName, String gender,
			String musicVideo, String musicRoute, int playtime) {
		super();
		this.musicID = musicID;
		this.musicianID = musicianID;
		this.albumID = albumID;
		this.genre = genre;
		this.team = team;
		this.release = release;
		this.musicName = musicName;
		this.musicianName = musicianName;
		this.albumName = albumName;
		this.gender = gender;
		this.musicVideo = musicVideo;
		this.musicRoute = musicRoute;
		this.playtime = playtime;
	}




	public InformDTO(String musicName, String musicianName,
			String albumName,String release) {
		super();
		this.musicName = musicName;
		this.musicianName = musicianName;
		this.albumName = albumName;
		this.release = release;
	}




	public InformDTO(String albumID, String albumName,String release) {
		super();
		this.albumID = albumID;
		this.albumName = albumName;
		this.release = release;
		
	}


	public String getMusicVideo() {
		return musicVideo;
	}




	public void setMusicVideo(String musicVideo) {
		this.musicVideo = musicVideo;
	}




	public String getMusicRoute() {
		return musicRoute;
	}




	public void setMusicRoute(String musicRoute) {
		this.musicRoute = musicRoute;
	}




	public String getMusicName() {
		return musicName;
	}


	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}


	public String getMusicianName() {
		return musicianName;
	}


	public void setMusicianName(String musicianName) {
		this.musicianName = musicianName;
	}


	public String getAlbumName() {
		return albumName;
	}


	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}


	public String getMusicID() {
		return musicID;
	}


	public void setMusicID(String musicID) {
		this.musicID = musicID;
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


	public String getTeam() {
		return team;
	}


	public void setTeam(String team) {
		this.team = team;
	}


	public String getRelease() {
		return release;
	}


	public void setRelease(String release) {
		this.release = release;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getPlaytime() {
		return playtime;
	}


	public void setPlaytime(int playtime) {
		this.playtime = playtime;
	}


	@Override
	public String toString() {
		return "InformDTO [musicID=" + musicID + ", musicianID=" + musicianID
				+ ", albumID=" + albumID + ", genre="
				+ genre + ", team=" + team + ", release=" + release
				+ ", musicName=" + musicName + ", musicianName=" + musicianName
				+ ", albumName=" + albumName + ", playtime=" + playtime + "]";
	}
	
	
	
}
