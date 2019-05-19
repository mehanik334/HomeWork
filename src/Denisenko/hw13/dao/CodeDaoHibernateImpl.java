package denisenko.hw13.dao;

import denisenko.hw13.model.Code;
import denisenko.hw13.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class CodeDaoHibernateImpl {

    public void addGood(Code newCode) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(newCode);
        tx1.commit();
        session.close();
    }

    public boolean checkCode(Code code) {
        String value_code = code.getValue();
        Code codeDb = HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Code.class, value_code);
        return codeDb.equals(code);
    }

}
