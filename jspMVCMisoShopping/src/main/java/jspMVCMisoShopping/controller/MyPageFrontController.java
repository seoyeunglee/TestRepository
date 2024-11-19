package jspMVCMisoShopping.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jspMVCMisoShopping.model.dto.AuthInfoDTO;
import jspMVCMisoShopping.service.employee.EmployeeDetailService;
import jspMVCMisoShopping.service.employee.EmployeeModifyService;
import jspMVCMisoShopping.service.member.MemberDetailService;
import jspMVCMisoShopping.service.member.MemberUpdateService;
import jspMVCMisoShopping.service.user.EmployeeDropService;
import jspMVCMisoShopping.service.user.EmployeePasswordService;
import jspMVCMisoShopping.service.user.MemberDropService;
import jspMVCMisoShopping.service.user.MemberPasswordService;

public class MyPageFrontController extends HttpServlet {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if (command.equals("/memberMyPage.my")) {
			// System.out.println("memberMyPage.my");
			MemberDetailService action = new MemberDetailService();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/myPage/memberMyPage.jsp");
			dispatcher.forward(request, response);
		} else if (command.equals("/memberUpdate.my")) {
			MemberDetailService action = new MemberDetailService();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/myPage/myModify.jsp");
			dispatcher.forward(request, response);
		} else if (command.equals("/memberModify.my")) {
			MemberUpdateService action = new MemberUpdateService();
			int i = action.execute(request);
			if (i == 1)
				response.sendRedirect("memberMyPage.my");
			else {
				MemberDetailService action1 = new MemberDetailService();
				action1.execute(request);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/myPage/myModify.jsp");
				dispatcher.forward(request, response);
			}
		} else if (command.equals("/userPwModify.my")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("myPage/myPwCon.jsp");
			dispatcher.forward(request, response);
		} else if (command.equals("/memberPwModify.my")) {
			HttpSession session = request.getSession();
			AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
			String path = null;
			if (request.getParameter("memberPw").equals(auth.getUserPw())) {
				path = "myPage/myNewPw.jsp";
			} else {
				request.setAttribute("errPw", "비밀번호가 틀렸습니다.");
				path = "myPage/myPwCon.jsp";
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);

		} else if (command.equals("/memberPwPro.my")) {
			MemberPasswordService action = new MemberPasswordService();
			int i = action.execute(request);
			if (i == 1) {
				response.sendRedirect("memberMyPage.my");
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("myPage/myPwCon.jsp");
				dispatcher.forward(request, response);
			}
		}else if(command.equals("/memberDrop.my")) {
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("myPage/memberDrop.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memberDropOk.my")) {
			MemberDropService action = new MemberDropService();
			int i = action.execute(request);
			if(i == 1) {response.sendRedirect("logout.login");
			}else {
				RequestDispatcher dispatcher =
						request.getRequestDispatcher("myPage/memberDrop.jsp");
				dispatcher.forward(request, response);
			}
		}
		/*  브라우저가 종료되기 전까지 사용 
		 *  session.setAttribute(이름, 값);
		 *  session.getAttribute(이름);
		 *  session.invalidate();
		 */
		
		
		if(command.equals("/empMyPage.my")) {
			System.out.println("empMyPage.my");
			EmployeeDetailService action = new EmployeeDetailService();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/myPage/employeeMyPage.jsp");
			dispatcher.forward(request, response);
		}
		else if(command.equals("/empUpdate.my")) {
			System.out.println("empUpdate.my");
			EmployeeDetailService action = new EmployeeDetailService();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/myPage/empmyModify.jsp");
			dispatcher.forward(request, response);
		}
		else if(command.equals("/empModify.my")) {
			System.out.println("empModify.my");
			EmployeeModifyService action = new EmployeeModifyService();
			int i = action.execute(request);
			if(i == 1) response.sendRedirect("empMyPage.my");
			else {
				EmployeeDetailService action1 = new EmployeeDetailService();
				action1.execute(request);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/myPage/empmyModify.jsp");
				dispatcher.forward(request, response);
			}
		}
		else if(command.equals("/empPwModify.my")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("myPage/empPwCon.jsp");
			dispatcher.forward(request, response);
		}
		else if(command.equals("/empMyPwModify.my")) {
			HttpSession session = request.getSession();
			AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
			String path = null;
			if(request.getParameter("empPw").equals(auth.getUserPw())) {
				path = "myPage/empmyNewPw.jsp";
			}else {
				request.setAttribute("errPw", "비밀번호가 틀렸습니다.");
				path = "myPage/empPwCon.jsp";
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}
		else if(command.equals("/employeePwPro.my")) {
			EmployeePasswordService action = new EmployeePasswordService();
			int i = action.execute(request);
			if(i == 1) {
				response.sendRedirect("empMyPage.my");
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("myPage/empPwCon.jsp");
				dispatcher.forward(request, response);
			}
		}
		else if(command.equals("/employeeDrop.my")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("myPage/employeeDrop.jsp");
			dispatcher.forward(request, response);
		}
		else if(command.equals("/empDropOk.my")) {
			EmployeeDropService action = new EmployeeDropService();
			int i = action.execute(request);
			if(i == 1) response.sendRedirect("logout.login");
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("myPage/employeeDrop.jsp");
				dispatcher.forward(request, response);
			}
		}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);
	}
}
