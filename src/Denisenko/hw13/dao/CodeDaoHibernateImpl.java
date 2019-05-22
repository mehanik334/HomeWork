package denisenko.hw13.dao;

import denisenko.hw13.model.Code;
import denisenko.hw13.utils.HibernateSessionFactoryUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class CodeDaoHibernateImpl {

    private static final Logger LOGGER = Logger.getLogger(CodeDaoHibernateImpl.class);

    public void addGood(Code newCode) {
        try (Session session = HibernateSessionFactoryUtil
                               .getSessionFactory()
                               .openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.save(newCode);
            tx1.commit();
            LOGGER.debug("Add in db code" + newCode.getValue());
        } catch (Exception e) {
            LOGGER.error("Error", e);
        }
    }

    public boolean checkCode(Code code) {
        String value_code = code.getValue();
        Code codeDb = HibernateSessionFactoryUtil
                     .getSessionFactory()
                     .openSession()
                     .get(Code.class, value_code);
        LOGGER.debug("Check code" + value_code);
        return codeDb.equals(code);
    }

}
