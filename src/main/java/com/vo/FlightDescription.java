package com.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(ignoreUnknown = true)

public class FlightDescription {
	
	private String test;
	private String adults;
	private String from;
	private String to;
	private String departure;
	private String arrival;
	private String children;
	
	
	public FlightDescription() {
		
	}
	
	public FlightDescription(String tEST, String aDULTS, String fROM, String tO, String dEPARTURE_DATE,
			String aRIVAL_DATE, String cHILDREN) {
		super();
		test = tEST;
		adults = aDULTS;
		from = fROM;
		to = tO;
		departure = dEPARTURE_DATE;
		arrival = aRIVAL_DATE;
		children = cHILDREN;
	}
	
	
	
	public String getTEST() {
		return test;
	}
	public void setTEST(String tEST) {
		test = tEST;
	}
	public String getADULTS() {
		return adults;
	}
	public void setADULTS(String aDULTS) {
		adults = aDULTS;
	}
	public String getFROM() {
		return from;
	}
	public void setFROM(String fROM) {
		from = fROM;
	}
	public String getTO() {
		return to;
	}
	public void setTO(String tO) {
		to = tO;
	}
	public String getDEPARTURE_DATE() {
		return departure;
	}
	public void setDEPARTURE_DATE(String dEPARTURE_DATE) {
		departure = dEPARTURE_DATE;
	}
	public String getARIVAL_DATE() {
		return arrival;
	}
	public void setARIVAL_DATE(String aRIVAL_DATE) {
		arrival = aRIVAL_DATE;
	}
	public String getCHILDREN() {
		return children;
	}
	public void setCHILDREN(String cHILDREN) {
		children = cHILDREN;
	}

	
	@Override
	public String toString() {
		return "FlightDescription [TEST=" + test + ", ADULTS=" + adults + ", FROM=" + from + ", TO=" + to
				+ ", DEPARTURE_DATE=" + departure + ", ARIVAL_DATE=" + arrival + ", CHILDREN=" + children
				+ "]";
	}
	

}
