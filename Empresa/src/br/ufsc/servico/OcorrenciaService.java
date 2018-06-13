package br.ufsc.servico;

import java.util.UUID;

import br.ufsc.modelo.EstadoOcorrencia;
import br.ufsc.modelo.Funcionario;
import br.ufsc.modelo.Ocorrencia;
import br.ufsc.modelo.PrioridadeOcorrencia;
import br.ufsc.modelo.TipoOcorrencia;

public class OcorrenciaService {

	public long criaNovaOcorrencia(Funcionario funcionario, PrioridadeOcorrencia prioridade, String resumo,
			TipoOcorrencia tipoOcorrencia) {

		Ocorrencia ocorrencia = new Ocorrencia();
		ocorrencia.setChave(UUID.randomUUID().getMostSignificantBits());
		ocorrencia.setEstadoOcorrencia(EstadoOcorrencia.ABERTA);
		ocorrencia.setFuncionarioResponsavel(funcionario);
		ocorrencia.setPrioridade(prioridade);
		ocorrencia.setResumo(resumo);
		ocorrencia.setTipoOcorrencia(tipoOcorrencia);

		return new FuncionarioService().addOcorrenciaToFuncionario(ocorrencia, funcionario);
	}

	public Ocorrencia getOcorrenciaByChave(long idChave, Funcionario funcionario) {
		for (Ocorrencia ocorrencia : funcionario.getOcorrencias()) {
			if (ocorrencia.getChave() == idChave) {
				return ocorrencia;
			}
		}

		return null;
	}

	public boolean alterarEstadoOcorrencia(long idOcorrencia, Funcionario funcionario,
			PrioridadeOcorrencia prioridadeOcorrencia) {

		for (Ocorrencia ocorrencia : funcionario.getOcorrencias()) {
			if (ocorrencia.getChave() == idOcorrencia) {
				ocorrencia.setPrioridade(prioridadeOcorrencia);
				return true;
			}
		}

		return false;
	}

	public long alterarFuncionarioResponsavelOcorrencia(Funcionario funcionarioAntigo, Funcionario funcionarioNovo,
			long idOcorrencia) {

		FuncionarioService funcionarioService = new FuncionarioService();

		if (!funcionarioService.verificaSePossuiMaisDeDezOcorrenciasAbertas(funcionarioNovo)) {
			return -1;
		} else {
			Ocorrencia ocorrenciaByChave = this.getOcorrenciaByChave(idOcorrencia, funcionarioAntigo);
			long addOcorrenciaToFuncionario = funcionarioService.addOcorrenciaToFuncionario(ocorrenciaByChave,
					funcionarioNovo);
			if (addOcorrenciaToFuncionario != -1) {
				funcionarioService.retiraOcorrencia(funcionarioAntigo, idOcorrencia);
				return ocorrenciaByChave.getChave();
			}
		}

		return -1;
	}
}
