package api;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.rede.RedeInterface;
import com.github.britooo.looca.api.group.rede.RedeInterfaceGroup;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.util.Conversor;
import java.util.ArrayList;
import java.util.List;
import util.ConversorBytes;

public class LoocaApi {
    private Looca looca;
    private Memoria memoria;
    private Processador processador;
    private RedeInterfaceGroup grupoDeRede;
    private List<RedeInterface> redeInterfaces;
    private RedeInterface redePrincipal;
    private DiscoGrupo grupoDeDiscos;
    private Sistema sistema;

    public LoocaApi() {
        looca = new Looca();
        memoria = new Memoria();
        processador = looca.getProcessador();
        grupoDeRede = looca.getRede().getGrupoDeInterfaces();
        redeInterfaces = grupoDeRede.getInterfaces();
        redePrincipal = redeInterfaces.get(0);
        grupoDeDiscos = looca.getGrupoDeDiscos();
    }
    
    public String getNumSerie(){
        return processador.getId();
    }
    
    public String getSistemaOperacional(){
        return looca.getSistema().getSistemaOperacional();
    }
    
    public String getSistemaInfo(){
        return looca.getSistema().toString();
    }
    
    public String getModeloCpu(){
        return looca.getProcessador().getNome();
    }
    
    public String getModeloDisco(){
        List<Disco>discos = grupoDeDiscos.getDiscos();
        
        return discos.get(0).getModelo();
    }
    
    public String getModeloMemoria(){
        return "Memória RAM " + Conversor.formatarBytes(looca.getMemoria().getTotal());
    }
    
    public Double getMemoria(){
        Double emUso = memoria.getEmUso().doubleValue();
        Double total = memoria.getTotal().doubleValue();
        
        return emUso/total*100;
    }
    
    public Double getCpu(){
        return processador.getUso();
    }
    
    public Double getDisco(){
        Double porcentagemDisco = 0.0;
        
        List<Volume>volumes = grupoDeDiscos.getVolumes();
        for (Volume volume : volumes){
            Double atual = ((volume.getTotal().doubleValue() - volume.getDisponivel().doubleValue())/ volume.getTotal().doubleValue()) * 100;

            if(atual > porcentagemDisco){
                porcentagemDisco = atual;
            }
        }
        
        return porcentagemDisco;
    }
    
    public Double getCapacidadeCpu(){
        ConversorBytes bytes = new ConversorBytes();
        
        return bytes.formatarBytes(processador.getFrequencia());
    }
    
    public Double getCapacidadeMemoria(){
        ConversorBytes bytes = new ConversorBytes();
        
        return bytes.formatarBytes(memoria.getTotal());
    }
    
    public Double getCapacidadeDisco(){
        ConversorBytes bytes = new ConversorBytes();
        
        return bytes.formatarBytes(grupoDeDiscos.getTamanhoTotal());
    }
    
}
