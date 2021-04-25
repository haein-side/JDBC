package com.greedy.member.controller;

import java.util.List;
import java.util.Map;

import com.greedy.member.model.dto.MemberDTO;
import com.greedy.member.model.service.MemberService;
import com.greedy.member.views.MemberResultView;

public class MemberController {
	
	/* MemberResultView 클래스에 작성한 display 메소드로 출력할 것
	 * display 메소드로 출력할 필요 없는 내용은 간단히 콘솔에 직접 출력
	 * dml 수행 결과는 MemberResultView의 displayDmlResult()를 이용할 것
	 * */
	
	private MemberResultView memberResultView = new MemberResultView();
	private MemberService memberService = new MemberService();

	/* 신규 회원 등록용 메소드 */
	public void registNewMember(Map<String, String> requestMap) {
		
		/* Map으로 전달 된 데이터를 꺼내 MemberDTO에 담아 Service로 전달 */	
		MemberDTO member = new MemberDTO();
		member.setMemberId(requestMap.get("id"));
		member.setMemberPwd(requestMap.get("pwd"));
		member.setMemberName(requestMap.get("name"));
		member.setGender(requestMap.get("gender"));
		member.setEmail(requestMap.get("email"));
		member.setPhone(requestMap.get("phone"));
		member.setAddress(requestMap.get("address"));
		member.setAge(Integer.parseInt(requestMap.get("age")));
		// Age를 string 타입으로 input 받았으므로 int로 형변환
		
		int result = memberService.registNewMember(member);
		// Service로 전달해주는 부분이 어려움
		
		MemberResultView resultView = new MemberResultView();
		
		if(result > 0) {
			resultView.displayDmlResult("insertSuccess");
		} else {
			resultView.displayDmlResult("insertFailed");
		};
	}
	
	/* 모든 회원 정보 조회용 메소드(List로 조회할 것) */
	public void selectAllMembers() {
		
		List<MemberDTO> list = memberService.selectAllMembers();
		
		MemberResultView resultView = new MemberResultView();
		
		resultView.display(list);
		
		// select의 경우 분기처리를 어떻게 해줘야 하는가?
		
	}
	
	/* 아이디를 이용한 회원 정보 검색(MemberDTO로 한 명 회원 정보 조회) */
	public void searchMemberById(String id) {
		
		String memberById = memberService.searchMemberById(id);
		
		System.out.println(memberById);
		
		MemberResultView resultView = new MemberResultView();
		
		// select의 경우 분기 처리를 어떻게 해줘야 하는가?
	}
	
	/* 성별을 이용한 회원 정보 검색 (List로 조회할 것)*/
	public void searchMemberByGender(String gender) {
		
		List<MemberDTO> list = memberService.searchMemberByGender(gender);
		
		MemberResultView resultView = new MemberResultView();
		
		resultView.display(list);
		
	}
	
	/* 입력받은 아이디와 일치하는 회원의 비밀번호 변경 */
	public void modifyPassword(String memberId, String password) {
		
		int result = memberService.modifyPassword(memberId, password);
		
		MemberResultView resultView = new MemberResultView();
		
		if(result > 0) {
			resultView.displayDmlResult("updateSuccess");
		} else {
			resultView.displayDmlResult("updateFailed");
		};
		
	}
	
	/* 입력받은 아이디와 일치하는 회원의 이메일 변경 */
	public void modifyEmail(String memberId, String email) {
		
		int result = memberService.modifyEmail(memberId, email);
		
		MemberResultView resultView = new MemberResultView();
		
		if(result > 0) {
			resultView.displayDmlResult("updateSuccess");
		} else {
			resultView.displayDmlResult("updateFailed");
		};
	}
	
	/* 입력받은 아이디와 일치하는 회원의 전화번호 변경 */
	public void modifyPhone(String memberId, String phone) {
		
		int result = memberService.modifyPhone(memberId, phone);
		
		MemberResultView resultView = new MemberResultView();
		
		if(result > 0) {
			resultView.displayDmlResult("updateSuccess");
		} else {
			resultView.displayDmlResult("updateFailed");
		};
		
	}
	
	/* 입력받은 아이디와 일치하는 회원의 주소 변경 */
	public void modifyAddress(String memberId, String address) {
		int result = memberService.modifyAddress(memberId, address);
		
		MemberResultView resultView = new MemberResultView();
		
		if(result > 0) {
			resultView.displayDmlResult("updateSuccess");
		} else {
			resultView.displayDmlResult("updateFailed");
		};
	}
	
	/* 회원 정보 삭제용 메소드 */
	public void deleteMember(String memberId) {
		int result = memberService.deleteMember(memberId);
		
		MemberResultView resultView = new MemberResultView();
		
		if(result > 0) {
			resultView.displayDmlResult("deleteSuccess");
		} else {
			resultView.displayDmlResult("deleteFailed");
		};
	}

}
