
// makes http get request for each of three arguments supplied to the program. Prints srting representation
// of result in same order as URL was passed into the program

// load file reader
var bl = require('bl');
var http = require('http');

var streams = [] 
var count = 0;

process.argv.forEach(function(val, index, array){
	if(index >= 2){
		http.get(val, function (response){
			response.pipe(bl(function(err, data){
				if(err)
					return console.error(err)
				
				streams[index] = data.toString('utf8')
				count++;

				if(count === 3){
					onComplete();	
				}

			}));
			
		});
	}
})


function onComplete(){
	for(var i=2; i < 5; i++){
		console.log(streams[i])
	}
}


