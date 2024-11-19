package jspMVCMisoShopping.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jspMVCMisoShopping.model.dto.MemberDTO;

public class MemberDAO extends DataBaseInfo {
	
	public void memberPwUpdate(String userPw, String userId) {
		con = getConnection();
		sql = " update members "
				+ "set member_pw = ? "
				+ "where member_id = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,userPw);
			pstmt.setString(2, userId);
			int i = pstmt.executeUpdate();
			System.out.println("비밀번호가 변경되었습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	public String memberNumSelect(String memberId) {
		String memberNum = null;
		con = getConnection();
		sql = " select member_num from members "
				+ " where member_id = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  memberId);
			rs = pstmt.executeQuery();
			rs.next();
			memberNum = rs.getString(1);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return memberNum;
	}
   
   public void memberInsert(MemberDTO dto) {
      con = getConnection();
      sql = " insert into members (member_num, member_name, member_id, member_pw, member_addr ";
      sql += "                , member_addr_detail, member_post, member_regist, gender ";
      sql += "                , member_phone1, member_phone2, member_email, member_birth ";
      sql += "                , member_point) ";
      sql += " values(?, ?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?, ?, ?, ?) ";
      try {
         pstmt = con.prepareStatement(sql);
         pstmt.setString(1, dto.getMemberNum());
         pstmt.setString(2, dto.getMemberName());
         pstmt.setString(3, dto.getMemberId());
         pstmt.setString(4, dto.getMemberPw());
         pstmt.setString(5, dto.getMemberAddr());
         pstmt.setString(6, dto.getMemberAddrDetail());
         pstmt.setString(7, dto.getMemberpost());
         pstmt.setString(8, dto.getGender());
         pstmt.setString(9, dto.getMemberPhone1());
         pstmt.setString(10, dto.getMemberPhone2());
         pstmt.setString(11, dto.getMemberEmail());
         pstmt.setDate(12, new Date(dto.getMemberBirth().getTime()));
         pstmt.setInt(13, 0);
         int i = pstmt.executeUpdate();
         System.out.println(i + "개 행이 삽입되었습니다.");
      } catch (Exception e) {
         e.printStackTrace();
      }finally {
         close();
      }
   }
   
   public List<MemberDTO> memberSelectAll() {
      con = getConnection();
      sql = " select member_num, member_name, member_id, member_pw, member_addr ";
      sql += "                , member_addr_detail, member_post, member_regist, gender ";
      sql += "                , member_phone1, member_phone2, member_email, member_birth ";
      sql += "                , member_point, member_email_conf ";
      sql += " from members ";
      List<MemberDTO> list = new ArrayList<MemberDTO>();
      try {
         pstmt = con.prepareStatement(sql);
         rs = pstmt.executeQuery();
         while(rs.next()) {
            MemberDTO dto = new MemberDTO();
            dto.setMemberAddr(rs.getString("member_addr"));
            dto.setGender(rs.getString("gender"));
            dto.setMemberAddrDetail(rs.getString("member_addr_detail"));
            dto.setMemberBirth(rs.getDate("member_birth"));
            dto.setMemberEmail(rs.getString("member_email"));
            dto.setMemberId(rs.getString("member_id"));
            dto.setMemberName(rs.getString("member_name"));
            dto.setMemberNum(rs.getString("member_num"));
            dto.setMemberPhone1(rs.getString("member_phone1"));
            dto.setMemberPhone2(rs.getString("member_phone2"));
            dto.setMemberpost(rs.getString("member_post"));
            dto.setMemberPw(rs.getString("member_pw"));
            dto.setMemberRegist(rs.getDate("member_regist"));
            list.add(dto);
         }
      } catch (Exception e) {
         e.printStackTrace();
      }finally {
         close();
      }
      return list;
   }
   public String memberAutoNum() {
		con = getConnection();
		sql = " select concat('mem_', nvl(substr(max(member_num),5),100000)+1) from members"; // mem_100001
		String memberNum = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			memberNum = rs.getString(1);
			System.out.println("회원번호 : " + memberNum);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {close();}
		return memberNum;
	}
   
   public MemberDTO memberSelectOne(String memberNum) {
	   MemberDTO dto = null;
	   con = getConnection();
	      sql = " select member_num, member_name, member_id, member_pw, member_addr ";
	      sql += "                , member_addr_detail, member_post, member_regist, gender ";
	      sql += "                , member_phone1, member_phone2, member_email, member_birth ";
	      sql += "                , member_point, member_email_conf ";
	      sql += " from members ";
	      sql += "where member_num = ?";
	      try {
	    	 pstmt = con.prepareStatement(sql);
	    	 pstmt.setString(1,memberNum);
	    	 rs = pstmt.executeQuery();
	    	 if(rs.next()) {
	    		 dto = new MemberDTO();
	    		 dto.setMemberAddr(rs.getString("member_addr"));
	    		 dto.setGender(rs.getString("gender"));
	             dto.setMemberAddrDetail(rs.getString("member_addr_detail"));
	             dto.setMemberBirth(rs.getDate("member_birth"));
	             dto.setMemberEmail(rs.getString("member_email"));
	             dto.setMemberId(rs.getString("member_id"));
	             dto.setMemberName(rs.getString("member_name"));
	             dto.setMemberNum(rs.getString("member_num"));
	             dto.setMemberPhone1(rs.getString("member_phone1"));
	             dto.setMemberPhone2(rs.getString("member_phone2"));
	             dto.setMemberpost(rs.getString("member_post"));
	             dto.setMemberPw(rs.getString("member_pw"));
	             dto.setMemberBirth(rs.getDate("member_birth"));
	             dto.setMemberRegist(rs.getDate("member_regist"));  
	    	 }
	    	 }catch(Exception e){
	    		 e.printStackTrace();
	    	 }finally {close();}
	      return dto;
   }
   
   public void memberUpdate(MemberDTO dto) {
	   con = getConnection();
	   sql = " set member_name = ?, member_addr = ? , member_addr_detail = ?"
	   		+ ", member_post = ? , gender = ?, member_phone1 = ?"
	   		+ ", member_phone2 = ?, member_email = ?, member_birth = ?"
	   		+ " where member_num=? ";
	   
	   try {
		   pstmt = con.prepareStatement(sql);
		   pstmt.setString(1, dto.getMemberName());
	         pstmt.setString(2, dto.getMemberAddr());
	         pstmt.setString(3, dto.getMemberAddrDetail());
	         pstmt.setString(4, dto.getMemberpost());
	         pstmt.setString(5, dto.getGender());
	         pstmt.setString(6, dto.getMemberPhone1());
	         pstmt.setString(7, dto.getMemberPhone2());
	         pstmt.setString(8, dto.getMemberEmail());
	         pstmt.setDate(9, new Date(dto.getMemberBirth().getTime()));
	         pstmt.setString(10, dto.getMemberNum());
	         int i = pstmt.executeUpdate();
	         System.out.println(i + "개가 수정되었습니다.");
	   }catch(Exception e) {
		   e.printStackTrace();
	   }finally {
		   close();
	   }
   }
   
   public void memberDelete(String memberNum) {
	   con = getConnection();
	   sql = " delete from members "
	   		+ "where member_num = ? ";
	   try {
		pstmt =con.prepareStatement(sql);
		pstmt.setString(1,  memberNum);
		int i = pstmt.executeUpdate();
		System.out.println(i + "개행이(가) 삭제되었습니다. ");
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		close();
	}
   }
  
}
