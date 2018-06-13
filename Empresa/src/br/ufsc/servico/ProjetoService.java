package br.ufsc.servico;

import br.ufsc.modelo.Funcionario;
import br.ufsc.modelo.Projeto;

public class ProjetoService {
	
	public Boolean addFuncionarioNoProjeto(Projeto projeto, Funcionario funcionario) {
		if(projeto != null && funcionario != null) {
			projeto.getFuncionarios().add(funcionario);
			return true;
		} else {
			return false;
		}
	}
}
