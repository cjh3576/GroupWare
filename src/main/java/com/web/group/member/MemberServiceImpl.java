package com.web.group.member;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.web.group.memberImage.MemberImageDAO;
import com.web.group.memberImage.MemberImageVO;
import com.web.group.util.FileSaver;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	MemberDAO memberDAO;
	@Autowired
	MemberImageDAO memberImageDAO;
	@Autowired
	private FileSaver fileSaver;
	
	@Override
	public List<MemberVO> selectListMember() throws Exception {
		return memberDAO.selectListMember();
	}


	@Override
	public MemberVO login(MemberVO memberVO) throws Exception {
		return memberDAO.login(memberVO);
	}

	//로그인
	@Override
	public MemberVO getMember(MemberVO memberVO) {
		return memberDAO.getMember(memberVO);
	}

	//mypage
	@Override
	public MemberVO getSelect(String id) throws Exception {
		return memberDAO.getSelect(id);
	}

	//회원가입
	@Override
	@Transactional
	public int setWrite(MemberVO memberVO,HttpSession session, MultipartFile multipartFile) throws Exception {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		memberVO.setPw(passwordEncoder.encode(memberVO.getPw()));
		
		MemberImageVO memberImageVO = new MemberImageVO();
		String realPath = session.getServletContext().getRealPath("/resources/file");
		
		int result = memberDAO.setWrite(memberVO);
		if(result < 1) {
			throw new Exception();
		}
		try {
			memberImageVO.setMid(memberVO.getId());
			memberImageVO.setFname(fileSaver.saveFile(realPath, multipartFile));
			memberImageVO.setOname(multipartFile.getOriginalFilename());
			result = memberImageDAO.setWrite(memberImageVO);
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(result < 1) {
			throw new Exception();
		}
		
		return result;
	}
	//

	@Override
	public int setUpdate(MemberVO memberVO) throws Exception {
		return memberDAO.setUpdate(memberVO);
	}


	@Override
	public int setDelete(String id) throws Exception {
		return memberDAO.setDelete(id);
	}
	
	
	
}
