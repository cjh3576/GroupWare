package com.web.group.workmanage;

public interface WorkManageService {
	//하나 전부 가져오기
	WorkManageVO getSelect(WorkManageVO  workManageVO) throws Exception;
	
	//출근시간, 휴가시작, 끝날짜
	int setTime(WorkManageVO workManageVO) throws Exception;
	
	//퇴근시간 업뎃
	int setOutTime(WorkManageVO workManageVO) throws Exception;
}
