package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class Util {
    private static SessionFactory sessionFactory;
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/mynewtest?useSSL=false&serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "3940";

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties settings = new Properties();

                settings.put("hibernate.connection.driver", driver);
                settings.put("hibernate.connection.url", url);
                settings.put("hibernate.connection.user", user);
                settings.put("hibernate.connection.password", password);
                settings.put("hibernate.connection.dialect", "org.hibernate.dialect.MySQLDialect");
                configuration.setProperties(settings);
                configuration.addAnnotatedClass(User.class);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                System.out.println("Problem");
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}