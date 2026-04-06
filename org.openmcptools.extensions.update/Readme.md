# Server Dynamic Updates

This project provides a MCP server extension for MCP servers to dynamically deliver updates of MCP primitives (e.g. tools), 
via json rpc 2.0 notifications.  Json 2.0 rcp notifications are already a part of the MCP protocol and so this extension simply defines a
few small json schema additions.

With existing MCP, if a server adds a new tool, the server will send a notification to client(s) that the list of tools has changed.  Usually,
this will result in the MCP client calling listTools() to refresh all tools from the given server.  If the server exposes many tools, however, 
listing all tools could result in a lot of extra data.

This extension allows an MCP server to only send a 'diff' for the update via a json rpc 2.0 notification. Sending a diff of the change
efficient.  For example, lets say that one tool is removed on the server, but that many other tools are still present.  Sending the client a simple 
notification to call listTools() will result in a lot of extra traffic, duplicated for every connected client.  Sending a 'delete tool with name: x', 
however, is much simpler and more efficient. This extension allows servers to send incremental 
updates of tools or other primitives via json notifications.

An example of the use of this extension for tools to be dynamically updated is in [this project](https://github.com/ECF/MCPToolGroups).  
