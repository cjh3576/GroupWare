package com.web.group.memberImage;

import org.apache.ibatis.annotations.Mapper;

import com.web.group.member.MemberVO;

@Mapper
public interface MemberImageDAO {
	public Integer setWrite(MemberImageVO memberImageVO) throws Exception;
	
	public MemberImageVO getSelect(MemberVO memberVO) throws Exception;
	
	public Integer setDelete (int fnum) throws Exception;
	
	public Integer setUpdate(MemberImageVO memberImageVO) throws Exception;
	
}
