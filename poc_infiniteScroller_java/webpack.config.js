var ExtractTextPlugin = require('extract-text-webpack-plugin');

module.exports = {
		  entry: './src/main.js',
		  output: {
		    path: __dirname + '/src/main/resources/public', 
		    filename: 'bundle.js' 
		  },
		  module: {
		    loaders: [
		      {
		    	test: /\.(js|jsx)$/,
		        //test: /.jsx$/,
		        loader: 'babel',
		        exclude: /node_modules/,
		        query: {
		          presets: ['es2015',"stage-0", 'react']
		        }
		      },
		      { 
		      	test: /\.css$/, 
		      	loader: ExtractTextPlugin.extract("style-loader", "css-loader")
		      },
		      { test: /\.(woff2?|ttf|eot|svg|png|jpe?g|gif)$/,
		        loader: 'file'
		      }
		    ]
		  },
		  plugins: [
		    new ExtractTextPlugin("styles.css")
		  ]
		}