import React, { Component } from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import { Dropdown } from 'react-bootstrap';

class DropDownMenu extends Component {

  render() {
    return (
      <Dropdown>
        <Dropdown.Toggle variant='link' size='sm' />
        <Dropdown.Menu>
          <Dropdown.Header>Перевести в другую группу</Dropdown.Header>
          {this.props.groups.map((group, index) => (
            <Dropdown.Item
              key={index}
              onClick={() =>
                Request.transferStudent().then((groups) => {
                  alert(
                    'Перевод студента с id ' +
                      this.props.studentId +
                      ' в группу ' +
                      group.id +
                      ('ok' ? '' : ' не') +
                      ' произведён'
                  );
                })
              }
            >
              {group.name}
            </Dropdown.Item>
          ))}
        </Dropdown.Menu>
      </Dropdown>
    );
  }
}

export default DropDownMenu;
