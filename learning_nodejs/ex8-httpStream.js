// load file reader
var bl = require('bl');
var http = require('http');

http.get(process.argv[2], function (response){
	response.pipe(bl(function(err, data){
	if(err)
		return console.error(err)
	streamData = data.toString('utf8');

	console.log(streamData.length);
	console.log(streamData);
	}))
});