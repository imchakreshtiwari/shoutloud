import React, { Component } from "react";
import axios from "axios";
class ContactUs extends Component {
  constructor(props) {
    super(props);
    this.state = {
      fname: "",
      email: "",
      query: ""    
    };
  }

onChange = (e) => {
    this.setState({[e.target.name]:e.target.value})
}

  handleSubmit = (e) => {
    e.preventDefault();
    const {fname,email,query}=this.state;


    axios
      .post(`http://localhost:8081/contactus`, {fname,email,query})
      .then(res => {
        console.log(res);
        console.log(res.data);
        this.setState({fname:'',email:'',query:''})
      });
  }
  

 

  render() {
    const {fname,email,query}=this.state;
    return (
      <React.Fragment>
      <div class="form-group form-group-lg">
      
        <form  class ="form-inline" onSubmit={this.handleSubmit}>
          <label>
            Name:
            <input
              type="text"
              class="form-control input-sm"
              name="fname"
              value={fname}
              onChange={this.onChange}
            ></input>
          </label>
          <br />
          <label>
            Email:
            <input
              type="text"
              class="form-control input-lg"
              name="email"
              value={email}
              onChange={this.onChange}
            ></input>
          </label>
          <br />
          <label>
            Query:
            <input
              type="textarea"
              class="form-control"
              value={query}
              name="query"
              onChange={this.onChange}
            ></input>
          </label>
          <br />
          <input type="submit" value="Submit" class="btn-btn-default"></input>
        </form>
      </div>
        
      <div class="media">
        <div class="media-left">
          
        </div>

      </div>
       </React.Fragment>
    );
   
  }
}

export default ContactUs;
