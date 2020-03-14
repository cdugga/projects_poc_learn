// load file reader
var fs = require('fs');
var path = require('path');

module.exports = function(dir, ext, callback){

	var results = new Array();
	fs.readdir(dir, function(err, list){
		if(err) return callback(err);
		
		results = list.filter(function(file){
			return path.extname(file) === '.' + ext
		})

//list.forEach(function(file) {
//	var tempExt = path.extname(file)
//	if(tempExt === "." + ext){
//		results.push(file)
//	}
//		})
		callback(null,results);

	});

	

};



