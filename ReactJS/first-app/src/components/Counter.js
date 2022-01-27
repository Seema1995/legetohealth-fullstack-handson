import React,{component} from 'react'

class Counter extends React.Component{
    constructor(props){
        super(props)
        this.state ={likes:0, dislikes:0}
    }

    likesCounter = (event) => {
        this.setState((prevState) => ({likes : prevState.likes + 1}))
    }

    dislikesCounter = (event) => {
        this.setState((prevState) => ({dislikes : prevState.dislikes + 1}))
    }

    render(){
        return (<div>
            <h2>Counter Implementation</h2>
            <p> Likes : {this.state.likes}</p>
            <p>Dislikes : {this.state.dislikes}</p>
            <button className= "btn btn-primary" onClick = {this.likesCounter}>Like</button>
            &nbsp;
            <button className= "btn btn-primary" onClick = {this.dislikesCounter}>Dislike</button>
        </div>)
    }
}

export default Counter;