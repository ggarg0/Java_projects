package com.gaurav.cab;

public class CabDetails {

	String CabId;
	String CabType;
	String CabAvailable;
	
	public CabDetails(String cabId, String cabType, String cabAvailable) {
		CabId = cabId;
		CabType = cabType;
		CabAvailable = cabAvailable;
	}
	
	public String getCabId() {
		return CabId;
	}

	public void setCabId(String cabId) {
		CabId = cabId;
	}

	public String getCabType() {
		return CabType;
	}

	public void setCabType(String cabType) {
		CabType = cabType;
	}

	public String getCabAvailable() {
		return CabAvailable;
	}

	public void setCabAvailable(String cabAvailable) {
		CabAvailable = cabAvailable;
	}

	
	
}
