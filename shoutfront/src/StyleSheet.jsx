import React, { Component } from 'react';
import './mystyles.css'
class StyleSheet extends Component {
constructor(props){
    super(props);
    this.state={
        
    }
    
}
    render() { 
        let className //= props.primary ? 'primary':' '
        return (
            <div>

                     <h1 className={className}>stylesheet</h1>
                    </div>
          );
    }
}
 
export default StyleSheet;