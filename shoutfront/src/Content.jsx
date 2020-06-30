import React, { Component } from 'react';
class Content extends Component {
    constructor(props){
        super(props);
        this.state={

        }
    }
    componentWillMount(){
        console.log('componentWillMount')
    }
    componentDidMount(){
        console.log('componentDidMount')
    }
    componentWillReceiveProps(newprops){
        console.log('componentWillReceiveProps')
    }
    shouldComponentUpdate(){
        console.log('shouldComponentUpdate')
    }
    componentDidUpdate(prevProps, prevState) {
        console.log('Component DID UPDATE!')
     }
     componentWillUnmount() {
        console.log('Component WILL UNMOUNT!')
     }
    render() { 
        return ( 

         );
    }
}
 
export default Content;