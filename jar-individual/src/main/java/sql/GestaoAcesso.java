package sql;

public class GestaoAcesso {
    private Integer idCliente;
    private Integer idUnidade;
    private String nome;
    private String cnpj;
    private String nomeEmpresa;
    private String email;
    private String senha;
    private Integer nivel;

    public GestaoAcesso(Integer idCliente, Integer idUnidade, String nome, String cnpj, String nomeEmpresa, String email, String senha, Integer nivel) {
        this.idCliente = idCliente;
        this.idUnidade = idUnidade;
        this.nome = nome;
        this.cnpj = cnpj;
        this.nomeEmpresa = nomeEmpresa;
        this.email = email;
        this.senha = senha;
        this.nivel = nivel;
    }

    public GestaoAcesso() {
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(Integer idUnidade) {
        this.idUnidade = idUnidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "GestaoAcesso{" + "idCliente=" + idCliente + ", idUnidade=" + idUnidade + ", nome=" + nome + ", cnpj=" + cnpj + ", nomeEmpresa=" + nomeEmpresa + ", email=" + email + ", senha=" + senha + ", nivel=" + nivel + '}';
    }
    
}
