package sql;

import api.LoocaApi;
import org.springframework.jdbc.core.JdbcTemplate;

public class ConexaoMySql {
    MySql sql = new MySql();
        JdbcTemplate con = sql.getConnection();
        
        public void setRegistro(Double cpu, Double memoria, Double disco){
            con.update("insert into metrica (porcentagemUso, dtHora) values "
                + "(?, current_timestamp),"
                + "(?, current_timestamp),"
                + "(?, current_timestamp);", 
                cpu, memoria, disco);   
        }
}
