let http = require("http")
let url = require("url")
let port = 9090
//let host = "localhost"
let Server = http.createServer((request,response)=>{
//This callback is executed when a request is received on port 9090

if(request.url!='/favicon.ico'){
    let urlObject = url.parse(request.url,true)
    console.log(urlObject.query.name)
    //This response is displayed on front end as plain text even if it is enclosed in header tag
    response.write("<h2>Welcome to web</h2>")
    response.writeHead(200,{"content-type":"text/html"})

    //to end response creation and send it to client
    response.end()
}
})
Server.listen(port,()=>console.log("Sevrer is listening on port "+port))