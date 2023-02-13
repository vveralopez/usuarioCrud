package com.vveral.demo.dto;

import java.util.Date;
import java.util.UUID;

public class UsuarioRegistrado {
   private String username;
   private long id;
   private Date created;
   private Date modified;
   private Date lastlogin;
   private UUID token;
   private boolean isactive;
   
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public Date getCreated() {
	return created;
}
public void setCreated(Date created) {
	this.created = created;
}
public Date getModified() {
	return modified;
}
public void setModified(Date modifed) {
	this.modified = modifed;
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
public boolean isIsactive() {
	return isactive;
}
public void setIsactive(boolean isactive) {
	this.isactive = isactive;
}

   
}
