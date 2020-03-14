
var moduleIO = require('./moduleIO.js');

var dir = process.argv[2]
var ext = process.argv[3]

moduleIO(dir, ext, function(err, results){

	if(err) throw err;

	results.forEach(function(file){
		console.log(file);
	})

//	for(var i = 0; i < results.length; i++){
//		console.log(results[i]);	
//	}

});