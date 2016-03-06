package musician;

public class MusicianDTO {
	private String musicianID;
	private String musicianName;
	private String gender;
	private String team;
	public MusicianDTO(String musicianID, String musicianName, String gender,
			String team) {
		super();
		this.musicianID = musicianID;
		this.musicianName = musicianName;
		this.gender = gender;
		this.team = team;
	}
	public String getMusicianID() {
		return musicianID;
	}
	public void setMusicianID(String musicianID) {
		this.musicianID = musicianID;
	}
	public String getMusicianName() {
		return musicianName;
	}
	public void setMsuicianName(String musicianName) {
		this.musicianName = musicianName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	@Override
	public String toString() {
		return "MusicianDTO [musicianID=" + musicianID + ", musicianName="
				+ musicianName + ", gender=" + gender + ", team=" + team + "]";
	}
	
	
	
}
