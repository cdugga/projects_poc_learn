// program creates a HTTP server listening on a supplied port. When requests are received 
// the suppied file path is used as output in the response.

var http = require('http'),
	fs = require('fs'),
	path = require("path");

var port = process.argv[2],
	filePath = process.argv[3];

var server = http.createServer(function(req, res){

	var rs = fs.createReadStream(filePath);
	res.writeHead(200, {"Content-Type": "text/plain"});
 	//res.end("Hello World\n");
 	rs.pipe(res);
});

server.listen(port);

console.log("Server running at http://127.0.0.1:"+port+"/");