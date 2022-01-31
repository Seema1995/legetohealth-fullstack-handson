import React,{Component} from 'react'
import axios from 'axios'

export class EmployeeItems extends React.Component{
    constructor(props){
        super(props)
        this.state = {employee : []}
    }

    handleRefresh = (event) => {
        console.log("Inside handleRefresh")
        let url = "http://localhost:9092/employee"
        axios.get(url)
        .then((response)=> { console.log(response.data);this.setState({employee : response.data});})
        .catch((err)=>console.log(err))

        // axios.get(url2)
        // .then((response) => this.setState({employee : response.data}))
        // .catch((err) => console.log(err))
        
    }

    render(){
        return(
            <div>
                <h1 className="text-center"> Welcome to Employee Data Display using Bootstrap and React</h1>
                <button onClick = {this.handleRefresh} className="btn btn-primary">Refresh</button>
                <table className="table table-striped">
                    <thead>
                        <tr>
                            <th>S.No.</th><th>ID</th><th>Name</th>
                        </tr>
                    </thead>
                    <tbody>
                            {this.state.employee.map((item,index) => 
                                <tr key = {item._id}>
                                    <td>{item._id}</td><td>{item.name}</td><td>{item.salary}</td>
                                </tr>
                            )
                        }
                    </tbody>
                </table>
            </div>
        )
    }

}

export class EmployeeById extends React.Component{
    constructor(props){
        super(props)
        this.state = {employee : {_id : '',name : '',salary : ''}}
    }

    handleRefresh = (event) => {
        console.log("Inside handleRefresh of employeeById")
        let url2 = "http://localhost:9092/employee/2"
        axios.get(url2)
        .then((response)=> { console.log(response.data);this.setState({employee : response.data});})
        .catch((err)=>console.log(err))
    }

    render(){
        return(
            <div>
                <h1 className="text-center"> Welcome to Employee Data Display using Bootstrap and React</h1>
                <button onClick = {this.handleRefresh} className="btn btn-primary">Refresh</button>
                <table className="table table-striped">
                    <thead>
                        <tr>
                            <th>ID</th><th>Name</th><th>Salary</th>
                        </tr>
                    </thead>
                    <tbody>
                            <tr key = {this.state.employee._id}>
                                <td>{this.state.employee._id}</td><td>{this.state.employee.name}</td><td>{this.state.employee.salary}</td>
                            </tr>   
                    </tbody>
                </table>
            </div>
        )
    }

}

export class EmployeeStoreForm extends React.Component{
    constructor(props){
        super(props)
        this.message = ''
        this.isSuccess = false
        this.state = {id:'',name:'',salary:''}
    }

    handleSubmit = (event) => {
        event.preventDefault();
        console.log(this.state.name)
        const employeeData = {
            name : this.state.name,
            salary : this.state.salary
        }
        console.log("employeeData from Form : "+employeeData)
        console.log("Inside handleSubmit of employeeStore")
        let url = "http://localhost:9092/employee"
        //url = "http://localhost:9092/"
        axios.post(url,employeeData)
        .then((response)=> { console.log(response.data);this.message = response.data})
        .catch((err)=>console.log(err))
    }

    handleOnChange = (event) => {
        this.setState({[event.target.name] : [event.target.value]})
    }

    render(){
        return(
            <div>
                <form onSubmit ={this.handleSubmit} method='post'>
                    <table>
                        <tbody>
                            <tr>
                                <td className = "col-5">
                                    Enter ID : 
                                </td>
                                <td>
                                    <input type ="number" name="id" autoComplete='off' onChange = {(event) => {
                            this.setState({[event.target.name] : [event.target.value]})
                            }}/>
                                </td>
                            </tr>
                            <tr>
                                <td className = "col-5">
                                    Enter Name :  
                                </td>
                                <td>
                                    <input type ="text" name="name" autoComplete='off' onChange = {(event) => {
                            this.setState({[event.target.name] : [event.target.value]})
                            }}/>
                                </td>
                            </tr>
                            <tr>
                                <td className = "col-5">
                                    Enter Salary : 
                                </td>
                                <td>
                                    <input type ="number" name="salary" autoComplete='off' onChange = {(event) => {
                            this.setState({[event.target.name] : [event.target.value]})
                            }}/>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    
                    <button  type="submit" className ="btn btn-primary">Submit</button>

                    <hr></hr>
                    <SuccessMessagePost message={this.message}></SuccessMessagePost>
                </form>

                <div className ="row" >
                    Id : {this.state.id} &nbsp;
                </div>
                <div className ="row" >
                    Name : {this.state.name} &nbsp; 
                </div>
                <div className ="row" >
                    Salary : {this.state.salary} &nbsp;
                </div>   
            </div>
        )
    }
}

export class EmployeeUpdate extends React.Component{

}

export class SuccessMessagePost extends React.Component{

    constructor(props){
        super(props)
    }

    render(){
        return(
            <div className="row">
                <p>{this.props.message}</p>
            </div>
        )
    }
}