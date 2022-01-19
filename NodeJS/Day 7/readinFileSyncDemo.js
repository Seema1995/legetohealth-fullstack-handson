let file = require('fs')

//read the file data into byte stream synchronously
let fileDataToByteStream = file.readFileSync('simple.txt')

//converting the byte data to char stream to make it readable
let fileContentByteToCharStream =  fileDataToByteStream.toString();
console.log(fileContentByteToCharStream)
