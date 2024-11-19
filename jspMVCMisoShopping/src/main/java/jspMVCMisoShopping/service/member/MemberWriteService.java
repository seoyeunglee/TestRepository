package jspMVCMisoShopping.service.member;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.MemberDAO;
import jspMVCMisoShopping.model.dto.MemberDTO;

public class MemberWriteService {
   public void execute(HttpServletRequest request) {
      try {
         request.setCharacterEncoding("utf-8");
      } catch (Exception e) {
         e.printStackTrace();
      }
      
      MemberDTO dto = new MemberDTO();
      dto.setGender(request.getParameter("gender"));
      dto.setMemberAddr(request.getParameter("memberAddr"));
      dto.setMemberAddrDetail(request.getParameter("memberAddrDetail"));
      dto.setMemberEmail(request.getParameter("memberEmail"));
      dto.setMemberId(request.getParameter("memberId"));
      dto.setMemberName(request.getParameter("memberName"));
      dto.setMemberNum(request.getParameter("memberNum"));
      dto.setMemberPhone1(request.getParameter("memberPhone1"));
      dto.setMemberPhone2(request.getParameter("memberPhone2"));
      dto.setMemberpost(request.getParameter("memberpost"));
      dto.setMemberPw(request.getParameter("memberPw"));
      
      String birth = request.getParameter("memberBirth"); // yyyy-mm-dd
      //자바에서 문자열을 날짜로 형변환
      Date date = null;
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
      try {
         date = sdf.parse(birth);
      } catch (Exception e) {
         e.printStackTrace();
      }
      dto.setMemberBirth(date);
      
      MemberDAO dao = new MemberDAO();
      dao.memberInsert(dto);
   }
}
