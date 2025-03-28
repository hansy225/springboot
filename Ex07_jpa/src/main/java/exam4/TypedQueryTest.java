package exam4;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class TypedQueryTest {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaEx01");
		EntityManager em = emf.createEntityManager();
		
		/*
			TypedQuery 클래스 : sql문을 직접 작성하고자 할 때
			 - 일반 sql 구문이 아닌 영속성의 객체에 넣을 구문 jpa 문법	
			   > select * --> *을 사용할 수 없음. 테이블에 별칭을 넣어서 사용
		*/
		try {
			em.getTransaction().begin();
			
			TypedQuery<Member4> query = em.createQuery("select m from Member4 m order by m.name", Member4.class);

			List<Member4> list = query.getResultList();
			
			if(list.isEmpty()) {
				System.out.println("테이블이 비어있습니다.");
			} else {
				list.forEach(user -> System.out.println(user.getEmail() + "/" + user.getName()));
			}
			
			em.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		em.close();
		emf.close();

	}

}
