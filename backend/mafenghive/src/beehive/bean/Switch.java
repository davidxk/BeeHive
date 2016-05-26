package beehive.bean;

import java.io.Serializable;

public class Switch implements Serializable {
	// Member variable
	public int id;
	public int status;
	public int turnon;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getTurnon() {
		return turnon;
	}
	public void setTurnon(int turnon) {
		this.turnon = turnon;
	}
	

	
	


}
