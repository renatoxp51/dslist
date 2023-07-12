package com.devsuperior.dslist.entities;

import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/*
 * 
 * A classe Belonging se trata de um relacionamento entre Game e GameList, ou seja, nela teremos três campos:
 * id_lista -> esse campo faz referência a lista do usuário
 * id_game -> esse campo faz referência ao jogo, ou seja, a lista de id "1" pode ter o game 2, 4, 6...
 * position -> esse campo faz referência a posição que o jogo tem na lista, o jogo de id 2 pode estar em primeiro lugar, o jogo de id 4 em segundo, etc...
 * 
 * Essa classe, diferente das outras, não possui um id único ("id_belonging" por exemplo) o que vai diferenciar cada registro é a combinação do id_game com o id_lista 
 * Por conta disso, irei criar uma classe de "apoio" chamada "BelongingPK" que vai unificar essa combinação em um único ID.
 * 
 * Mas porquê unificar?!
 * Lembra que quando criamos a interface GameRepository utilizamos o nome da classe "Game" e o tipo de dado "Long" para referenciar o "Id".
 * Da mesma forma, quando formos criar o BelongingRepository teremos que referenciar somente um ÚNICO valor, por isso a criação da classe de "apoio"
 * 
 */

@Entity
@Table(name = "tb_belonging")
public class Belonging {

	@EmbeddedId
	private BelongingPK id = new BelongingPK();
	/* o atributo id da classe Belonging é do tipo BelongingPK, por isso no construtor o id está recebendo um setGame e um setList que são setters criados na classe BelongingPK */
	
	private Integer position;
	
	public Belonging() {
		
	}

	public Belonging(Game game, GameList list, Integer position) {
		
		id.setGame(game);
		id.setList(list);
		this.position = position;
	}

	public BelongingPK getId() {
		return id;
	}

	public void setId(BelongingPK id) {
		this.id = id;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Belonging other = (Belonging) obj;
		return Objects.equals(id, other.id);
	}
	
}
