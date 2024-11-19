package jspMVCMisoShopping.service.goods;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import jspMVCMisoShopping.model.dao.goodsDAO;
import jspMVCMisoShopping.model.dto.goodsDTO;

public class GoodsDeleteService {
	public void execute(HttpServletRequest request) {
		String goodsNum = request.getParameter("goodsNum");
		goodsDAO dao = new goodsDAO();
		goodsDTO dto = dao.goodsSelectOne(goodsNum);
		
		int i = dao.goodsDelete(goodsNum);
		if(i > 0) {
			String realPath = request.getServletContext().getRealPath("/goods/upload");
			String mainImage = dto.getGoodsMainStoreImage();
			File file = new File(realPath + "/" + mainImage);
			if(file.exists()) file.delete();
			
			String images[] = dto.getGoodsDetailStoreImage().split("`");
			for(String image : images) {
				file = new File(realPath + "/" + mainImage);
				if(file.exists()) file.delete();
			}
		}
	}
}
