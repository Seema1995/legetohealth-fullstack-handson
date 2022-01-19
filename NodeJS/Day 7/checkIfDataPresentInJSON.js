let file = require("fs")

//file.readFile("users.json")
file.readFile('users.json',function(err,content){
    if(err) throw err;
    var parseJson = JSON.parse(content);
    console.log("Data from JSON file - ")
    
    var newUserObject={"name": "Duke","age":29}
    var newUserObject2 = {"name": "Eric","age":39}

    var flag = 0
    var flag1 = 0
    console.log(flag)
    console.log(flag1)

    function isEquivalent(a, b) {
        // Create arrays of property names
        var aProps = Object.getOwnPropertyNames(a);
        var bProps = Object.getOwnPropertyNames(b);
      
        console.log("aProps : "+aProps.values())
        console.log("bProps : "+bProps.values())
        // If number of properties is different,
        // objects are not equivalent
        if (aProps.length != bProps.length) {
          return 0;
        }
      
        for (var i = 0; i < aProps.length; i++) {
          var propName = aProps[i];
          console.log("a propName : "+aProps[i])
          console.log("a[propName] : "+a[propName])
          console.log("b[propName] : "+b[propName])
          // If values of same property are not equal,
          // objects are not equivalent
          
            if(a[propName] !== b[propName]){
                return 0;
            }
          
        }
      
        // If we made it this far, objects
        // are considered equivalent
        return 1;
    }


    parseJson.forEach(obj => {
        // Object.entries(obj).forEach(([key, value]) => {
        //     console.log(`${key} ${value}`);}
        // console.log(obj);
        console.log('Object.entries(obj): '+Object.entries(obj))          //returns [['name','Alex'],['age',35]]
        // console.log('Object.entries(obj).values() : '+Object.entries(obj).values()) // returns object array of Object[Array Iterator]{}
        // console.log('Object.keys(obj) : '+Object.keys(obj))
        // console.log('Object.values(obj) : '+Object.values(obj))
        // Object.entries(obj).forEach(([key, value]) => {
        //         // console.log(`${key} ${value}`);
        //         console.log('-------------------');
                
                
        //     })
            console.log('-------------------');
            console.log("Flag : "+flag)
            console.log("Flag 2 : "+flag1)
            if(flag==0){
            var flag = isEquivalent(obj,newUserObject);
            }
            if(flag1==0){
            var flag1 = isEquivalent(obj,newUserObject2);
            }


            if(flag==1){
                console.log("Data "+newUserObject.name+" is already present in users.json file ")
            }else{
                console.log("Data not present ...adding")
                parseJson.push(newUserObject)
                file.writeFile('users.json',JSON.stringify(parseJson),function(err){
                    if(err) throw err;
                  })
                  console.log("Data wrote to users.json successfully !!!")
            }

            if(flag1==1){
                console.log("Data "+newUserObject2.name+" is already present in users.json file ")
            }else{
                console.log("Data not present ...adding")
                parseJson.push(newUserObject2)
                file.writeFile('users.json',JSON.stringify(parseJson),function(err){
                    if(err) throw err;
                  })
                  console.log("Data wrote to users.json successfully !!!")
            }
        
    })
    
    
    });

    
      
    //   console.log(a === b); // false
    //   console.log(a == b);  // false
    //   console.log(isEquivalent(a, b)); // true