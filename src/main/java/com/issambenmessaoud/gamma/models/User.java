package com.issambenmessaoud.gamma.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Set;
import java.util.HashSet;

import javax.persistence.*;
@Entity
@Table(name= "users",
		uniqueConstraints = {
				@UniqueConstraint(columnNames= "username"),
		}
		)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	private String username;
	@JsonIgnore // so that avoiding security issues
	private String password;
	private String email ;
	private String nom;
	private String poste ;
	private String tel;
	@Enumerated(EnumType.STRING)
	@Column(length = 20, columnDefinition="VARCHAR(20) default 'LIBRE'")
	private EAgentEtat etat ;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable( name="user_roles",
				joinColumns=@JoinColumn(name="user_id"),
				inverseJoinColumns=@JoinColumn(name="role_id"))
	private Set<Role> roles = new HashSet<Role>();
	/*@OneToMany(fetch = FetchType.LAZY)
	@JoinTable( name="user_taches",
				joinColumns=@JoinColumn(name="user_id"),
				inverseJoinColumns=@JoinColumn(name="tache_id"))*/

	@JsonManagedReference
	@OneToMany(mappedBy = "user", targetEntity = Tache.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Tache> taches = new HashSet<Tache>();
	public Set<Tache> getTaches() {
		return taches;
	}
	public void setTaches(Set<Tache> taches) {
		this.taches = taches;
	}
	public User() {
	}
	public User(String username, String password, String email, String nom, String poste, String tel) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.nom = nom;
		this.poste = poste;
		this.tel = tel;
		this.etat=EAgentEtat.LIBRE;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPoste() {
		return poste;
	}
	public void setPoste(String poste) {
		this.poste = poste;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public EAgentEtat getEtat() {
		return etat;
	}
	public void setEtat(EAgentEtat etat) {
		this.etat = etat;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
	
	

}
