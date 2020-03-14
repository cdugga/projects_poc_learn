import React from 'react';

import ReactDOM from 'react-dom';
import $ from 'jquery';


//by default every module/package that resides in node_modules is treated as external module so webpack will do nothing with it, 
//meaning loaders won't run. In order to get this to work, bootstrap package needs to be marked as non-external package or apply loaders inline. 
//Recommended solution is to use relative paths or special compiled alias, that will tell webpack to compile module.
import "../node_modules/bootstrap/dist/css/bootstrap.css";

import 'toastr/build/toastr.css';

var App = React.createClass({
	loadTokensFromServer: function () {
    var self = this;
    $.ajax({
      url: "http://localhost:8080/prices"
    }).then(function (data) {
      self.setState({tokens: data});
    });
  },
  getInitialState: function () {
    return {tokens: []};
  },
  componentDidMount: function () {
    this.loadTokensFromServer();
  },
  render() {
    return ( <TokenTable tokens={this.state.tokens}/> );
  }
});
 
 
var Token = React.createClass({
	render: function() {
    return (
      <tr>
        <td>{this.props.tokens.symbol}</td>
        <td>{this.props.tokens.btc_price}</td>
        <td>{this.props.tokens.eur_price}</td>
        <td>{this.props.tokens.holdings}</td>
        <td className="countable alert alert-info">{this.props.tokens.euroValueOfHolding}</td>
      </tr>
      );
  },
  componentDidMount: function() {
	    	 var cls = document.getElementById("res").getElementsByTagName("td");
	    	    var sum = 0;
	    	    for (var i = 0; i < cls.length; i++){
	    	        if(cls[i].className == "countable alert alert-info"){
	    	            sum += isNaN(cls[i].innerHTML) ? 0 : parseInt(cls[i].innerHTML);
	    	        }
	    	    }
	    	    $('#ethTotal').html("€"+sum);
	}
});
 
var TokenTable = React.createClass({
  render: function() {
    var rows = [];
    this.props.tokens.forEach(function(tokens) {
      rows.push(<Token tokens={tokens} />);
    });
    return (
       <div className="container">
              <table className="table table-striped table-bordered" id="res">
               <thead>
                 <tr>
                   <th>Token</th><th>BTC Price</th><th>Euro Price</th><th>Holding</th><th>€</th>
                 </tr>
                
               </thead>
               <tbody>
               {rows}
               <tr className="h4 alert alert-success" >
	           	<th>Totals</th><th></th><th></th><th></th><th id="ethTotal"></th>
	           </tr>
	          </tbody>
               
             </table>
           </div>);
  }
});
ReactDOM.render(<App />, document.getElementById('root') );