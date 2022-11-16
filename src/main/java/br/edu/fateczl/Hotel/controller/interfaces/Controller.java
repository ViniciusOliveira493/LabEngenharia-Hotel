package br.edu.fateczl.Hotel.controller.interfaces;

public abstract class Controller<T> implements IController<T>{
	protected String notFound(String nome,String id) {
		return "Não existe "+nome+" com id = "+id;
	}
	
	protected String sucesso(int acao) {
		switch (acao) {
		case 1:
			return "Dados cadastrados com sucesso";
		case 2:
			return "Dados atualizados com sucesso";
		case 3:
			return "Dados apagados com sucesso";
		}
		return "Erro ao buscar mensagem de sucesso";
	}
}
