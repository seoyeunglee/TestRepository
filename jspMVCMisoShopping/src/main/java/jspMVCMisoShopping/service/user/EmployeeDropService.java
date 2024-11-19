package jspMVCMisoShopping.service.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jspMVCMisoShopping.model.dao.EmployeeDAO;
import jspMVCMisoShopping.model.dto.AuthInfoDTO;

public class EmployeeDropService {
	public int execute(HttpServletRequest request) {
		String empPw = request.getParameter("empPw");
		HttpSession session = request.getSession();
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		if(!empPw.equals(auth.getUserPw())) {
			request.setAttribute("errPw", "비밀번호가 틀렸습니다.");
			return 0;
		}else {
			EmployeeDAO dao = new EmployeeDAO();
			String empNum = dao.employeeNumSelect(auth.getUserId());
			dao.employeeDelete(empNum);
			return 1;
		}
		
	}

}
