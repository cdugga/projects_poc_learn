// load file reader
var fs = require('fs');
var path = require('path');


fs.readdir(process.argv[2], function(err, list){
	if(err) throw err;
	list.forEach(function(file) {
		var ext = path.extname(file)
		if(ext === "." + process.argv[3]){
			console.log(file);	
		}
	})

});
