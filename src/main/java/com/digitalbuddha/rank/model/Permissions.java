
package com.digitalbuddha.rank.model;

public class Permissions{
   	private boolean admin;
   	private boolean pull;
   	private boolean push;

 	public boolean getAdmin(){
		return this.admin;
	}
	public void setAdmin(boolean admin){
		this.admin = admin;
	}
 	public boolean getPull(){
		return this.pull;
	}
	public void setPull(boolean pull){
		this.pull = pull;
	}
 	public boolean getPush(){
		return this.push;
	}
	public void setPush(boolean push){
		this.push = push;
	}
}
