package org.openmcptools.extensions.groups.protocol;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupsExtensionConfig {
	public static String EXTENSION_ID = "org.openmcptools/groups";
	
	public static String SERVER_CAPABILITIES_ID = EXTENSION_ID + "/server";
	public static String CLIENT_CAPABILITIES_ID = EXTENSION_ID + "/client";
}
