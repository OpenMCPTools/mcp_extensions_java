package org.openmcptools.extensions.update;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FieldValueUpdate {

	@JsonProperty("previous")
	public FieldValueUpdate previous;
	
	@JsonProperty("fieldName")
	public String fieldName;
	
	@JsonProperty("fieldValue")
	public Object fieldValue;
	
	@JsonProperty("createRevision")
	long createRevision;
	
	@JsonProperty("modRevision")
	long modRevision;
	
	@JsonProperty("version")
	long version;
	
	@JsonProperty("lease")
	long lease;
	
}
