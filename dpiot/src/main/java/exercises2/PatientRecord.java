package exercises2;

import java.io.Serializable;

public class PatientRecord implements Serializable {
	  final public String recordId;
	  final public String patientId;
	  final public String testId;

	  public PatientRecord(String recordId, String patientId, String testId) {
		  this.recordId = recordId;
		  this.patientId = patientId;
		  this.testId = testId;
	  }
}