# MCP Extensions for Java
A repository of MCP Extensions for Java. 

MCP spec currently does not support 

ToolGroups - The server-side creation of toolgroups...i.e. hierarchical sets/collections of tools that are associated with one another.  As an example, this project shows the creation/definition of an Arithmetic toolgroup, that refers to add, and multiply, individual tools. Domain-specific toolgroups can be created and used on the server, and optionally communicated to the MCP clients.  Like the tool MCP pritimitve all toolgroups can be given meta-data about the toolgroup (description, title, etc) that can be used on the server and/or the client.

Server-Initiated Dynamic Updates - Server updates/changes to tool meta-data (e.g. adding tools, removing tools, changing tool meta-data).  If, for example, a tool is added, the server can send a notification to the client that it should call listTools() to get a full refresh, but this is very inefficient and does not scale well at all.

## ToolGroup Extension

The [org.openmcptools.extensions.groups](https://github.com/OpenMCPTools/mcp_extensions_java/blob/main/org.openmcptools.extensions.groups) module provides an MCP extension to support hierarchical server-side tool grouping. 

#### Group Schema 

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
This schema for hierarchical grouping was [initially proposed as a MCP protocol enhancement](https://github.com/modelcontextprotocol/modelcontextprotocol/discussions/1567#discussioncomment-14608597).  For a discussion specifically of the 'parent' field, and it's role in hierarchical toolgroups, [please see this and subsequent postings](https://github.com/modelcontextprotocol/modelcontextprotocol/discussions/1567#discussioncomment-14618688).

The same schema is used for the [mcp_extensions_java group extension](https://github.com/OpenMCPTools/mcp_extensions_java/tree/main/org.openmcptools.extensions.groups) (Java SDK) and the [mcp_extensions_python group extension](https://github.com/OpenMCPTools/mcp_extensions_python/tree/main/org.openmcptools.extensions.groups) (Python SDK).  Using the same schema allows interoperability between Java, Python, and Typescript clients and servers.

## MCP Primitive Dynamic Update Extension

The [org.openmcptools.extensions.update](https://github.com/OpenMCPTools/mcp_extensions_java/blob/main/org.openmcptools.extensions.update) project provides an extension to support incremental server updates of MCP tool metadata via server->client(s) json 2.0 notifications. The notifications include a server-defined diff of what was updated.




