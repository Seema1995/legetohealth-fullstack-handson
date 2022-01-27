let app = require("express")();
let mysql = require("mysql")
let bodyParser = require("body-parser")
// // Create application/x-www-form-urlencoded parser  
var urlencodedParser = bodyParser.urlencoded({ extended: false })  
//app.use(express.static('public'));  


const connection = mysql.createConnection({
    host     : 'localhost',
    user     : 'root',
    password : 'root',
    database : 'legato_health_db'
  });
  
  connection.connect((err) => {
      if(err) throw err;
      console.log('Connected to MySQL Server!');
  });



let url = "jdbc:mysql://localhost:3306"
let port = 9092;
//to extract json and text from the body of he request
app.use([bodyParser.text(),bodyParser.json()])
app.use(bodyParser.json());

app.listen(port,() => {console.log(`Node is running on port ${port}`)});

let sql = `UPDATE employee
           SET salary = ?
           WHERE id = ?`;
           
let data = [12000, 7];

app.get("/employee/:id",(request,response) => {
    //Creating connection inside the REST method to ensure that every rest operation gets enqueued and doesn't gets closed
    const connection = mysql.createConnection({
        host     : 'localhost',
        user     : 'root',
        password : 'root',
        database : 'legato_health_db'
      });

    let empId = request.params.id;
    connection.query('SELECT * from employee where id='+empId, (err, rows) => {
    if(err) throw err;
    console.log('The data from users employee are: \n', rows);
    response.json(rows)
    });
    //Closing the connection after the operation
    connection.end();
});

app.get("/employee",(request,response) => {
    connection.query('SELECT * from employee', (err, rows) => {
    if(err) throw err;
    console.log('The data from users employee are: \n', rows);
    connection.end();
    response.json(rows)
    });
});

//handling PUT request to update
app.put('/employee/:id',(request,response) => {
    var sal = 12000;
    var empId = request.params.id;
    //express.js cannot read request body using request.body. Hence it needs to use body-parser module to read body
     let reqBody = request.body
     console.log(reqBody)
    // response.send(reqBody)
    
    // execute the UPDATE statement
    connection.query(sql, data, (error, results, fields) => {
        if (error){
        return console.error(error.message);
        }
        console.log('Rows affected:', results.affectedRows);
        response.json(results.affectedRows)
    });
})

//handling delete method
app.delete('/employee/:id',(request,response) => {
    // execute the delete statement
    connection.query("delete from employee where id = ?", [6], (error, results, fields) => {
        if (error){
        return console.error(error.message);
        }
        console.log('Deleted Rows :', results.affectedRows);
        response.json(results.affectedRows)
    });
})


//handling post method
app.post('/employee', urlencodedParser,(request,res) => {
    var name
    //var id
    var salary
      // Prepare output in JSON format  
    response = {  
       // id:request.body.id,  
        name:request.body.name ,
        salary:request.body.salary 
    };  
    console.log(response);  
    connection.query("insert into employee (name,salary) values (?,?) ", [request.body.name,request.body.salary], (error, results, fields) => {
            if (error){
            return console.error(error.message);
            }
            console.log('Rows inserted :', results.affectedRows);
            res.sendStatus(200)
        
    });
})



                                                                                                                                                                                                                                                                                                                                                                                                                