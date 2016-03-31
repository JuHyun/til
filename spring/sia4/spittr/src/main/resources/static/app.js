'use strict';

// tag::vars[]
const React = require('react');
const client = require('./client');
// end::vars[]

// tag::app[]
class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {spittles: []};
	}

	componentDidMount() {
		client({method: 'GET', path: '/api/spittles'}).done(response => {
			this.setState({spittles: response.entity._embedded.spittles});
		});
	}

	render() {
		return (
			<SpittleList spittles={this.state.spittles}/>
		)
	}
}
// end::app[]

// tag::spittle-list[]
class SpittleList extends React.Component{
	render() {
		var spittles = this.props.spittles.map(spittle =>
			<Spittle key={spittle._links.self.href} spittle={spittle}/>
		);
		return (
			<table>
				<tr>
					<th>ID</th>
					<th>MESSAGE</th>
					<th>DATETIME</th>
				</tr>
				{spittles}
			</table>
		)
	}
}
// end::spittle-list[]

// tag::spittle[]
class Spittle extends React.Component{
	render() {
		return (
			<tr>
				<td>{this.props.spittle.id}</td>
				<td>{this.props.spittle.message}</td>
				<td>{this.props.spittle.dateTime}</td>
			</tr>
		)
	}
}
// end::spittle[]

// tag::render[]
React.render(
	<App />,
	document.getElementById('react')
)
// end::render[]

