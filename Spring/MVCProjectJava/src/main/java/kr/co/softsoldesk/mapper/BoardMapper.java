package kr.co.softsoldesk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

import kr.co.softsoldesk.beans.ContentBean;

public interface BoardMapper {
	
	
	
	void addContentInfo(ContentBean writeContentBean);
	

	String getBoardInfoName(int board_info_idx);
	
	List<ContentBean> getContentList(int board_info_idx, RowBounds rowBounds);
	
	ContentBean getContentInfo(int content_idx);
	
	
	void updateContentInfo(ContentBean modifyContentBean);
	
	
	void deleteContent(int content_idx);
	
	
	int getContentCnt(int content_board_idx);
	

}
