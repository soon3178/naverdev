package login;
import java.sql.Date;
import java.util.ArrayList;

/**
 * @author Administrator
 *
 */
public class MemberDTO {
	private String memberid;
	private String pass;
	private String nickname;
	private int point;
	private String email;
	public MemberDTO(){}
	
	
	
	
	public MemberDTO(String memberid, String pass, String nickname, int point,
			String email) {
		super();
		this.memberid = memberid;
		this.pass = pass;
		this.nickname = nickname;
		this.point = point;
		this.email = email;
	}




	public MemberDTO(String memberid, String pass, String nickname,
			 String email) 
	{
		super();
		this.memberid = memberid;
		this.pass = pass;
		this.nickname = nickname;
		this.email = email;
	}
	
	
	public MemberDTO(String nickname) {
		super();
		this.nickname = nickname;
	}


	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

	

	
	
	

}
