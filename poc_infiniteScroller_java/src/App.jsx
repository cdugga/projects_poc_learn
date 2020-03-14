import React from 'react';

import TokenTable from './TokenTable.jsx';

class App extends React.Component {
	
	render() {
	    return ( <TokenTable tokens={this.state.tokens}/> );
	}
	
	constructor(props) {
    	super(props);
    	this.state = {
        	tokens: []
     	};
    	this.loadTokensFromServer = this.loadTokensFromServer.bind(this);
	}
	
	componentDidMount () {
	   this.loadTokensFromServer();
	}

	loadTokensFromServer () {
	   $.ajax({
	      url: "http://localhost:8090/members"
	   }).then(function (data) {
	     this.setState({tokens: data});
	    }.bind(this));
	}
}
 
export default App;