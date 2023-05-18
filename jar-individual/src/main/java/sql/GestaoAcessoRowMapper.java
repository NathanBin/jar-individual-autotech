package sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class GestaoAcessoRowMapper implements RowMapper<GestaoAcesso>{
    
    @Override
    public GestaoAcesso mapRow(ResultSet rs, int rowNum) throws SQLException {
        GestaoAcesso gestaoAcesso = new GestaoAcesso();
        gestaoAcesso.setIdCliente(rs.getInt("id_cliente"));
        gestaoAcesso.setIdUnidade(rs.getInt("id_unidade"));
        gestaoAcesso.setNome(rs.getString("nome"));
        gestaoAcesso.setCnpj(rs.getString("cnpj"));
        gestaoAcesso.setNomeEmpresa(rs.getString("nome_empresa"));
        gestaoAcesso.setEmail(rs.getString("email"));
        gestaoAcesso.setSenha(rs.getString("senha"));
        gestaoAcesso.setNivel(rs.getInt("nivel"));
        return gestaoAcesso;
    }
}