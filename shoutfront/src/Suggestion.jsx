import React, { Component } from 'react';

const Suggestions =(props) => {
  console.log('from suggestions==========',props.results)
    const options = props.results.map(r => (
        <li key={r.id}>
          {r.name}
        </li>
      ))
       return <ul>{options}</ul>
    
}
 
export default Suggestions;