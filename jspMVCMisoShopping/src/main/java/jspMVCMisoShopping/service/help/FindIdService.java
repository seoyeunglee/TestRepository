package jspMVCMisoShopping.service.help;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.FindDAO;

public class FindIdService {
	public void execute(HttpServletRequest request) {
		String userName = request.getParameter("userName");
		String userEmail = request.getParameter("userEmail");
		FindDAO dao = new FindDAO();
		String userId = dao.findId(userName, userEmail);
		request.setAttribute("userId", userId);
	}
}
