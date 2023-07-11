package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.Game;

public class GameMinDTO {

	private Long id;
	private String titulo;
	private Integer ano;
	private String imgUrl;
	private String descricao;
		
	public GameMinDTO() {
		
	}

	public GameMinDTO(Game entity) {
		
		id = entity.getId();
		titulo = entity.getTitulo();
		ano = entity.getAno();
		imgUrl = entity.getImgUrl();
		descricao = entity.getImgUrl();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public Integer getAno() {
		return ano;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
		
}
