package hiber.dao;

import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Level;

import static com.mysql.cj.conf.PropertyKey.logger;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public User userByCar(String model, int series) {
      Session session = sessionFactory.getCurrentSession();
      String hql = "from User user where user.car.model = :model and user.car.series = :series";
      Query<User> query = session.createQuery(hql, User.class);
      query.setParameter("model", model);
      query.setParameter("series", series);
      return query.setMaxResults(1).getSingleResult();
   }



}
