
package com.digitalbuddha.rank.model;

public class Base{
   	private String label;
   	private String ref;
   	private Repo repo;
   	private String sha;
   	private User user;

 	public String getLabel(){
		return this.label;
	}
	public void setLabel(String label){
		this.label = label;
	}
 	public String getRef(){
		return this.ref;
	}
	public void setRef(String ref){
		this.ref = ref;
	}
 	public Repo getRepo(){
		return this.repo;
	}
	public void setRepo(Repo repo){
		this.repo = repo;
	}
 	public String getSha(){
		return this.sha;
	}
	public void setSha(String sha){
		this.sha = sha;
	}
 	public User getUser(){
		return this.user;
	}
	public void setUser(User user){
		this.user = user;
	}
}
