import React, { Component } from 'react';
import { Table } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.css';
import DropDownMenu from './Dropdown';
import request from '../services/request';

class JournalTable extends Component {
    constructor() {
        super();
        this.state = {
          activeGroup: 0,
          groups: null
        };
      }

      componentDidMount() {
    
        request.getGroups().then((groups) => {
          this.setState({ groups: groups });
        });
      }

  render() {
    return (
      <Table bordered>
        <thead>
          <tr>
            <th>#</th>
            <th>Фамилия</th>
            <th>Имя</th>
            <th>Отчетсво</th>
            <th>Группа</th>
          </tr>
        </thead>
        <tbody>
          {this.props.students.map((student) => {
            return (
              <tr>
                <td>{student.id}</td>
                <td>{student.surname}</td>
                <td>{student.name}</td>
                <td>{student.second_name}</td>
                <td>
                {/*<DropDownMenu groups={this.props.groups} studentId={student.id} />*/}
                  {student.study_group_id}
                </td>
              </tr>
            );
          })}
        </tbody>
      </Table>
    );
  }
}

export default JournalTable;
