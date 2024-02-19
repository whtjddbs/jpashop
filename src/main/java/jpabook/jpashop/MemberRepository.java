package jpabook.jpashop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(Member2 member) {
        em.persist(member);
        return member.getId();
    }

    public Member2 find(Long id) {
        return em.find(Member2.class, id);
    }
}
