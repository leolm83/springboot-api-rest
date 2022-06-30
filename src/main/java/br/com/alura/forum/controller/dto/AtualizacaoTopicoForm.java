package br.com.alura.forum.controller.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.TopicoRepository;

public class AtualizacaoTopicoForm {
	
		@NotBlank(message="O titulo não pode ser vazio!!!")
		@Length(min=5,message="O titulo deve conter 5 ou mais caracteres!!!") 
		private String titulo;
		@NotBlank(message="A mensagem não pode ser vazio!!!")
		@Length(min=5,message="A mensagem deve conter 5 ou mais caracteres!!!") 
		private String mensagem;
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
		public Topico atualizar(Long id, TopicoRepository topicoRepository) {
			Topico topico = topicoRepository.getReferenceById(id);
			topico.setTitulo(this.titulo);
			topico.setMensagem(this.mensagem);
			return topico;
		}



}
