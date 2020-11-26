package com.issambenmessaoud.gamma.models;

import java.util.Set;
import java.util.HashSet;

import javax.persistence.*;
@Entity
@Table(name= "users",
		uniqueConstraints = {
				@UniqueConstraint(columnNames= "username"),
				@UniqueConstraint(columnNames = "email"),
		}
		)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	private String username;
	private String password;
	private String email ;
	private String nom;
	private String poste ;
	private String tel;
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private EAgentEtat etat;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable( name="user_roles",
				joinColumns=@JoinColumn(name="user_id"),
				inverseJoinColumns=@JoinColumn(name="role_id"))
	private Set<Role> roles = new HashSet<Role>();
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable( name="user_taches",
				joinColumns=@JoinColumn(name="user_id"),
				inverseJoinColumns=@JoinColumn(name="tache_id"))
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
