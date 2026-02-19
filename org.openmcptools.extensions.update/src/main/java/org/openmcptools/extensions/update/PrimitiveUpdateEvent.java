package org.openmcptools.extensions.update;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PrimitiveUpdateEvent {

	public enum EventType {
		@JsonProperty("PUT")
		PUT, @JsonProperty("DELETE")
		DELETE
	}

	@JsonProperty("eventType")
	public EventType eventType;

	@JsonProperty("primitiveName")
	public String primitiveName;

	@JsonProperty("fieldValueUpdates")
	public List<FieldValueUpdate> fieldValueUpdates;

	public static PrimitiveUpdateEvent fromMap(Map<String, Object> map) {
		if (map == null) {
			return null;
		}
		PrimitiveUpdateEvent r = new PrimitiveUpdateEvent();
		r.primitiveName = (String) map.get("primitiveName");
		Objects.requireNonNull(r.primitiveName, "primitiveName must not be null");
		String eventType = (String) map.get("eventType");
		r.eventType = eventType.equals("PUT") ? EventType.PUT : EventType.DELETE;
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> listMap = (List<Map<String, Object>>) map.get("fieldValueUpdates");
		if (listMap != null) {
			r.fieldValueUpdates = listMap.stream().map(m -> FieldValueUpdate.fromMap(m)).collect(Collectors.toList());
		}
		return r;
	}
}
