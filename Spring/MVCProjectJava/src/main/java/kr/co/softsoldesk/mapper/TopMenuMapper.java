package kr.co.softsoldesk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import kr.co.softsoldesk.beans.BoardInfoBean;

public interface TopMenuMapper {
	

	List<BoardInfoBean> getTopMenuList();
	

}
