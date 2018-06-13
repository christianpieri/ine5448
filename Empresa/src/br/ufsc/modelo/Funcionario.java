package br.ufsc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Funcionario {
	
	private String nome;
	private String cpf;
	private List<Ocorrencia> ocorrencias;
	private List<Projeto> projetosTrabalhados;
	
	public Funcionario(String _nome, String _cpf) {
		this.nome = _nome;
		this.cpf = _cpf;
		this.ocorrencias = new ArrayList<>();
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Ocorrencia> getOcorrencias() {
		return ocorrencias;
	}

	public void setOcorrencias(List<Ocorrencia> ocorrencias) {
		this.ocorrencias = ocorrencias;
	}

	public List<Projeto> getProjetosTrabalhados() {
		return projetosTrabalhados;
	}

	public void setProjetosTrabalhados(List<Projeto> projetosTrabalhados) {
		this.projetosTrabalhados = projetosTrabalhados;
	}

}
