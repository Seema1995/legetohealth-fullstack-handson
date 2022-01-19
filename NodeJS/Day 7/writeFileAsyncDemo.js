let file = require("fs")
var text = "my next Line"
file.writeFile("message.txt",text,{flag:"a+"},function(err){if(err){
    return console.log(err);
}
    var content = text.toString()
    console.log(content)

})

console.log("Write file async done")