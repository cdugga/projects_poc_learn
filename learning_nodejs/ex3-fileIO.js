
// load file reader
var fs = require('fs');

// pull file path from arguments
var bufferObj = fs.readFileSync(process.argv[2])

// convert to string and split on new line and count -1 one to exclude the line at the end of the file
var numLines = bufferObj.toString().split("\n").length -1;

console.log(numLines)