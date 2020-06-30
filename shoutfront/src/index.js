import 'bootstrap/dist/css/bootstrap.min.css';
import $ from 'jquery';
import Popper from 'popper.js';
import 'bootstrap/dist/js/bootstrap.bundle.min';
import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';
import { Router, Route,browserHistory, Link, Switch,  IndexRoute } from 'react-router'

import Home from './App';
import About from './App';
import Contact from './App';


ReactDOM.render(<App />,document.getElementById('root'));
//    <div>
//           <Router history = {browserHistory}>
//    <Link to="/">Link1</Link>
//    <Link to="/home">Link2</Link>
//    <Link to="/about">Link3</Link>
//    <Link to="/contact">Link4</Link>

//        <Route path = "/" component = {App}>
//          <Route exact path="/" component={Home}/>
//           <Route path = "/home" component = {Home} />
//           <Route path = "/about" component = {About} />
//           <Route path = "/contact" component = {Contact} />
//        </Route>
//     </Router>
//     </div>
 // ),
   

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
