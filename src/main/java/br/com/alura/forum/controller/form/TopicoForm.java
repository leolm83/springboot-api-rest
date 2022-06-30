package br.com.alura.forum.controller.form;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import br.com.alura.forum.controller.repository.CursoRepository;
import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;

public class TopicoForm {
	@NotBlank(message="O titulo não pode ser vazio!!!")
	@Length(min=5,message="O titulo deve conter 5 ou mais caracteres!!!") 
	private String titulo;
	@NotBlank(message="A mensagem não pode ser vazio!!!")
	@Length(min=5,message="A mensagem deve conter 5 ou mais caracteres!!!") 
	private String mensagem;
	@NotBlank(message="O curso não pode ser vazio!!!")
	@Length(min=5,message="O curso deve conter 5 ou mais caracteres!!!") 
	private String nomeCurso;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	public Topico converter(CursoRepository cursoRepository) {
		Curso curso = cursoRepository.findByNome(this.nomeCurso);
		return new Topico(this.titulo,this.mensagem,curso);
	}
}
