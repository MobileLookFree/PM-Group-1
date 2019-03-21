import React, { Component } from 'react';
import './App.css';
import 'bootstrap/dist/css/bootstrap.css';
import JournalTable from './JournalTable';
import Request from '../Services/Request';

/*
const students = [
  [
    { name: 'Иванов Иван Иванович', markPrIS: 5, markSII: 4 },
    { name: 'Петров Пётр Петрович', markPrIS: 3, markSII: 2 }
  ],
  [
    { name: 'Валиева Лидия Павловна', markPrIS: 3, markSII: 5 },
    { name: 'Илюшин Игорь Витальевич', markPrIS: 5, markSII: 5 }
  ],
  [
    { name: 'Голутвин Семён Юрьевич', markPrIS: 4, markSII: 2 },
    { name: 'Сёмина Анна Николаевна', markPrIS: 3, markSII: 5 }
  ]
];
*/

class App extends Component {
  constructor() {
    super();
    this.state = {
      activeGroup: 0,
      students: null
    };
  }

  componentDidMount() {
    Request.getStudents().then((students) => {
      this.setState({ students: students });
    });
  }

  render() {
    return (
      <div className='App'>
        {this.state.students ? (
          <JournalTable students={this.state.students[this.state.activeGroup]} />
        ) : null}
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
