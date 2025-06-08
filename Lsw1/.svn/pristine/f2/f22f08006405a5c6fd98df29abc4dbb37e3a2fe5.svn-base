package kr.co.softsoldesk.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.softsoldesk.beans.UserBean;

public interface UserMapper {
	
	
	String isUserIdAvailable(String user_id);
	
	
	void addUserInfo(UserBean joinUserBean);
	
	
	UserBean getLoginUserInfo(UserBean tempLoginUserBean);
	
	
	UserBean getModifyUserInfo(int user_idx);
	
	
	void modifyUserInfo(UserBean modifyUserBean);
	
}
