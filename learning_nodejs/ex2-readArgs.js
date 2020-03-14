var sum = 0;
for(var i = 0; i< process.argv.length; i++){

	if(i >= 2){
		
		var tempVal = process.argv[i];
		if(!isNaN(tempVal)){
			sum += Number(tempVal);	
		}
	}
}

console.log(sum);

//var total = 0;

//process.argv.forEach(function(item) {
  //we need to exclude first and second items
  //so we could just filter them as NAN
//  total += +item ? +item : 0;
//});

//console.log(total);