import React,{component} from 'react'

export class Simple extends React.Component{

    handleButton = (event) => {
        console.log("Inside Simple handleButton!")
        console.log(event)
    }

    render(){
        return(
            <div>
                <button onClick = {(event) => {console.log(event)}}>Simple Button</button>
                <button onClick = {this.handleButton}>Second Button</button>
            </div>
        )
    }
}

export function Input() {

    return (
        <div>
            <input type = "text" onChange = {(event) => {console.log(event)}}></input>
            <button onClick = {(event) =>{console.log(event)}}>Click 2</button>
        </div>
    )
}

function Button() {
    //callback would handle this event
    var handleClick = (event) =>{
        console.log(event);
    }
    return(
        <div>
            <button onClick={handleClick}>Click</button>
        </div>
    )
}

export default Button;