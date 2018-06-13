package br.ufsc.modelo;

import java.util.UUID;

public class Ocorrencia {

	private long chave;
	private String resumo;
	private Funcionario funcionarioResponsavel;
	private EstadoOcorrencia estadoOcorrencia;
	private PrioridadeOcorrencia prioridade;
	private TipoOcorrencia tipoOcorrencia;
	
	public Ocorrencia() {
		
	}
		
	public void setChave(long chave) {
		this.chave = chave;
	}
	
	public long getChave() {
		return chave;
	}
	
	public String getResumo() {
		return resumo;
	}
	
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	
	public Funcionario getFuncionarioResponsavel() {
		return funcionarioResponsavel;
	}
	
	public void setFuncionarioResponsavel(Funcionario funcionarioResponsavel) {
		this.funcionarioResponsavel = funcionarioResponsavel;
	}
	
	public EstadoOcorrencia getEstadoOcorrencia() {
		return estadoOcorrencia;
	}
	
	public void setEstadoOcorrencia(EstadoOcorrencia estadoOcorrencia) {
		this.estadoOcorrencia = estadoOcorrencia;
	}
	
	public PrioridadeOcorrencia getPrioridade() {
		return prioridade;
	}
	
	public void setPrioridade(PrioridadeOcorrencia prioridade) {
		this.prioridade = prioridade;
	}
	
	public TipoOcorrencia getTipoOcorrencia() {
		return tipoOcorrencia;
	}
	
	public void setTipoOcorrencia(TipoOcorrencia tipoOcorrencia) {
		this.tipoOcorrencia = tipoOcorrencia;
	}
	
}
