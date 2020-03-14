
// load file reader
var fs = require('fs');

// pull file path from arguments
var bufferObj = fs.readFile(process.argv[2],'utf8', function(err, data){

	if (err) throw err;
	
	var numLines = data.split("\n").length -1;

	console.log(numLines)

});

// convert to string and split on new line and count -1 one to exclude the line at the end of the file
