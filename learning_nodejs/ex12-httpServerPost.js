// program creates a HTTP server listening on a supplied port. When requests are received 
// the suppied file path is used as output in the response.

var http = require('http'),
	map = require('through2-map');

var port = process.argv[2];
var server = http.createServer(function(req, res){

	if(req.method === 'POST'){

		req.pipe(map(function(chunk){
			return chunk.toString().toUpperCase();
		})).pipe(res);

		// var body = "";
		// req.on('data', function (chunk){
		// 	body += chunk;
		// })

		// req.on('end', function(){
		// 	console.log('sending....' + body);
		// 	res.writeHead(200, {"Content-Type": "text/plain"});	
		// 	res.end(body.toString().toUpperCase());
		// })
	}
	
});

server.listen(port);

console.log("Server running at http://127.0.0.1:"+port+"/");