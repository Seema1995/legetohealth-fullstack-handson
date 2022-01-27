import React,{Component} from 'react'

export class EmployeeStoreForm extends React.Component{
    constructor(props){
        super(props)
        this.state = {id:'',name:'',salary:''}
    }

    handleSubmit = (event) => {
        event.preventDefault();
    }

    handleOnChange = (event) => {
        this.setState({[event.target.name] : [event.target.value]})
    }

    render(){
        return(
            <div>
                <form onSubmit ={this.handleSubmit}>
                    <div>
                        Enter ID : <input type ="number" name="id" autoComplete='off' onChange = {(event) => {
                        this.setState({[event.target.name] : [event.target.value]})
                        }}/>
                    </div> &nbsp;
                    <div>
                        Enter Name : <input type ="text" name="name" autoComplete='off' onChange = {(event) => {
                        this.setState({[event.target.name] : [event.target.value]})
                        }}/>
                    </div>&nbsp;
                    <div>
                        Enter Salary : <input type ="number" name="salary" autoComplete='off' onChange = {(event) => {
                         this.setState({[event.target.name] : [event.target.value]})
                        }}/>
                    </div>&nbsp;
                    <button type="submit" className ="btn btn-primary">Submit</button>
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