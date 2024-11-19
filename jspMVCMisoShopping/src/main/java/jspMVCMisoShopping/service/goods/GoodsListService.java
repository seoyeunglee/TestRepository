package jspMVCMisoShopping.service.goods;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.goodsDAO;
import jspMVCMisoShopping.model.dto.goodsDTO;

public class GoodsListService {
	public void execute(HttpServletRequest request) {
		goodsDAO dao = new goodsDAO();
		List<goodsDTO> list = dao.selectAll();
		request.setAttribute("dtos", list);
	}
}
