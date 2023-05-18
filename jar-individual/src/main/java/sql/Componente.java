package sql;

public class Componente {
    private Integer idComponente;
    private Integer fkHardware;
    private Integer fkUnidade;
    private Integer fkCliente;
    private Integer fkModeloComponente;

    public Componente(Integer idComponente, Integer fkHardware, Integer fkUnidade, Integer fkCliente, Integer fkModeloComponente) {
        this.idComponente = idComponente;
        this.fkHardware = fkHardware;
        this.fkUnidade = fkUnidade;
        this.fkCliente = fkCliente;
        this.fkModeloComponente = fkModeloComponente;
    }

    public Componente() {
    }

    public Integer getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(Integer idComponente) {
        this.idComponente = idComponente;
    }

    public Integer getFkHardware() {
        return fkHardware;
    }

    public void setFkHardware(Integer fkHardware) {
        this.fkHardware = fkHardware;
    }

    public Integer getFkUnidade() {
        return fkUnidade;
    }

    public void setFkUnidade(Integer fkUnidade) {
        this.fkUnidade = fkUnidade;
    }

    public Integer getFkCliente() {
        return fkCliente;
    }

    public void setFkCliente(Integer fkCliente) {
        this.fkCliente = fkCliente;
    }

    public Integer getFkModeloComponente() {
        return fkModeloComponente;
    }

    public void setFkModeloComponente(Integer fkModeloComponente) {
        this.fkModeloComponente = fkModeloComponente;
    }

    @Override
    public String toString() {
        return "Componente{" + "idComponente=" + idComponente + ", fkHardware=" + fkHardware + ", fkUnidade=" + fkUnidade + ", fkCliente=" + fkCliente + ", fkModeloComponente=" + fkModeloComponente + '}';
    }
    
}
