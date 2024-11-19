package jspMVCMisoShopping.service.goods;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.goodsDAO;

public class GoodsAutoNumService {
	public void execute(HttpServletRequest request) {
		goodsDAO dao = new goodsDAO();
		String goodsNum = dao.goodsAutoNum();
		request.setAttribute("goodsNum", goodsNum);
	}

}
