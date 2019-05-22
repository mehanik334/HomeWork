package denisenko.hw13.dao;

import denisenko.hw13.model.User;
import denisenko.hw13.utils.HibernateSessionFactoryUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoHibernateImpl {

    private final Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
    private Transaction tx1 = session.beginTransaction();
    private static final Logger LOGGER = Logger.getLogger(CodeDao.class);

    public void addUser(User user) {
        try(session){
            session.save(user);
            tx1.commit();
            LOGGER.debug("Add user to db");
        }catch (Exception e){
            LOGGER.error("cant add user to db",e);
        }
    }

    public User getUser(Long id) {
        LOGGER.debug("Get User from db by id");
        return HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .get(User.class, id);
    }

    public User getUser(User user) {
        Long id = user.getId();
        LOGGER.debug("Get user from db by object");
        return HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .get(User.class, id);
    }

    public void updateUser(Long id, String newPassword) {
        try (session){
            User user = getUser(id);
            user.setPassword(newPassword);
            session.update(user);
            tx1.commit();
            LOGGER.debug("Update user in db");
        }catch (Exception e){
            LOGGER.error("Cant update user",e);
        }
    }

    public void deleteUser(Long id) {
        try (session){
            User user = getUser(id);
            session.delete(user);
            tx1.commit();
            LOGGER.debug("Delete user in db");
        }catch (Exception e){
            LOGGER.error("Cant delete user",e);
        }
    }

    public void deleteAllUser() {
        HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("DELETE FROM User")
                .executeUpdate();
        LOGGER.debug("Delete all users");
    }

    public List<User> getAllUsers() {
        List<User> users = HibernateSessionFactoryUtil
                            .getSessionFactory()
                            .openSession()
                            .createQuery("FROM User").list();
        LOGGER.debug("Get all users from db");
        return users;
    }
}
