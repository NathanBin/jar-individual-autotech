package sql;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class MySql {
     private JdbcTemplate connection;
    
    public MySql() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource​.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource​.setUrl("jdbc:mysql://172.20.0.2:3306/AutotechDB?useSSL=false");
        dataSource​.setUsername("AutotechDB");
        dataSource​.setPassword("urubu100");  
        this.connection = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getConnection() {
        return connection;
    }

}
