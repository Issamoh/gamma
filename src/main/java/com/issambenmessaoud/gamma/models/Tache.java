package com.issambenmessaoud.gamma.models;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name = "taches")
public class Tache {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;

	private String title;

	private String description;
	private int dureeSuffisante;

	@JsonFormat(pattern="dd-MM-YYYY HH:mm:ss")
	private LocalDateTime DateCreation;

    @JsonFormat(pattern="dd-MM-YYYY HH:mm:ss")
    private LocalDateTime DateDebut;

    @JsonFormat(pattern="dd-MM-YYYY HH:mm:ss")
    private LocalDateTime DateFin;

	@Enumerated(EnumType.STRING)
	@Column(length = 20, columnDefinition="VARCHAR(20) default 'NEW'")
	private ETacheEtat etat;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user ;



	public Tache(String title, String description, int dureeSuffisante, LocalDateTime dateCreation, ETacheEtat etat) {
		this.title = title;
		this.description = description;
		this.dureeSuffisante = dureeSuffisante;
		DateCreation = dateCreation;
		this.etat = etat;
	}

	public Tache() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDureeSuffisante() {
		return dureeSuffisante;
	}

	public void setDureeSuffisante(int dureeSuffisante) {
		this.dureeSuffisante = dureeSuffisante;
	}

	public LocalDateTime getDateCreation() {
		return DateCreation;
	}

	public void setDateCreation(LocalDateTime dateCreation) {
		DateCreation = dateCreation;
	}

	public LocalDateTime getDateDebut() {
		return DateDebut;
	}

	public void setDateDebut(LocalDateTime dateDebut) {
		DateDebut = dateDebut;
	}

	public LocalDateTime getDateFin() {
		return DateFin;
	}

	public void setDateFin(LocalDateTime dateFin) {
		DateFin = dateFin;
	}

	public ETacheEtat getEtat() {
		return etat;
	}

	public void setEtat(ETacheEtat etat) {
		this.etat = etat;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
