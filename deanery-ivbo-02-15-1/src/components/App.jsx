import React, { Component } from 'react';
import './App.css';
import 'bootstrap/dist/css/bootstrap.css';
import JournalTable from './JournalTable';
import DropDownMenu from './Dropdown';
import request from '../services/request';

class App extends Component {
  constructor() {
    super();
    this.state = {
      activeGroup: 0,
      students: null,
      groups: null
    };
  }

  componentDidMount() {
    request.getStudents().then((students) => {
      this.setState({ students: students });
    });

    request.getGroups().then((groups) => {
      this.setState({ groups: groups });
    });
  }

  render() {
    return (
      <div className='App'>
        {console.log(this.state.groups)}
        {console.log(this.state.students)}
        {this.state.groups ? <DropDownMenu groups={this.state.groups} /> : null}
        {this.state.students ? <JournalTable students={this.state.students} /> : null}
        <button
          onClick={() => {
            this.setState({ activeGroup: 0 });
          }}
        >
          Группа 1
        </button>
        <button
          onClick={() => {
            this.setState({ activeGroup: 1 });
          }}
        >
          Группа 2
        </button>
        <button
          onClick={() => {
            this.setState({ activeGroup: 2 });
          }}
        >
          Группа 3
        </button>
      </div>
    );
  }
}

export default App;
