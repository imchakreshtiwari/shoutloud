import React, { Component } from 'react';
import axios from 'axios';
 import Suggestions from './Suggestion';

class Search extends Component {
    state = { 
        query:'',
        results:[]
     };
     
     handleChange=() =>{
        this.setState({query:this.search.value},() => {
            if(this.state.query && this.state.query.length>1){
                if(this.state.query.length%2===0){
                    this.getInfo();
                }
                else if (!this.state.query) {
                }
            }

        })
     }

     getInfo = () =>{
        axios.get('http://localhost:8081/getcontactus')
        .then(({ data }) => {
            console.log('data=================',data)
            this.setState({
              results: data
              
            },()=>{          console.log('  console.log(this.state.results)-------------------',this.state.results)
        })
 })
      } 
    render() { 
        return ( 
            <form>
                <input placeholder="Search For..." ref={input=> this.search = input} onChange={this.handleChange.bind(this)}>
                </input>
                
                <Suggestions results={this.state.results} />
            </form>
         );
    }
}
 
export default Search;