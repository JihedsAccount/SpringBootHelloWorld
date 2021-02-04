package com.javainuse.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

/**
 * https://www.tutorialspoint.com/spring_boot/spring_boot_database_handling.htm
 */
@Configuration
public class DataBaseConfig {

	@Value("${spring.datasource.driverClassName}")
	private String driver;
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String user;
	@Value("${spring.datasource.password}")
	private String password;
	
	@Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        
        return dataSource;
    }
	
//	@Bean(name = "dbEmployeeService")
////	@ConfigurationProperties(prefix = "spring.dbEmployeeService")
////	@Primary
//	public DataSource createEmployeeServiceDataSource() {
//		return DataSourceBuilder.create().build();
//	}

//	@Bean(name = "jdbcEmployeeService")
//	@Autowired
//	public JdbcTemplate createJdbcTemplate_EmployeeService(DataSource employeeServiceDS) {
//		return new JdbcTemplate(employeeServiceDS);
//	}

	
//	@Bean(name = "dbUserService")
//	@ConfigurationProperties(prefix = "spring.dbUserService")
//	public DataSource createUserServiceDataSource() {
//		return DataSourceBuilder.create().build();
//	}
	
//	@Bean(name = "jdbcUserService")
//	@Autowired
//	public JdbcTemplate createJdbcTemplate_UserService(@Qualifier("dbUserService") DataSource userServiceDS) {
//		return new JdbcTemplate(userServiceDS);
//	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setDatabase(Database.MYSQL);
//		jpaVendorAdapter.setGenerateDdl(true);
		return jpaVendorAdapter;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean lemfb = new LocalContainerEntityManagerFactoryBean();
		lemfb.setDataSource(dataSource());
		lemfb.setJpaVendorAdapter(jpaVendorAdapter());
		lemfb.setPackagesToScan("com.javainuse");
		return lemfb;
	}
}