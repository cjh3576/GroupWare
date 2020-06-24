package com.web.group.member;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDAO {
	public List<MemberVO> selectListMember();
}
