package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DBConnection.DBConnect;
import member.dto.MemberDto;

public class MemberDao {
	
	//맴버 추가하는 메소드.
	public boolean insert(MemberDto dto) {
		Connection conn = null;
		PreparedStatement ps = null;
		int flag = 0;
		try {
			conn = new DBConnect().getConn();
			String sql = "insert into member"
					+ " (num,name,addr)"
					+ " values(member_seq.NEXTVAL, ?, ?)";
			ps = conn.prepareStatement(sql);	//sql를 객체에 저장해놓고
			ps.setString(1, dto.getName());	//data binding.
			ps.setString(2, dto.getAddr());
			flag = ps.executeUpdate();	//sql를 실행 결과 => flag로 판단.
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
				if(ps != null) ps.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(flag > 0) {
			return true;
		}else {
			return false;
		}
	};
	
	//맴버 전원 조회하는 메소드.
	public List<MemberDto> selectAll(){
		List<MemberDto> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = new DBConnect().getConn();
			String sql = "select num,name,addr"
					+ " from member";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				MemberDto dto = new MemberDto();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
				if(ps != null) ps.close();
				if(rs != null) rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	};
	
	//멤버 한명 조회하는 메소드.
	public MemberDto selectOne(String name) {
		MemberDto dto = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = new DBConnect().getConn();
			String sql = "select name, addr"
					+ " where name = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while(rs.next()) {
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
				if(ps != null) ps.close();
				if(rs != null) rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	};
	
	//멤버 삭제하는 메소드.
	public boolean delete(String name) {
		Connection conn = null;
		PreparedStatement ps = null;
		int flag = 0;
		try {
			conn = new DBConnect().getConn();
			String sql = "delete from member"
					+ " where name = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			flag = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
				if(ps != null) ps.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(flag > 0) {
			return true;
		}else {
			return false;
		}
	};
	
	//멤버 정보 수정하는 메소드.
	public boolean update(String name, String newAddr) {
		Connection conn = null;
		PreparedStatement ps = null;
		int flag = 0;
		try {
			conn = new DBConnect().getConn();
			String sql = "update member"
					+ " set addr = ?"
					+ " where name = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, newAddr);
			ps.setString(2, name);
			flag = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
				if(ps != null) ps.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(flag >0) {
			return true;
		}else {
			return false;
		}
	};
}
