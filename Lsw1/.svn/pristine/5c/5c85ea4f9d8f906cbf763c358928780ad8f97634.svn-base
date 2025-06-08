package kr.co.softsoldesk.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kr.co.softsoldesk.beans.UserBean;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		return UserBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserBean userBean = (UserBean) target;
		

 	
		String beanName = errors.getObjectName();
	//	System.out.println(beanName);	//tempLoginUserBean
	
		
		
	//회원가입시 또는 정보수정시
	if(beanName.equals("joinUserBean") || beanName.equals("modifyUserBean")) {
		
		//비밀번호 일치 여부
		if(userBean.getUser_pw().equals(userBean.getUser_pw2()) == false) {
			
			errors.rejectValue("user_pw", "NotEquals");
			errors.rejectValue("user_pw2", "NotEquals");
		}
	}//joinUserBean 이랑 modifyUserBean
	
	
	
	//회원가입 하는 bean 일때만
	if(beanName.equals("joinUserBean")){
		//아이디 중복 검사
		if(userBean.isUserIdExist() == false) {
			errors.rejectValue("user_id", "DontCheckUserIdExist");
		}
		
	}//joinUserBean
	
	
	
	
	
	
	}
	
	

}
