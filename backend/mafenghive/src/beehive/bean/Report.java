package beehive.bean;

import java.util.Date;

public class Report {
	// Member variables
	public int phone;
	public Date timestamp;
	public float co;
	public float temperature;
	public float humidity;
	public float noise;
	public float ultraviolet;
	
	// Constructors
	public Report() {
		super();
	}
	public Report(int phone, Date timestamp, float co, float temperature,
			float humidity, float noise, float ultraviolet) {
		super();
		this.phone = phone;
		this.timestamp = timestamp;
		this.co = co;
		this.temperature = temperature;
		this.humidity = humidity;
		this.noise = noise;
		this.ultraviolet = ultraviolet;
	}
	
	// Getter and Setters
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public float getCo() {
		return co;
	}
	public void setCo(float co) {
		this.co = co;
	}
	public float getTemperature() {
		return temperature;
	}
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}
	public float getHumidity() {
		return humidity;
	}
	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}
	public float getNoise() {
		return noise;
	}
	public void setNoise(float noise) {
		this.noise = noise;
	}
	public float getUltraviolet() {
		return ultraviolet;
	}
	public void setUltraviolet(float ultraviolet) {
		this.ultraviolet = ultraviolet;
	}
	@Override
    public String toString() {
        return "Report [phone=" + phone + ", timestamp=" + timestamp + "]";
    }
}
