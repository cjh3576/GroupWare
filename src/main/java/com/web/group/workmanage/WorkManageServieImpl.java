package com.web.group.workmanage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkManageServieImpl implements WorkManageService {
	
	@Autowired
	WorkManageDAO workManageDAO;
	
	@Override
	public WorkManageVO getSelect(WorkManageVO workManageVO) throws Exception {
		return workManageDAO.getSelect(workManageVO);
	}

	@Override
	public int setTime(WorkManageVO workManageVO) throws Exception {
		return workManageDAO.setTime(workManageVO);
	}

	@Override
	public int setOutTime(WorkManageVO workManageVO) throws Exception {
		return workManageDAO.setOutTime(workManageVO);
	}

}
