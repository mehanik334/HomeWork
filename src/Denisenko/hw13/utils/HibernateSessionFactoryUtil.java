package denisenko.hw13.utils;

import denisenko.hw13.model.Code;
import denisenko.hw13.model.Good;
import denisenko.hw13.model.User;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {

    private static SessionFactory sessionFactory;
    private static final Logger LOGGER = Logger.getLogger(HibernateSessionFactoryUtil.class);


    private HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Good.class);
                configuration.addAnnotatedClass(Code.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
                LOGGER.debug("create session factory");
            } catch (Exception e) {
                LOGGER.error("Исключение!" + e);
            }
        }
        return sessionFactory;
    }
}
