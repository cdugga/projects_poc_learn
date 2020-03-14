// open telnet client and connect to this tcp server using telnet localhost <port>
// in telnet client the syntax may be $>o localhost <port>

var net = require('net')

var server = net.createServer(function (socket){
	console.log("connected...");

	socket.write(currentTime()+"\n");
	server.close(socket);
	//socket.pipe(socket);
})

// listen on port supplied by command line
server.listen(process.argv[2], function(){
	console.log("server bound to port: " + process.argv[2])
});

function currentTime(){
	var date = new Date();
	return date.getFullYear() + "-"+ zeroFill((date.getMonth()+1),2) + "-" + date.getDate() + " " 
		+ date.getHours() + ":" + date.getMinutes();
}

function zeroFill(number,width){
  width -= number.toString().length;
  if (width > 0){
   return new Array( width + (/\./.test( number ) ? 2 : 1) ).join( '0' ) + number;
  }
  return number + ""; // always return a string
}

//add zero padding
//return (i < 10 ? '0' : '') + i