package kr.co.softsoldesk.beans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


public class PageBean {
	
	//최소 페이지 번호
	private int min;
	
	//최대 페이지 번호
	private int max;
	
	//이전 버튼 페이지 번호
	private int prevPage;
	
	//다음 버튼 페이지 번호
	private int nextPage;
	
	//전체 페이지 갯수
	private int pageCnt;
	
	//현재 페이지 번호
	private int currentPage;
	
	
	/*
	contentCnt : 전체글 갯수 
	currentPage : 현재 페이지 번호
	contentPageCnt : 페이지 당 글의 갯수
	paginationCnt : 페이지 버튼 갯수
	*/
	public PageBean(int contentCnt, int currentPage, int contentPageCnt, int paginationCnt) {
		      
		      
		      this.currentPage = currentPage;
		      
		      
		      pageCnt = contentCnt / contentPageCnt;
		   
		      if(contentCnt % contentPageCnt > 0) {
		         pageCnt++;
		      }
		      
		      //페이지버튼 1~10 -> [1]
		      //페이지버튼 11~20 -> [11]
		      min = ((currentPage - 1) / contentPageCnt) * contentPageCnt + 1;
		      max = min + paginationCnt - 1; 
		      
		      if(max > pageCnt) {
		         max = pageCnt;
		      }
		      
		      prevPage = min - 1;
		      nextPage = max + 1;

		      
		      if(nextPage > pageCnt) {
		         nextPage = pageCnt;
		      }
		   }

}
