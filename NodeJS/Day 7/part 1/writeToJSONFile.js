let file = require("fs")

//Reading from JSON File
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
    
//Writing to JSON File
    var newUserObject={"name": "Duke","age":29}
    var newUserObject2 = {"name": "Eric","age":39}
    
    parseJson.push(newUserObject)
    parseJson.push(newUserObject2)

    // checkIfUserPresent(newUserObject)
    // checkIfUserPresent(newUserObject2)

    file.writeFile('users.json',JSON.stringify(parseJson),function(err){
        if(err) throw err;
      })

      console.log("Data wrote to users.json successfully !!!")

     
    //   function checkIfUserPresent(x){
    //       var vals = Object.
    //       parseJson.forEach
    // }
  })

  