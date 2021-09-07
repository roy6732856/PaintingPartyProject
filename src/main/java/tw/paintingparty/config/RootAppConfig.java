package tw.paintingparty.config;

import java.util.Properties;


import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//相當於設定beans.config.xml
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "tw.paintingparty")
@EnableTransactionManagement
public class RootAppConfig {
	@Bean
	public DataSource datasource() throws IllegalArgumentException, NamingException {
		JndiObjectFactoryBean jndiBean = new JndiObjectFactoryBean();
		jndiBean.setJndiName("java:comp/env/connectSqlServerJdbc/OrderService");
		jndiBean.afterPropertiesSet();
		DataSource ds = (DataSource) jndiBean.getObject();
		return ds;
	}
	
	@Bean(destroyMethod = "destroy")
	public LocalSessionFactoryBean sessionFactory() throws RuntimeException, NamingException {
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setDataSource(datasource());
		factory.setPackagesToScan("tw.paintingparty");
		factory.setHibernateProperties(addProperties());
		return factory;
	}

	private Properties addProperties() {
		Properties p1 = new Properties();
		p1.put("hibernate.dialect", org.hibernate.dialect.SQLServerDialect.class);
		p1.put("hibernate.show_sql", Boolean.TRUE);
		p1.put("hibernate.format_sql", Boolean.TRUE);
		p1.put("hibernate.allow_update_outside_transaction", Boolean.TRUE);
		return p1;
	}
	
	@Bean
	public HibernateTransactionManager transactionManager(@Autowired SessionFactory sessionfactory) {
		HibernateTransactionManager txMgr = new HibernateTransactionManager();
		txMgr.setSessionFactory(sessionfactory);
		return txMgr;
	}
}
