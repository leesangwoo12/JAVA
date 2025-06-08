package kr.co.softsoldesk.beans;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


public class UserBean {

	private int user_idx;
	
	@Size(min=2, max=4)
	@Pattern(regexp = "[가-힣]*")   //한글만 가능
	private String user_name;
	
	@Size(min=4,max=20)
	@Pattern(regexp = "[a-zA-Z0-9]*")   //영어 또는 숫자 가능
	private String user_id;
	
	@Size(min=4,max=20)
	@Pattern(regexp = "[a-zA-Z0-9]*")
	private String user_pw;
	
	@Size(min=4,max=20)
	@Pattern(regexp = "[a-zA-Z0-9]*")
	private String user_pw2;
	
	
	//아이디 중복 체크
	private boolean userIdExist;
	//로그인 유무 체크
	private boolean userLogin;
	
	public UserBean() {
		this.userIdExist = false;
		this.userLogin = false;
	}
	
}
