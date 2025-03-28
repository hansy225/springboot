package exam1;

/*import java.sql.Date;*/
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
/*import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;*/

@Entity
@Table(name="JpaMember1")
public class Member1 {
	@Id
	@GeneratedValue
	private Long id;  // int : 기본값 0
					  // Long : 기본값 null
	private String username;
	
	/*
		@Temporal(@TemporalType.TIMESTAMP) 
		private Date date1;
	 */
	@Column(name="create_date")
	private LocalDate createDate;

	// 빈 생성자는 반드시 있어야 함
	public Member1() { }

	public Member1(String username, LocalDate createDate) {
		this.username = username;
		this.createDate = createDate;
	}
	
}

/*
	@Entity : 해당 클래스가 JPA의 엔티티임을 의미 (테이블 매핑된 JPA)
	@Table(name="이름") : 실제 db에 생성될 테이블 이름, 만약 이 어노테이션이 없으면 클래스의 이름이 테이블 이름이 됨
	@Id : primary key
	@GeneratedValue : 시퀀스를 이용함
	@Column(name="이름") : 실제 테이블의 속성명을 이 이름으로 함
*/
