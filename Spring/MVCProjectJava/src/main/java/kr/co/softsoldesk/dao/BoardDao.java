package kr.co.softsoldesk.dao;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.softsoldesk.beans.ContentBean;
import kr.co.softsoldesk.mapper.BoardMapper;

@Repository
public class BoardDao {
	
	
	
	
	@Autowired
	private BoardMapper boardMapper;
	
	public void addContentInfo(ContentBean writeBoardBean) {
		
		boardMapper.addContentInfo(writeBoardBean);
	
	}
	
	public String getBoardInfoName(int board_info_idx) {
		return boardMapper.getBoardInfoName(board_info_idx);
	}
	
	public List<ContentBean> getContentList(int board_info_idx,RowBounds rowBounds){
		return boardMapper.getContentList(board_info_idx,rowBounds);
	}

	public ContentBean getContentInfo(int content_idx) {
		return boardMapper.getContentInfo(content_idx);
	}
	
	public void updateContentInfo(ContentBean modifyContentBean) {
		boardMapper.updateContentInfo(modifyContentBean);
	}
	
	public void deleteContent(int content_idx) {
		boardMapper.deleteContent(content_idx);
	}
	
	public int getContentCnt(int content_board_idx) {
		return boardMapper.getContentCnt(content_board_idx);
	}
	
	
}

