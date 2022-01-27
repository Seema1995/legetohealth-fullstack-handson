let app = require("express")();
let MongoClient = require("mongodb").MongoClient;
let cors = require("cors")
let url = "mongodb://localhost:27017"
let port = 9092;

app.listen(port,() => {console.log(`Node is running on port ${port}`)});

app.use(cors({origin : "*"}))

app.get("/employee/:id",(request,response)=>{
        let empId = parseInt(request.params.id); //id set in url is in String format hence needs to be converted to int

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
                    response.send(record);
                },() => {
                    if(x==0){
                        response.json({error : "Id "+empId+" not found in Collection Employee"})
                    }
                    client.close();
                }) //forEach ends

            }//connect ends
        }) //get() ends

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


})

