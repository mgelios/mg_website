import React, { Component } from 'react';
import {connect} from 'react-redux';

class App extends Component {
	constructor (props){
		super(props);
		fetch("http://localhost:8080/weather/current")
		.then(response => response.json())
		.then(result => {
			console.log(result);
		});
	}

	render() {
		return (
			<div>
			</div>
		);
	}
}

export default connect( 
	state => ({
	}),
	dispatch => ({
	})
)(App);
