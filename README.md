# mcp_extensions_java
A repository of MCP Extensions for Java

## Group Extension

The [org.openmcptools.extensions.groups](https://github.com/OpenMCPTools/mcp_extensions_typescript/tree/main/org.openmcptools.extensions.groups) module provides an MCP extension to support hierarchical server-side grouping. 

### What's in here

The project defines a Jackson-annotated [Group class](https://github.com/OpenMCPTools/mcp_extensions_java/blob/main/org.openmcptools.extensions.groups/src/main/java/org/openmcptools/extensions/groups/protocol/Group.java) for 
serializing/deserializing a tree of Groups.

#### Extension Config 

[Extension identifier constants](https://github.com/OpenMCPTools/mcp_extensions_java/blob/main/org.openmcptools.extensions.groups/src/main/java/org/openmcptools/extensions/groups/protocol/GroupsExtensionConfig.java) (`org.openmcptools/groups`).

#### Schema 

json-schema for the a Group

```json
        "Group": {
            "properties": {
                "name": {
                    "type": "string"
                },
                "parent": {
                    "$ref": "#/definitions/Group",
                },
                "description": {
                    "type": "string"
                },
                "title": {
                    "type": "string"
                },
                "_meta": {
                    "additionalProperties": {},
                    "type": "object"
                }
            },
            "required": [
                "name"
            ],
            "type": "object"
        }
```
This schema for hierarchical grouping was [initially proposed as a MCP protocol enhancement](https://github.com/modelcontextprotocol/modelcontextprotocol/discussions/1567#discussioncomment-14608597).  For a discussion specifically of the 'parent' field, and it's role in hierarchical grouping, [please see this and subsequent postings](https://github.com/modelcontextprotocol/modelcontextprotocol/discussions/1567#discussioncomment-14618688).

The same schema is used for the [mcp_extensions_java group extension](https://github.com/OpenMCPTools/mcp_extensions_java/tree/main/org.openmcptools.extensions.groups) (Java SDK) and the [mcp_extensions_python group extension](https://github.com/OpenMCPTools/mcp_extensions_python/tree/main/org.openmcptools.extensions.groups) (Python SDK)

### Known Projects Using Extension 

If you are using an extension and would like to be added to this list, please open a pr.

[MCPToolGroups](https://github.com/ECF/MCPToolGroups)

## Update Extension

This extension defines a small set classes to represent incremental updates for MCP primitives.  


