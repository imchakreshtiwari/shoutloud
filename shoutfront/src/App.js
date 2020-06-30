import React, {Component} from 'react';
import { BrowserRouter as Router , Route, Link, IndexRoute ,NavLink} from 'react-router-dom'
import logo from './logo.svg';
import './App.css';
 import ContactUs from './contactUs';
 import Contactusget from './contactusget';
import Search from './Search';
import AutoCompletes from './AutoComplet';
import StyleSheet from './StyleSheet';
import ThemeSwitcher from './ThemeSwitcher';
import Test from './Test';
class App extends Component {
    render() {
        return (
                   <React.Fragment>
                            <StyleSheet primary={false} />
                            <ContactUs />
                            <Contactusget />
                            <Search />
                            <AutoCompletes />
                            <ThemeSwitcher />
                         <Test></Test>
                   </React.Fragment>  
                
        );
    }
}
export default App;


