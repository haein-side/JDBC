package com.greedy.member.model.dao;

import static com.greedy.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.greedy.member.model.dto.MemberDTO;

public class MemberDAO {
	
	private Properties prop = new Properties();
	
	public MemberDAO() {
		try {
			prop.loadFromXML(new FileInputStream("mapper/member-query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public int registNewMember(Connection con, MemberDTO member) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("registNewMember");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPwd());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getGender());
			pstmt.setString(5, member.getEmail());
			pstmt.setString(6, member.getPhone());
			pstmt.setString(7, member.getAddress());
			pstmt.setInt(8, member.getAge());
			// PrepareStatement는 쿼리문 실행 저장 공간이므로 
			// 이미 쿼리문에서 값을 받고 있는 MEMBER_NO, ENROLL_DATE는 값을 넣어줄 필요가 없음
		
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}


	public List<MemberDTO> selectAllMembers(Connection con) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		List<MemberDTO> list = new ArrayList<>();
		// list에 MemberDTO의 값을 받아서 한 행 씩 넣어줄 것임(제너릭)
		
		String query = prop.getProperty("selectAllMembers");
		
		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				MemberDTO member = new MemberDTO();
				// rset은 sql에서 작동하는 쿼리문이라고 생각하면 됨 
				// * 표시했을 때 sql에서 해당 쿼리문이 실행되므로 기존의 열들을 그대로 넣어주면 작동함
				member.setMemberNo(rset.getInt("MEMBER_NO"));
				member.setMemberId(rset.getString("MEMBER_ID"));
				member.setMemberPwd(rset.getString("MEMBER_PWD"));
				member.setMemberName(rset.getString("MEMBER_NAME"));
				member.setGender(rset.getString("GENDER"));
				member.setEmail(rset.getString("EMAIL"));
				member.setPhone(rset.getString("PHONE"));
				member.setAddress(rset.getString("ADDRESS"));
				member.setAge(rset.getInt("AGE"));
				member.setEnrollDate(rset.getDate("ENROLL_DATE"));
					
				list.add(member);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}



	public String searchMemberById(Connection con, String id) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		MemberDTO member = new MemberDTO();
		// list에 MemberDTO의 값을 받아서 한 행 씩 넣어줄 것임(제너릭)
		
		String query = prop.getProperty("searchMemberById");
		String memberById = "";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				// rset은 sql에서 작동하는 쿼리문이라고 생각하면 됨 
				// * 표시했을 때 sql에서 해당 쿼리문이 실행되므로 기존의 열들을 그대로 넣어주면 작동함
				member.setMemberNo(rset.getInt("MEMBER_NO"));
				member.setMemberId(rset.getString("MEMBER_ID"));
				member.setMemberPwd(rset.getString("MEMBER_PWD"));
				member.setMemberName(rset.getString("MEMBER_NAME"));
				member.setGender(rset.getString("GENDER"));
				member.setEmail(rset.getString("EMAIL"));
				member.setPhone(rset.getString("PHONE"));
				member.setAddress(rset.getString("ADDRESS"));
				member.setAge(rset.getInt("AGE"));
				member.setEnrollDate(rset.getDate("ENROLL_DATE"));
					
				memberById = member.toString();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return memberById;
	}


	public List<MemberDTO> searchMemberByGender(Connection con, String gender) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		List<MemberDTO> list = new ArrayList<>();
		// list에 MemberDTO의 값을 받아서 한 행 씩 넣어줄 것임(제너릭)
		
		String query = prop.getProperty("searchMemberByGender");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, gender);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				MemberDTO member = new MemberDTO();
				// rset은 sql에서 작동하는 쿼리문이라고 생각하면 됨 
				// * 표시했을 때 sql에서 해당 쿼리문이 실행되므로 기존의 열들을 그대로 넣어주면 작동함
				member.setMemberNo(rset.getInt("MEMBER_NO"));
				member.setMemberId(rset.getString("MEMBER_ID"));
				member.setMemberPwd(rset.getString("MEMBER_PWD"));
				member.setMemberName(rset.getString("MEMBER_NAME"));
				member.setGender(rset.getString("GENDER"));
				member.setEmail(rset.getString("EMAIL"));
				member.setPhone(rset.getString("PHONE"));
				member.setAddress(rset.getString("ADDRESS"));
				member.setAge(rset.getInt("AGE"));
				member.setEnrollDate(rset.getDate("ENROLL_DATE"));
					
				list.add(member);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}


	public int modifyPassword(Connection con, String memberId, String password) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("modifyPassword");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, password);
			pstmt.setString(2, memberId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	public int modifyEmail(Connection con, String memberId, String email) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("modifyEmail");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, memberId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	public int modifyPhone(Connection con, String memberId, String phone) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("modifyPhone");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, phone);
			pstmt.setString(2, memberId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	public int modifyAddress(Connection con, String memberId, String address) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("modifyAddress");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, address);
			pstmt.setString(2, memberId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	public int deleteMember(Connection con, String memberId) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteMember");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, memberId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}







}
