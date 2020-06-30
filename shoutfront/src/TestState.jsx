import React, { Component } from 'react';
class TestState extends Component {
    constructor(props){
        super(props);
        this.state = { 
            header:"Header",
            footer:"Footer"
         }
    }
    
    render() { 
        return ( 
            <div>
               <h1>{this.props.header}</h1> 
                <h1>{this.state.footer}</h1>
            </div>
         );
    }
}
 
export default TestState;