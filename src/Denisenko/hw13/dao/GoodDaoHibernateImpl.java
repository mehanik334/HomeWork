package denisenko.hw13.dao;

import denisenko.hw13.model.Good;
import denisenko.hw13.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class GoodDaoHibernateImpl {

    private Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
    private Transaction tx1 = session.beginTransaction();

    public void addGood(Good good) {
        session.save(good);
        tx1.commit();
        session.close();
    }

    public Good getGoodByID(Long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Good.class, id);
    }

    public void updateGood(Long id, double newPrice) {
        Good good = getGoodByID(id);
        good.setPrice(newPrice);
        session.update(good);
        tx1.commit();
        session.close();
    }

    public void deleteGood(Long id) {
        Good good = getGoodByID(id);
        session.delete(good);
        tx1.commit();
        session.close();
    }

    public void deleteAllGoods() {
        HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("DELETE FROM Good").executeUpdate();
    }

    public List<Good> getAllGoods() {
        List<Good> goods = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM Good").list();
        return goods;
    }
}
