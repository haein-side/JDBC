package com.greedy.member.model.service;

import static com.greedy.common.JDBCTemplate.close;
import static com.greedy.common.JDBCTemplate.commit;
import static com.greedy.common.JDBCTemplate.getConnection;
import static com.greedy.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.greedy.member.model.dao.MemberDAO;
import com.greedy.member.model.dto.MemberDTO;

public class MemberService {
	
	private MemberDAO memberDAO = new MemberDAO();
	

	/**
	 * <pre>
	 * 멤버 등록용 메소드
	 * 등록해준 값을 DB에 넣어줘야 하는 것
	 * </pre>
	 */
	public int registNewMember(MemberDTO member) {
		
		Connection con = getConnection();
		
		int result =  memberDAO.registNewMember(con, member);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		return result;
		
	}


	public List<MemberDTO> selectAllMembers() {
		
		Connection con = getConnection();
		
		List<MemberDTO> list = memberDAO.selectAllMembers(con);
		
		close(con);
		
		return list;
		
	}


	public String searchMemberById(String id) {
		
		Connection con = getConnection();
		
		String memberById = memberDAO.searchMemberById(con, id);
		
		close(con);
		
		return memberById;
	}


	public List<MemberDTO> searchMemberByGender(String gender) {
		Connection con = getConnection();
		
		List<MemberDTO> list = memberDAO.searchMemberByGender(con, gender);
		
		close(con);
		
		return list;
	}


	public int modifyPassword(String memberId, String password) {
		Connection con = getConnection();
		
		int result = memberDAO.modifyPassword(con, memberId, password);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		return result;
	}


	public int modifyEmail(String memberId, String email) {
		Connection con = getConnection();
		
		int result = memberDAO.modifyEmail(con, memberId, email);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		return result;
	}


	public int modifyPhone(String memberId, String phone) {
		Connection con = getConnection();
		
		int result = memberDAO.modifyPhone(con, memberId, phone);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		return result;
	}


	public int modifyAddress(String memberId, String address) {
		Connection con = getConnection();
		
		int result = memberDAO.modifyAddress(con, memberId, address);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		return result;
	}


	public int deleteMember(String memberId) {
		Connection con = getConnection();
		
		int result = memberDAO.deleteMember(con, memberId);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		return result;
	}


	
	

	

}
