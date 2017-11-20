package controller;

public class DewPoint {
	
	private final static double a = 17.27;
	private final static double b = 237.7;
	private double dewPointTemp;
	private double alpha, temp, hum;
	
	
	public void dewPointTemp(String temp, String hum) {
		this.temp = Double.parseDouble(temp);
		
		this.hum = Double.parseDouble(hum);
		//System.out.println(this.hum);
		this.hum = this.hum/100;
		//System.out.println(this.hum);
		alpha = ((a*this.temp)/(b+this.temp))+Math.log(this.hum);
		dewPointTemp = (b*alpha)/(a-alpha);
	}

	public double getDewPointTemp() {
		return dewPointTemp;
	}
	
	
}
