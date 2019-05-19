package denisenko.hw13.dao;

import denisenko.hw13.model.User;
import denisenko.hw13.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoHibernateImpl {

    private Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
    private Transaction tx1 = session.beginTransaction();

    public void addUser(User user) {
        session.save(user);
        tx1.commit();
        session.close();
    }


    public User getUser(Long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, id);
    }

    public User getUser(User user) {
        Long id = user.getId();
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, id);
    }

    public void updateUser(Long id, String newPassword) {
        User user = getUser(id);
        user.setPassword(newPassword);
        session.update(user);
        tx1.commit();
        session.close();
    }

    public void deleteUser(Long id) {
        User user = getUser(id);
        session.delete(user);
        tx1.commit();
        session.close();
    }

    public void deleteAllUser() {
        HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("DELETE FROM User").executeUpdate();
    }

    public List<User> getAllUsers() {
        List<User> users = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM User").list();
        return users;
    }
}
