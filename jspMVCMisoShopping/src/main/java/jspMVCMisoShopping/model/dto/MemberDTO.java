package jspMVCMisoShopping.model.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
   String memberNum;
   String memberName;
   String memberId;
   String memberPw;
   String memberAddr;
   String memberAddrDetail;
   String memberpost;
   String gender;
   String memberPhone1;
   String memberPhone2;
   String memberEmail;
   Date memberBirth;
   
   Date memberRegist;
}
