import React, { Component } from 'react';
import axios from 'axios';
class ContactUsGet extends Component {
    state = { 
        contactus: []
     }
     componentDidMount(){
         axios.get("http://localhost:8081/getcontactus").then(res =>{
            const contactus = res.data;
            this.setState({contactus});
         } )
     }
    render() { 
        return ( 
            <ul>
                {this.state.contactus.map(contactone => <li>{contactone.fname}</li>)}
            </ul>
         );
    }
}
 
export default ContactUsGet;