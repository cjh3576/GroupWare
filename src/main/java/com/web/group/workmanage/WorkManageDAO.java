package com.web.group.workmanage;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WorkManageDAO {
	//하나 전부 가져오기
	public WorkManageVO getSelect(WorkManageVO workManageVO);
	
	//출근시간, 휴가시작, 끝날짜
	public int setTime(WorkManageVO workManageVO);
	
	//퇴근시간 업뎃
	public int setOutTime(WorkManageVO workManageVO);
}
