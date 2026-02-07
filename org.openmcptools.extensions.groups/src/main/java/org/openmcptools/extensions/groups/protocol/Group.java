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
	
	private String getToolGroupName(StringBuffer sb, Group tg, String separator) {
		if (tg.parent != null) {
			return new StringBuffer(getToolGroupName(sb, parent, separator)).append(separator).append(tg.name).toString();
		}
		return tg.name;
	}

	public String getFullyQualifiedName(String nameSeparator) {
		return getToolGroupName(new StringBuffer(), this, nameSeparator);
	}

}
