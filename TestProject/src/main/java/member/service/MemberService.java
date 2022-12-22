package member.service;

import java.util.List;

import member.dao.MemberDao;
import member.dto.MemberDto;

public class MemberService {
	private MemberDao dao;
	
	public MemberService(MemberDao dao) {
		this.dao = dao;
	}
	
	//맴버 추가하는 메소드.
	public boolean insert_member(MemberDto dto) {
		return dao.insert(dto);
	};
	//맴버 전원 조회하는 메소드.
	public List<MemberDto> select_All(){
		return dao.selectAll();
	};
	//맴버 삭제하는 메소드.
	public boolean delete_member(String name) {
		return dao.delete(name);
	};
	//맴버 한명 조회하는 메소드.
	public MemberDto select_one(String name) {
		return dao.selectOne(name);
	};
	//맴버 정보 수정하는 메소드.
	public boolean update_member(String name, String newAddr) {
		return dao.update(name, newAddr);
	};
}
