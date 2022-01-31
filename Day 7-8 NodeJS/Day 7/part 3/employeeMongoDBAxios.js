let app = require("express")();

let MongoClient = require("mongodb").MongoClient;
let cors = require("cors")
let url = "mongodb://localhost:27017"
let port = 9092;
// // Create application/x-www-form-urlencoded parser  
let bodyParser = require("body-parser")
var urlencodedParser = bodyParser.urlencoded({ extended: false })  

app.listen(port,() => {console.log(`Node is running on port ${port}`)});

app.use(cors({origin : "*"}))

app.use(bodyParser.json())

app.get("/employee/:id",(request,response)=>{
        let empId = parseInt(request.params.id); //id set in url is in String format hence needs to be converted to int
		console.log("Inside get by id mongo")
        //convert to MongoDB db -> MongoClient.connect(url,parser,callback)
        MongoClient.connect(url,{useNewURLParser:true},(err,client) => {
            if(!err){
                let x =0 ;
                let db = client.db("myDb");
                //db.collectionName.find
                let doc = db.collection("employee").find({_id:empId});

                //doc.forEach(callbackIteration,callBackIterationEnds)
                doc.forEach((record) => {
                    x++;
					console.log(record);
                    response.send(record);
                },() => {
                    if(x==0){
                        response.status(404).json({error : "Id "+empId+" not found in Collection Employee"})
                    }
                    client.close();
                }) //forEach ends

            }//connect ends
        }) //get() ends
    })
app.get("/employee",(request,response) => {
    console.log("Inside get")
    MongoClient.connect(url,{useNewURLParser : true},(err,client) => {
        if(!err){
            let x = 0;
            let db = client.db("myDb");
            let employeesArr = []
            let doc = db.collection("employee").find();
            console.log("Inside mongoclient employee/")
            doc.forEach((record) => {
                x++;
                employeesArr.push(record)
            },() => {
                if(x==0){
                    response.json({error : "Employee collection is empty"})
                }else{
                    response.json(employeesArr)
                }
            })//forEach ends
        }//if ends
    })//client ends

}) //get ends

app.post("/employee",(request,response)=>{
    console.log("hee Ho")
   // console.log(request.body)

    MongoClient.connect((url),(err,client) =>{
        if(!err){
            console.log(request.body)
            let db = client.db("myDb");
            // let object = db.collection("employee").find( (err, data) => {
            //         if(err) return console.log(err);
            //         console.log(data)
            //     }).sort({"_id" : -1}).limit(1);
           // console.log(object)
            db.collection("employee").insertOne(request.body, (err, data) => {
                if(err) return console.log(err);

                response.send(('saved to db: ' + data));
            })
        }
    })
    // response.send("Success");
    }) //post() ends


    app.put("/employee",(request,response)=>{
        console.log("hee Ho put")
       // console.log(request.body)
    
        MongoClient.connect((url),(err,client) =>{
            if(!err){
                console.log(request.body)
                
                let db = client.db("myDb");
                let info =request.body
                let jsData = JSON.parse(JSON.stringify(info))
                console.log(info)
                //var data = JSON.parse(info)

                // for(var i=0;i<request.body.length;i++){
                //     console.log(request.body[i])
                // }

                db.collection("employee").updateOne(jsData[0],jsData[1], (err, data) => {
                    if(err) return console.log(err);
    
                    
                    response.sendStatus(200);
                })
                
                // console.log(request.body(0))
                // console.log(request.body(1))
                // request.body.forEach(function (item) {
                //     console.log(item.id);
                //     console.log(item.salary);
                // });
                // let object = db.collection("employee").find( (err, data) => {
                //         if(err) return console.log(err);
                //         console.log(data)
                //     }).sort({"_id" : -1}).limit(1);
               // console.log(object)
            }
        })
        // response.send("Success");
        }) //get() ends