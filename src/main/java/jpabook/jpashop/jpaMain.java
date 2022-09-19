package jpabook.jpashop;

import com.sun.org.apache.xpath.internal.operations.Or;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

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
                Order order = new Order();
                em.persist(order);

                OrderItem orderItem = new OrderItem();
                orderItem.setOrder(order);
                em.persist(orderItem);

                // Order.getMember() -> 이런식으로 불러오는 것이 더욱 객체지향적이다.

                tx.commit();
            }catch (Exception e)
            {
                tx.rollback();
            }
            finally {
                em.close();
            }
            em.close();
            emf.close();
        }
    }

