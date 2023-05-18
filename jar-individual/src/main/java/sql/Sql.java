package sql;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class Sql {
    
    private JdbcTemplate connection;
    
    public Sql() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource​.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource​.setUrl("jdbc:sqlserver://svr-auto-escola.database.windows.net:1433;databaseName=bd-auto-escola");
        dataSource​.setUsername("AutoEscola");
        dataSource​.setPassword("#Gfgrupo9");  
        this.connection = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getConnection() {
        return connection;
    }

}
