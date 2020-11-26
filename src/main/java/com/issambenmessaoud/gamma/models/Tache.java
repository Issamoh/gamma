package com.issambenmessaoud.gamma.models;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
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
    private LocalDateTime DateDebut;
    @JsonFormat(pattern="dd-MM-YYYY HH:mm:ss")
    private LocalDateTime DateFin;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ETacheEtat etat;
}
