package com.crm.model;


import javax.persistence.*;

@Entity
@Table(name = "tutorials")
public class Tutorial {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "title")
	private String title;

	@Column(name = "prix")
	private long prix;


	public Tutorial() {

	}

	public Tutorial(String title, long prix
			) {
		this.title = title;
		this.prix = prix;
	}

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getprix() {
		return prix;
	}

	public void setprix(long prix) {
		this.prix = prix;
	}


	@Override
	public String toString() {
		return "Tutorial [id=" + id + ", title=" + title + ", prix=" + prix + "]";
	}
}