package jspMVCMisoShopping.model.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jspMVCMisoShopping.model.dto.goodsDTO;

public class goodsDAO extends DataBaseInfo {
	public void visitCount(String goodsNum) {
		con=getConnection();
		sql=" update goods set visit_count = visit_count +1 where goods_num = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, goodsNum);
			pstmt.executeUpdate();
			System.out.println("조회수가 1 증가했습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	public List<goodsDTO> selectAll() {
		List<goodsDTO> list = new ArrayList<goodsDTO>();
		con = getConnection();
		sql = " select GOODS_NUM, GOODS_NAME, GOODS_PRICE, GOODS_CONTENTS, VISIT_COUNT, EMP_NUM ";
		sql += " , GOODS_REGIST, UPDATE_EMP_NUM, GOODS_UPDATE_DATE ";
		sql += " , GOODS_MAIN_IMAGE, GOODS_MAIN_STORE_IMAGE, GOODS_DETAIL_IMAGE, GOODS_DETAIL_STORE_IMAGE ";
		sql += " from goods ";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				goodsDTO dto = new goodsDTO();
				dto.setGoodsNum(rs.getString(1));
				dto.setGoodsName(rs.getString(2));
				dto.setGoodsPrice(rs.getInt(3));
				dto.setGoodsContent(rs.getString(4));
				dto.setVisitCount(5);
				dto.setEmpNum(rs.getString(6));
				dto.setGoodsRegist(rs.getDate(7));
				dto.setUpdateEmpNum(rs.getString(8));
				dto.setGoodsUpdateDate(rs.getDate(9));
				dto.setGoodsMainImage(rs.getString(10));
				dto.setGoodsMainStoreImage(rs.getString(11));
				dto.setGoodsDetailImage(rs.getString(12));
				dto.setGoodsDetailStoreImage(rs.getString(13));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	public String goodsAutoNum() {
		con = getConnection();
		sql = " select concat('goods_' , nvl(max(substr(goods_num,7)), 100000)+1) as num from goods ";
		String goodsNum = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			goodsNum = rs.getString(1);
			System.out.println("물품번호 : " + goodsNum);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return goodsNum;
	}

	public void goodsInsert(goodsDTO dto) {
		con = getConnection();
		sql = " insert into goods ( GOODS_NUM, GOODS_NAME, GOODS_PRICE, GOODS_CONTENTS, VISIT_COUNT, EMP_NUM, ";
		sql += " GOODS_REGIST, UPDATE_EMP_NUM, GOODS_UPDATE_DATE ";
		sql += ", GOODS_MAIN_IMAGE, GOODS_MAIN_STORE_IMAGE, GOODS_DETAIL_IMAGE, GOODS_DETAIL_STORE_IMAGE )";
		sql += " values (?, ?, ?, ?, 0, ?, sysdate, null, null, ?, ?, ?, ?) ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getGoodsNum());
			pstmt.setString(2, dto.getGoodsName());
			pstmt.setInt(3, dto.getGoodsPrice());
			pstmt.setString(4, dto.getGoodsContent());
			pstmt.setString(5, dto.getEmpNum());
			pstmt.setString(6, dto.getGoodsMainImage());
			pstmt.setString(7, dto.getGoodsMainStoreImage());
			pstmt.setString(8, dto.getGoodsDetailImage());
			pstmt.setString(9, dto.getGoodsDetailStoreImage());
			int i = pstmt.executeUpdate();
			System.out.println(i + " 개가 삽입되었습니다. ");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public goodsDTO goodsSelectOne(String goodsNum) {
		goodsDTO dto = null;
		con = getConnection();
		sql = " select GOODS_NUM, GOODS_NAME, GOODS_PRICE, GOODS_CONTENTS, VISIT_COUNT, EMP_NUM";
		sql += " , GOODS_REGIST, UPDATE_EMP_NUM, GOODS_UPDATE_DATE ";
		sql += " , GOODS_MAIN_IMAGE, GOODS_MAIN_STORE_IMAGE, GOODS_DETAIL_IMAGE, GOODS_DETAIL_STORE_IMAGE ";
		sql += " from goods ";
		sql += " where goods_num = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, goodsNum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new goodsDTO();
				dto.setGoodsNum(rs.getString(1));
				dto.setGoodsName(rs.getString(2));
				dto.setGoodsPrice(rs.getInt(3));
				dto.setGoodsContent(rs.getString(4));
				dto.setVisitCount(rs.getInt(5));
				dto.setEmpNum(rs.getString(6));
				dto.setGoodsRegist(rs.getDate(7));
				dto.setUpdateEmpNum(rs.getString(8));
				dto.setGoodsUpdateDate(rs.getDate(9));
				dto.setGoodsMainImage(rs.getString("GOODS_MAIN_IMAGE"));
				dto.setGoodsMainStoreImage(rs.getString("GOODS_MAIN_STORE_IMAGE"));
				dto.setGoodsDetailImage(rs.getString("GOODS_DETAIL_IMAGE"));
				dto.setGoodsDetailStoreImage(rs.getString("GOODS_DETAIL_STORE_IMAGE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
	}

	public void goodsUpdate(goodsDTO dto) {
		con = getConnection();
		sql = " update goods set goods_name = ?, goods_price = ? ";
		sql += " , goods_contents = ?, update_emp_num =? ";
		sql += " , goods_update_date = sysdate ";
		sql += " where goods_num=?  ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getGoodsName());
			pstmt.setInt(2, dto.getGoodsPrice());
			pstmt.setString(3, dto.getGoodsContent());
			pstmt.setString(4, dto.getUpdateEmpNum());
			pstmt.setString(5, dto.getGoodsNum());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개행이수정되었습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {close();}
		}
	
	
	public int goodsDelete(String goodsNum) {
		con = getConnection();
		sql = " delete from goods where goods_num = ? ";
		int i = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, goodsNum);
			i = pstmt.executeUpdate();
			System.out.println(i+"개행이삭제되었습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {close();}
		return i;
	}


}
