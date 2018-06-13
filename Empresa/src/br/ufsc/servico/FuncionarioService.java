package br.ufsc.servico;

import java.util.List;

import br.ufsc.modelo.EstadoOcorrencia;
import br.ufsc.modelo.Funcionario;
import br.ufsc.modelo.Ocorrencia;
import br.ufsc.modelo.Projeto;

public class FuncionarioService {

	public Funcionario getFuncionarioByCpf(String cpf, Projeto projeto) {
		Funcionario funcionarioMatch = null;

		for (Funcionario funcionario : projeto.getFuncionarios()) {
			if (funcionario.getCpf().equals(cpf)) {
				funcionarioMatch = funcionario;
			}
		}

		return funcionarioMatch;

	}

	public boolean verificaSePossuiMaisDeDezOcorrenciasAbertas(Funcionario funcionario) {
		int count = 0;

		for (Ocorrencia ocorrencia : funcionario.getOcorrencias()) {
			if (EstadoOcorrencia.ABERTA == ocorrencia.getEstadoOcorrencia()) {
				count++;
				if (count >= 10) {
					return false;
				}
			}
		}

		return true;
	}

	public long addOcorrenciaToFuncionario(Ocorrencia ocorrenciaNova, Funcionario funcionario) {

		if (this.verificaSePossuiMaisDeDezOcorrenciasAbertas(funcionario)) {
			funcionario.getOcorrencias().add(ocorrenciaNova);
			return ocorrenciaNova.getChave();
		} else {
			return -1;
		}
	}

	public boolean terminarOcorrencia(long idOcorrencia, Funcionario funcionario) {

		for (Ocorrencia ocorrencia : funcionario.getOcorrencias()) {
			if (ocorrencia.getChave() == idOcorrencia) {
				ocorrencia.setEstadoOcorrencia(EstadoOcorrencia.FECHADA);
				return true;
			}
		}

		return false;
	}

	public boolean retiraOcorrencia(Funcionario funcionario, long idOcorrencia) {
		List<Ocorrencia> ocorrencia = funcionario.getOcorrencias();
		for (int i = 0; i < ocorrencia.size(); i++) {
			if (ocorrencia.get(i).getChave() == idOcorrencia) {
				ocorrencia.remove(i);
				return true;
			}
		}

		return false;
	}

}
