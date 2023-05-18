package sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class ComponenteRowMapper implements RowMapper<Componente>  {
    
    @Override
    public Componente mapRow(ResultSet rs, int rowNum) throws SQLException {
        Componente componente = new Componente();
        componente.setIdComponente(rs.getInt("id_componente"));
        componente.setFkHardware(rs.getInt("fk_hardware"));
        componente.setFkUnidade(rs.getInt("fk_unidade"));
        componente.setFkCliente(rs.getInt("fk_cliente"));
        componente.setFkModeloComponente(rs.getInt("fk_modelo_componente"));
        return componente;
    }
}
