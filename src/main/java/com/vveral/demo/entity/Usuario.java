package com.vveral.demo.entity;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name="usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column
	private String username;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private Date created;
	@Column
	private Date modifed;
	@Column
	private Date lastlogin;
	@Column
	private UUID token;
	@Column
    private boolean isactive;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_id")
	private List <Phone> phones;
    
	public Usuario() {
		super();
	}
	
	public Usuario(long id) {
		super();
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getModifed() {
		return modifed;
	}
	public void setModifed(Date modifed) {
		this.modifed = modifed;
	}
	public Date getLastlogin() {
		return lastlogin;
	}
	public void setLastlogin(Date lastlogin) {
		this.lastlogin = lastlogin;
	}
	public UUID getToken() {
		return token;
	}
	public void setToken(UUID token) {
		this.token = token;
	}
	public boolean getIsactive() {
		return isactive;
	}
	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}
	public List<Phone> getPhones() {
		return phones;
	}
	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(created, email, id, isactive, lastlogin, modifed, password, token, username);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(created, other.created) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && isactive == other.isactive
				&& Objects.equals(lastlogin, other.lastlogin) && Objects.equals(modifed, other.modifed)
				&& Objects.equals(password, other.password) && Objects.equals(token, other.token)
				&& Objects.equals(username, other.username);
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", created=" + created + ", modifed=" + modifed + ", lastlogin=" + lastlogin + ", token=" + token
				+ ", isactive=" + isactive + "]";
	}
	
	
}
