package member.dto;
/*
 *  	DTO: DB로부터 data를 보내거나 가져올때 data를 저장하는 용도로 사용하는 객체.
 *  			 예를 들어서, 사장님(DB)한테 어떤 업무(data)를 받을 때 구두로 받는 게 아니라, 문서(DTO)로 받는다. 
 *  			 또한 사장님(DB)한테 업무(data)에 대한 처리 결과를 구두로 보고하는 게 아니라, 문서(DTO)로 보고한다. 
 */
public class MemberDto {
	private int num;
	private String name;
	private String addr;
	
	public MemberDto() {}

	public MemberDto(int num, String name, String addr) {
		super();
		this.num = num;
		this.name = name;
		this.addr = addr;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
}
