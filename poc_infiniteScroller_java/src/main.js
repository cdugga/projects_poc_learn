import React from 'react';
import ReactDOM from 'react-dom';
import $ from 'jquery';
//by default every module/package that resides in node_modules is treated as external module so webpack will do nothing with it, 
//meaning loaders won't run. In order to get this to work, bootstrap package needs to be marked as non-external package or apply loaders inline. 
//Recommended solution is to use relative paths or special compiled alias, that will tell webpack to compile module.
import "../node_modules/bootstrap/dist/css/bootstrap.css";
import 'toastr/build/toastr.css';


import App from './App.jsx';;

ReactDOM.render(<App />, document.getElementById('root') );