package org.openmcptools.extensions.update;

import java.util.Map;
import java.util.Objects;

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
	public Long createRevision;

	@JsonProperty("modRevision")
	public Long modRevision;

	@JsonProperty("version")
	public Long version;

	@JsonProperty("lease")
	public Long lease;

	public static Long convertToLong(Object o) {
		if (o instanceof Integer) {
			return ((Integer) o).longValue();
		} else if (o instanceof Long) {
			return (Long) o;
		}
		return 0L;
	}

	@SuppressWarnings("unchecked")
	public static FieldValueUpdate fromMap(Map<String, Object> map) {
		if (map == null) {
			return null;
		}
		FieldValueUpdate r = new FieldValueUpdate();
		r.fieldName = (String) map.get("fieldName");
		Objects.requireNonNull(r.fieldName, "fieldName must not be null");
		r.lease = convertToLong(map.get("lease"));
		r.version = convertToLong(map.get("version"));
		r.modRevision = convertToLong(map.get("modRevision"));
		r.createRevision = convertToLong(map.get("createRevision"));
		r.fieldValue = map.get("fieldValue");
		r.previous = FieldValueUpdate.fromMap((Map<String, Object>) map.get("previous"));
		return r;
	}

}
