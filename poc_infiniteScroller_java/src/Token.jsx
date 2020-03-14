import React from 'react';

class Token extends React.Component {

	render() {
		    return (
		      <tr>
		        <td>{this.props.tokens.playerName}</td>
		        <td>{this.props.tokens.playerID}</td>
		      </tr>
		      );
		}
}

export default Token;