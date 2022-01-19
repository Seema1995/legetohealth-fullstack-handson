let file = require("fs")

file.readFile("message.txt",(err,data)=>{if(err){
    console.log(err);
}else{
    var content = data.toString()
    console.log(content)
}
})
console.log("Read file async done")