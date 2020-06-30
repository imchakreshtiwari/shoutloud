import React, { Component } from 'react';
import AutoComplete from 'react-autocomplete';

class AutoCompletes extends Component {
    constructor(props, context) {
        super(props, context);

        // Set initial State
        this.state = {
            // Current value of the select field
            value: "",
            // Data that will be rendered in the autocomplete
            // As it is asynchronous, it is initially empty
            autocompleteData: []
        };

        // Bind `this` context to functions of the class
        this.onChange = this.onChange.bind(this);
        this.onSelect = this.onSelect.bind(this);
        this.getItemValue = this.getItemValue.bind(this);
        this.renderItem = this.renderItem.bind(this);
        this.retrieveDataAsynchronously = this.retrieveDataAsynchronously.bind(this);
    }
    retrieveDataAsynchronously(searchText){
        let _this = this;

        // Url of your website that process the data and returns a
        let url = `http://localhost:8081/getcontactus?name=${searchText}`;
        
    
        let xhr = new XMLHttpRequest();
        xhr.open('GET', url, true);
        xhr.responseType = 'json';
        xhr.onload = () => {
            let status = xhr.status;

            if (status === 200) {
                _this.setState({
                    autocompleteData: xhr.response
                });

                // Show response of your server in the console
                console.log(xhr.response);
            } else {
                console.error("Cannot load data from remote source");
            }
        };
        xhr.send();
    }
    onChange(e){
        this.setState({
            value: e.target.value
        });
        this.retrieveDataAsynchronously(e.target.value);

        console.log("The Input Text has changed to ", e.target.value);
    }

    onSelect(val){
        this.setState({
            value: val
        });

        console.log("Option from 'database' selected : ", val);
    }

  
    renderItem(item, isHighlighted){
        return (
            <div style={{ background: isHighlighted ? 'lightgray' : 'white' }}>
                {item.name}
            </div>   
        ); 
    }


    getItemValue(item){
     
        return `${item.value} - ${item.label}`;
    }

    render() {
        return (
            <div>
                <AutoComplete
                    getItemValue={this.getItemValue}
                    items={this.state.autocompleteData}
                    renderItem={this.renderItem}
                    value={this.state.value}
                    onChange={this.onChange}
                    onSelect={this.onSelect}
                />
            </div>
        );
    }
}
 
export default AutoCompletes;