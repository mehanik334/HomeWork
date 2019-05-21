package denisenko.hw13.dao;

import denisenko.hw13.model.Good;
import denisenko.hw13.utils.HibernateSessionFactoryUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class GoodDaoHibernateImpl {

    private static final Logger LOGGER = Logger.getLogger(CodeDaoHibernateImpl.class);

    private final Session session = HibernateSessionFactoryUtil
                              .getSessionFactory()
                              .openSession();
    private Transaction tx1 = session.beginTransaction();

    public void addGood(Good good) {
        try (session){
            session.save(good);
            tx1.commit();
            LOGGER.debug("Add good to db");
        }catch (Exception e){
            LOGGER.error("Error to write into db",e);
        }
    }

    public Good getGoodByID(Long id) {
        LOGGER.debug("Get good from db by id = " + id);
        return HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .get(Good.class, id);
    }

    public void updateGood(Long id, double newPrice) {
        try(session) {
            Good good = getGoodByID(id);
            good.setPrice(newPrice);
            session.update(good);
            tx1.commit();
            LOGGER.debug("Updete good " + good);
        }catch (Exception e){
            LOGGER.error("cant update good",e);
        }
    }

    public void deleteGood(Long id) {
        Good good = getGoodByID(id);
        try (session){
            session.delete(good);
            tx1.commit();
            LOGGER.debug("delete good" + good + " from db");
        }catch (Exception e){
            LOGGER.error("cant delete" + good + "from db",e);
        }
    }

    public void deleteAllGoods() {
        HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("DELETE FROM Good")
                .executeUpdate();
        LOGGER.debug("Delete all goods from DB");
    }

    public List<Good> getAllGoods() {
        List<Good> goods = HibernateSessionFactoryUtil
                          .getSessionFactory()
                          .openSession()
                          .createQuery("FROM Good")
                          .list();
        LOGGER.debug("Get all goods from db");
        return goods;
    }
}
