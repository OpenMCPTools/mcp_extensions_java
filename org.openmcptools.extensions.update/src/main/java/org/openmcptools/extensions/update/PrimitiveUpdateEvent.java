package org.openmcptools.extensions.update;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PrimitiveUpdateEvent {

	public enum EventType {
		PUT,
		DELETE
	}
	
	@JsonProperty("eventType")
	public EventType eventType;
	
	@JsonProperty("primitiveName")
	public String primitiveName;
	
	@JsonProperty("fieldValueUpdates")
	public List<FieldValueUpdate> fieldValueUpdates;
	
}
