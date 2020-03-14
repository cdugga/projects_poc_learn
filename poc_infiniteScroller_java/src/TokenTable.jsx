import React from 'react';

import Token from './Token.jsx';

class TokenTable extends React.Component {
  render() {
    var rows = [];
    this.props.tokens.forEach(function(tokens) {
      rows.push(<Token tokens={tokens} />);
    });
    return (
       
    	<div className="container">
              <table className="table table-striped table-bordered" id="res">
               <thead>
                 <tr>
                   <th>Memeber Name</th><th>Member Number</th>
                 </tr>
               </thead>
               <tbody>
               	{rows}
	           </tbody>
              </table>
        </div>);
  }
}

export default TokenTable;