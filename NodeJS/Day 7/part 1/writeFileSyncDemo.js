let writeToFile = require('fs')

var text = "Hi. This is my message."
writeToFile.writeFileSync("message.txt",text,{flag:"a+"})

console.log("Done writing ")