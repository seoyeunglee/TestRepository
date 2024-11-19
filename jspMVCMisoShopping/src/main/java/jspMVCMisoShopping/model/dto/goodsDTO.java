package jspMVCMisoShopping.model.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class goodsDTO {
	String goodsNum;
	String goodsName;
	int goodsPrice;
	String goodsContent;
	int visitCount;
	String empNum;
	Date goodsRegist;
	String updateEmpNum;
	Date goodsUpdateDate;
	
	String goodsMainImage;
	String goodsMainStoreImage;
	
	String goodsDetailImage;
	String goodsDetailStoreImage;
	
}
