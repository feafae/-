package net.softsociety.exam.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * �쉶�썝 �젙蹂� (�떆�걧由ы떚瑜� �궗�슜�븳 �쉶�썝 �씤利앹뿉 �궗�슜)
 * UserDetails �씤�꽣�럹�씠�뒪瑜� implements
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {

	private String memberid;
	private String memberpw;
	private String membername;	
	private String phone;
	private boolean enabled;			//怨꾩젙�긽�깭. 1:�궗�슜媛��뒫, 0:�궗�슜遺덇��뒫
	private RoleType rolename;			//�궗�슜�옄 援щ텇. 'ROLE_USER':�씪諛섏궗�슜�옄

	
	
}
