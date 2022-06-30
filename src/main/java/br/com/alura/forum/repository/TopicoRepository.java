package br.com.alura.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long>{
	//aqui é um atributo da propria entidade
	List<Topico> findByTitulo(String nomeCurso);
	
	
	//aqui é um atributo de um relacionamento
	//caso exista um relacionamento e um atributo de nomes iguais utiliza se o _ para indicar o relacionamento
	List<Topico> findByCurso_Nome(String nomeCurso);
	/*
	 * No caso 
	 * um atributo cursoNome na classe Topico:
	 * List<Topico> findByCursoNome(String nomeCurso);
	 * e um relacionamento entre Topico e Curso buscando pelo nome seria:
	 * List<Topico> findByCurso_Nome(String nomeCurso);
	 */
	/*
	 * query customizada usando jpql
	 * @Query("SELECT t from Topico t WHERE t.curso.nome = :nomeCurso")
	 * List<Topico> ProcurarPorNomeDoCurso(@param("nomeCurso") String nomeCurso);
	 * */
}
