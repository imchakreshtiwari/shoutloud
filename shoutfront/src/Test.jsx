import React, { Component } from 'react';
class Test extends Component {
    constructor(props){
        super(props)
        this.state={
            myname:"abcd",
            myage:21
        };
    }
    changename=()=>
    {
        this.setState({'myname':'shubham'},()=>{alert("Name Modified")});
    }
    render() { 
        return ( 
            <div>
                <h1>My Name is {this.state.myname}</h1>
            <h3 onClick={this.changename}>My Name is {this.state.myname}</h3>
            </div>
            
         );
    }
}
 
export default Test;