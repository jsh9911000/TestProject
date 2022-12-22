package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DBConnection.DBConnect;
import member.dto.MemberDto;

public class MemberDao {
	
	/*
	 *	 DAO: DB연동을 통해서 직접적으로 DB에 접근이 가능한 객체. 
	 *			   
	 *	 ● DAO에서 사용하는 객체.
	 *		(1)Connection 객체: DB 연동을 위한 객체. => 미리 만들어 놓은 DBConnect 객체를 통해서 연동한다.
	 *		(2)PreparedStatement 객체: SQL 쿼리를 저장하고 핸들링하고 실행할 수 있는 객체. => setInt( , ) / setString( , ) / executeUpdate() / executeQuery()
	 *		(3)ResultSet 객체: SQL 쿼리 중 select문에서 사용되는 객체. => SQL 실행으로 가져온 data를 저장하는 용도로 사용한다. => next() / getInt() / getString()
	 *		(4)flag 변수: boolean type을 return하는 메소드에서 ResultSet과 같은 역할을 하는 변수. 
	 */
	
	//맴버 추가하는 메소드.
	public boolean insert(MemberDto dto) {		
		Connection conn = null;		//DB연동을 위해 필요한 Connection 객체.
		PreparedStatement ps = null;	//SQL을 저장 및 핸들링할 수 있는 객체.
		int flag = 0;		//boolean type의 return type을 가질 때 사용하는 flag 변수.
		try {
			conn = new DBConnect().getConn();	//DBConnect 객체의 생성으로 DB 연결 -> getConn() 를 이용해서 Connection 객체 return.
			String sql = "insert into member"		//SQL 작성.
					+ " (num,name,addr)"
					+ " values(member_seq.NEXTVAL, ?, ?)";
			ps = conn.prepareStatement(sql);	//PreparedStatement 객체에 SQL 저장. => Connection 객체의 preparedStatement() 를 사용한다.
			ps.setString(1, dto.getName());	//PreparedStatement 객체에 저장된 SQL에 인자값을 Data Binding. => 메소드를 이해해야 한다.
			ps.setString(2, dto.getAddr());	//PreparedStatement 객체에 저장된 SQL에 인자값을 Data Binding. => 메소드를 이해해야 한다.
			flag = ps.executeUpdate();	//PreparedStatement 객체의 executeUpdate() 로 SQL 쿼리 실행. => return type이 int기 때문에 flag에 저장한다.
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {	//finally 에서 준비한 객체들을 if 조건문을 통해서 닫아준다.
				if(conn != null) conn.close();
				if(ps != null) ps.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		//boolean type return이기 때문에 flag 변수의 변화 유무에 따라 true/false를 return할 수 있다.
		if(flag > 0) {
			return true;
		}else {
			return false;
		}
	};
	
	//맴버 전원 조회하는 메소드.
	public List<MemberDto> selectAll(){
		List<MemberDto> list = new ArrayList<>(); //배열로 저장하기 위한 ArrayList 객체 생성. => List<> type 변수와 함께 사용.
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;	//SQL 쿼리 중 select문에 사용되는 객체. DB로부터 가져온 data를 저장하는 용도로 사용한다.
		try {
			conn = new DBConnect().getConn();
			String sql = "select num,name,addr"
					+ " from member";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();	//PreparedStatement 객체를 통해서 SQL를 실행하고, 그 결과를 ResultSet 객체에 저장한다.
			while(rs.next()) {		//while 반복문을 통해서 가져온 data를 하나씩 읽어낸다.
				MemberDto dto = new MemberDto();		//DTO 생성. => SQL를 실행한 결과를 DTO에 저장할 것이다.
				dto.setNum(rs.getInt("num"));	//DTO setter 메소드와 ResultSet getter 메소드를 이용. => 이해해야한다.
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				list.add(dto);	//전역변수로 만들어 놓은 배열에 DTO 저장.
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {	//만들어놓은 객체들 닫기.
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
		MemberDto dto = null;	//DTO를 전역변수로 만들어야 한다. => 이유를 알아야 한다.
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
