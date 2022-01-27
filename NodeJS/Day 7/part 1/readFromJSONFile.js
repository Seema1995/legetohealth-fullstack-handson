let file = require("fs")

//file.readFile("users.json")
file.readFile('users.json',function(err,content){
    if(err) throw err;
    var parseJson = JSON.parse(content);
    console.log("Data from JSON file - ")
    
    parseJson.forEach(obj => {
        Object.entries(obj).forEach(([key, value]) => {
            console.log(`${key} ${value}`);
        });
        console.log('-------------------');
    });

  })