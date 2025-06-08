package kr.co.softsoldesk.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.softsoldesk.beans.ContentBean;
import kr.co.softsoldesk.beans.UserBean;
import kr.co.softsoldesk.service.BoardService;

public class CheckWriterInterceptor implements HandlerInterceptor{
	
	
	private UserBean loginUserBean;
	private BoardService borderService;
	
	
	public CheckWriterInterceptor(UserBean loginUserBean, BoardService borderService) {
		this.loginUserBean = loginUserBean;
		this.borderService = borderService;
	}


	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String str1 = request.getParameter("content_idx");
		int content_idx =Integer.parseInt(str1);
		
		//현재 게시글 정보
		ContentBean currentContentBean = borderService.getContentInfo(content_idx);
		
		if(currentContentBean.getContent_writer_idx() != loginUserBean.getUser_idx()) {
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath +"/board/not_writer");
			return false;
		}
		
		
		return true;
	}

}
