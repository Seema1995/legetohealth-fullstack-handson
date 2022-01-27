import React,{component} from 'react'

export class Person extends React.Component {
    constructor(props){
        super(props)
        this.state ={name:'', gender:'',mobnum:''}
    }

    // handleNameChange(event){
    //     this.setState({name: event.target.value});
    // }

    // handleGenderChange(event){
    //     this.setState({gender: event.target.value});
    // }

    // handleMobNumChange(event){
    //     this.setState({mobnum: event.target.value});
    // }
    displayName = (event) => {
        this.setState(({name : event.target.value}))
    }

    displayGender = (event) => {
        this.setState(({gender : event.target.value}))
    }

    displayMobNum = (event) => {
        this.setState(({mobnum : event.target.value}))
    }

    //OR  use below few lines syntax

    handleChange = (event) =>{
        this.setState({[event.target.name]:event.target.value})
    }
    render(){
    return (
        <div>
            Enter Name : <input type = "text" onChange={this.displayName}></input>
            Select Gender : <input type = "radio" value="Male" name="gender" onChange={ this.handleChange} />
            Male
               <input type = "radio" name="gender"value="Female"  onChange={ this.displayGender} />Female
            Enter Phone : <input type = "number" onChange={ this.displayMobNum}></input>
            
            <p>Name : {this.state.name} Gender : {this.state.gender} Mobile Num : {this.state.mobnum}</p>
            
        </div>)
        
    }
}

// export class DisplayInfo extends React.Component{

//     constructor(props){
//         super(props)
//     }
//     render(){
//         return (
//             <div>
//                 <p>Name : {this.props.details.name} Gender : {this.props.details.gender} Mobile Num : {this.props.details.mobnum}</p>
//             </div>
//         )
//     }
// }

export default Person;