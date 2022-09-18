package jpabook.jpashop;

import jpabook.jpashop.domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class jpaMain {

        public static void main(String[] args) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            try {

            }catch (Exception e)
            {
                tx.rollback();
            }
            finally {
                em.close();
            }

            Member member = new Member();
            member.setId(1L);
            member.setName("HelloA");
            em.persist(member); /// 이렇게 하면 원래 저장이 된다.

            tx.commit();    //트랜잭션

            em.close();
            emf.close();
        }
    }

