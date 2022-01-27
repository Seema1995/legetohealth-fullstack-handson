//This acts like a server
let app = require("express")();

//load http module and connect to the express app with Server property
let http = require("http").Server(app)

//load socket.io module and connect it to http using IIFE syntax
let io = require("socket.io")(http)

//load the client html page that can connect to this server
app.get("/",(request,response) => {
    response.sendFile(__dirname+"/clientSocket.html");
})

http.listen(9090,() => {
    console.log("server running on port 9090")
})

//handle messages coming from client and also send messages to the client
io.on("connection",(socket) => {
    console.log("Client is connected to the server : "+socket.connected)
    
    socket.on("clientMessage",(msg) => {
        console.log(msg)
        socket.emit("messageKey",msg)
    })

})