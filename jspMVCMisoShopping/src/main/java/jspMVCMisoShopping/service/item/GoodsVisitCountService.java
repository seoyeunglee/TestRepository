package jspMVCMisoShopping.service.item;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.goodsDAO;

public class GoodsVisitCountService {
	public void execute(HttpServletRequest request) {
		String goodsNum = request.getParameter("goodsNum");
		goodsDAO dao = new goodsDAO();
		dao.visitCount(goodsNum);
	}

}
