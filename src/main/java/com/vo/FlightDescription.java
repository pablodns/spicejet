package com.vo;

import com.fasterxml.jackson.annotation.JsonProperty;


public class FlightDescription {
	
	private String TEST;
	private String ADULTS;
	private String FROM;
	private String TO;
	private String DEPARTURE_DATE;
	private String ARRIVAL_DATE;
	private String CHILDREN;

	public FlightDescription() {
		
	}
	
	public FlightDescription(String tEST, String aDULTS, String fROM, String tO, String D,
			String A, String cHILDREN) {
		super();
		TEST = tEST;
		ADULTS = aDULTS;
		FROM = fROM;
		TO = tO;
		DEPARTURE_DATE = D;
		ARRIVAL_DATE = A;
		CHILDREN = cHILDREN;
	}
	
	
	
	public String getTEST() {
		return TEST;
	}
	
	@JsonProperty("test")
	public void setTEST(String tEST) {
		TEST = tEST;
	}
	public String getADULTS() {
		return ADULTS;
	}
	@JsonProperty("adults")
	public void setADULTS(String aDULTS) {
		ADULTS = aDULTS;
	}
	public String getFROM() {
		return FROM;
	}
	@JsonProperty("from")
	public void setFROM(String fROM) {
		FROM = fROM;
	}
	public String getTO() {
		return TO;
	}
	@JsonProperty("to")
	public void setTO(String tO) {
		TO = tO;
	}
	public String getDEPARTURE_DATE() {
		return DEPARTURE_DATE;
	}
	@JsonProperty("departure")
	public void setDEPARTURE_DATE(String D) {
		DEPARTURE_DATE = D;
	}
	public String getARRIVAL_DATE() {
		return ARRIVAL_DATE;
	}
	@JsonProperty("arrival")
	public void setARRIVAL_DATE(String A) {
		ARRIVAL_DATE = A;
	}
	public String getCHILDREN() {
		return CHILDREN;
	}
	@JsonProperty("children")
	public void setCHILDREN(String cHILDREN) {
		CHILDREN = cHILDREN;
	}

	
	@Override
	public String toString() {
		return "FlightDescription [TEST=" + TEST + ", ADULTS=" + ADULTS + ", FROM=" + FROM + ", TO=" + TO
				+ ", DEPARTURE_DATE=" + DEPARTURE_DATE + ", ARRIVAL_DATE=" + ARRIVAL_DATE + ", CHILDREN=" + CHILDREN
				+ "]";
	}
	

}
