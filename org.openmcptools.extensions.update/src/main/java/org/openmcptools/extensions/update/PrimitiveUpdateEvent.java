package org.openmcptools.extensions.update;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PrimitiveUpdateEvent {

	@JsonProperty("primitiveName")
	public String primitiveName;
	
	@JsonProperty("fieldValuesUpdated")
	public FieldValueUpdate[] fieldValuesUpdated;
	
}
