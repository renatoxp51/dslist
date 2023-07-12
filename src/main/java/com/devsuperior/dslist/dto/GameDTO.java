package com.devsuperior.dslist.dto;

import org.springframework.beans.BeanUtils;

import com.devsuperior.dslist.entities.Game;

/*
 * Por que criar um DTO do game ao invés de utilizar diretamente a entidade? 
 * O primeiro ponto é a padronização.
 * Esse projeto está estruturado para retornar ao Controlador somente "DTO" e não entidades. Isso garante qualidade e segurança nos tráfegos da aplicação.
 *  
 * Outro ponto é que, caso exista relacionamentos cíclicos (uma entidade que chama outra, que chama outra...) o DTO é uma maneira de evitar que loopings infitinos aconteçam.
 */
public class GameDTO {

	private Long id;
	private String titulo;
	private Integer ano;
	private String genero;
	private String plataforma;
	private Double score;
	private String imgUrl;
	private String descricao;
	private String descricaoDetalhada;
	
	public GameDTO() {
		
	}
	
	public GameDTO(Game entity) {
		BeanUtils.copyProperties(entity, this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricaoDetalhada() {
		return descricaoDetalhada;
	}

	public void setDescricaoDetalhada(String descricaoDetalhada) {
		this.descricaoDetalhada = descricaoDetalhada;
	}
	
	
	
}
