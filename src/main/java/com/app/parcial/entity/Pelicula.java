package com.app.parcial.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


	@Document(collection = "peliculas")
	public class Pelicula {
		
		@Id
		private String id;
		private String Titulo;
		private String Director;
		private String Genero;
		private String Duración;
		private String Clasificación;
		private String Sinopsis;
		
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getTitulo() {
			return Titulo;
		}
		public void setTitulo(String titulo) {
			Titulo = titulo;
		}
		public String getDirector() {
			return Director;
		}
		public void setDirector(String director) {
			Director = director;
		}
		public String getGenero() {
			return Genero;
		}
		public void setGenero(String genero) {
			Genero = genero;
		}
		public String getDuración() {
			return Duración;
		}
		public void setDuración(String duración) {
			Duración = duración;
		}
		public String getClasificación() {
			return Clasificación;
		}
		public void setClasificación(String clasificación) {
			Clasificación = clasificación;
		}
		public String getSinopsis() {
			return Sinopsis;
		}
		public void setSinopsis(String sinopsis) {
			Sinopsis = sinopsis;
		}
		
		
}
