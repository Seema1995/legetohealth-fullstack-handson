// let express = require("express")
// let func = express()

const req = require("express/lib/request")
let bodyParser = require("body-parser")

//OR

let app = require("express")() //Immediately Invoked Function Execution (IIFE)
let port = 9090

//to extract json and text from the body of he request
app.use([bodyParser.text(),bodyParser.json()])

//handling GET request
app.get('/employee/',(request,response) => {
    response.send("/Handling employee GET request")
})
//handling GET request - can create response body but not request body. Request body can be created by PUT,POST,DELETE.
//Response body can be created by all
app.get('/employee/:details',(request,response) => {
    console.log(request.params.details)
    var employee = {name:"Sam Walton",age:78,id:1001}
    response.json(employee)
})

//handling POST request
app.post('/employee',(request,response) => {
    // /employee/:id/:name/:salary    -> here :id, :name ,:salary are path vars
    // let requestDets = request.params
    // let emp = {name : requestDets.name,id : requestDets.id, salary : requestDets.salary}
    // response.json(emp)
    //express.js cannot read request body using request.body. Hence it needs to use body-parser module to read body
    let reqBody = request.body
    console.log(reqBody)
    response.send(reqBody)
    // console.log(emp)
    //response.send("Handling POST request")
})
//handling PUT request
app.put('/',(request,response) => {
    let requestDets = request.params
    let emp = {name : requestDets.name,id : requestDets.id, salary : requestDets.salary}
    response.json(emp)
})

//handling DELETE request
app.delete('/',(request,response) => {
    let requestDets = request.params

    let emp = {name : requestDets.name,id : requestDets.id, salary : requestDets.salary}
    response.json(emp)
})

app.listen(port,()=>console.log("Hi"))