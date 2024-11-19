package jspMVCMisoShopping.service.goods;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jspMVCMisoShopping.model.dao.EmployeeDAO;
import jspMVCMisoShopping.model.dao.goodsDAO;
import jspMVCMisoShopping.model.dto.AuthInfoDTO;
import jspMVCMisoShopping.model.dto.goodsDTO;

public class GoodsUpdateService {
	public void execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String goodsNum = request.getParameter("goodsNum");
		String goodsName = request.getParameter("goodsName");
		String goodsPrice = request.getParameter("goodsPrice");
		String goodsContent = request.getParameter("goodsContent");
		
		HttpSession session = request.getSession();
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		EmployeeDAO empDao = new EmployeeDAO();
		String empNum = empDao.employeeNumSelect(auth.getUserId());
		
		goodsDTO dto = new goodsDTO();
		dto.setGoodsNum(goodsNum);
		dto.setGoodsName(goodsName);
		dto.setGoodsPrice(Integer.parseInt(goodsPrice));
		dto.setGoodsContent(goodsContent);
		dto.setUpdateEmpNum(empNum);
		
		goodsDAO dao = new goodsDAO();
		dao.goodsUpdate(dto);
		
		/*
		goodsDTO dto = new goodsDTO();
		dto.setGoodsNum(request.getParameter("goodsNum"));
		dto.setGoodsName(request.getParameter("goodsName"));
		//dto.setGoodsPrice(request.getParameter("goodsPrice"));
		dto.setGoodsContents(request.getParameter("goodsContents"));
		// dto.setVisitCount(request.getParameter("visitCount"));
		dto.setEmpNum(request.getParameter("empNum"));
		//dto.setGoodsRegist(request.getParameter("goodsRegist"));
		String registdate = request.getParameter("goodsRegist");
		dto.setUpdateEmpNum(request.getParameter("updateEmpNum"));
		//dto.setGoodsUpdateDate(request.getParameter("goodsUpdateDate"));
		String updatedate = request.getParameter("goodsUpdate");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Date goodsRegist = null;
		Date goodsUpdate = null;
		try {
			goodsRegist = sdf.parse(registdate);
			goodsUpdate = sdf.parse(updatedate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		dto.setGoodsRegist(goodsRegist);
		dto.setGoodsUpdateDate(goodsUpdate);
		
		goodsDAO dao = new goodsDAO();
		dao.goodsUpdate(request);
		*/
	}

}
