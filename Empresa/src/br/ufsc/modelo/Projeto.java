package br.ufsc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Projeto {
	
	private String nome;
	private List<Funcionario> funcionarios;
	private List<Ocorrencia> ocorrencias;
	
	public Projeto() {
		this.funcionarios = new ArrayList<>();
		this.ocorrencias = new ArrayList<>();
	}
		
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	public List<Ocorrencia> getOcorrencias() {
		return ocorrencias;
	}
	
	public void setOcorrencias(List<Ocorrencia> ocorrencias) {
		this.ocorrencias = ocorrencias;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
