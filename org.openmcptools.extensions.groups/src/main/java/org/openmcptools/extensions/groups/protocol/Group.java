package org.openmcptools.extensions.groups.protocol;

import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Group {
	
	@JsonProperty("name")
	public String name;
	@JsonProperty("title")
	public String title;
	@JsonProperty("description")
	public String description;
	@JsonProperty("parent")
	public Group parent;
	@JsonProperty("_meta")
	public Map<String, Object> meta;
	
	public Group(String name) {
		Objects.requireNonNull("name", "Group name must not be null");
		// Other construction checks eventually...e.g. no cycles
		this.name = name;
	}
	
	@SuppressWarnings("unchecked")
	public static Group convertMapToGroup(Map<String, Object> groupMap) {
		org.openmcptools.extensions.groups.protocol.Group result = new org.openmcptools.extensions.groups.protocol.Group((String) groupMap.get("name"));
		result.title = (String) groupMap.get("title");
		result.description = (String) groupMap.get("description");
		Map<String, Object> parentMap = (Map<String, Object>) groupMap.get("parent");
		if (parentMap != null) {
			result.parent = convertMapToGroup(parentMap);
		}
		result.meta = (Map<String,Object>) groupMap.get("_meta");
		return result;
	}
	
	private String getGroupName(StringBuffer sb, Group tg, String separator) {
		return (tg.parent != null)
				? new StringBuffer(getGroupName(sb, parent, separator)).append(separator).append(tg.name).toString()
				: tg.name;
	}

	public String getFullyQualifiedName(String nameSeparator) {
		return getGroupName(new StringBuffer(), this, nameSeparator);
	}

}
