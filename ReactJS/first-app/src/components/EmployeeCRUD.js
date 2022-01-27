import React,{Component} from 'react'
import axios from 'axios'

export class EmployeeItems extends React.Component{
    constructor(props){
        super(props)
        this.state = {employee : []}
    }

    handleRefresh = (event) => {
        console.log("Inside handleRefresh")
        let url = "http://localhost:9090/employee"
        axios.get("http://localhost:9092/employee")
        .then((response)=> this.setState({employee : response.data}))
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