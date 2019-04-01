const fetch = require('node-fetch');

let myOptions = {
  mode: 'no-cors',
  method: "GET"
};

//fetch("http://localhost:8080/students", myOptions).then(res => res.json);

/* 
fetch('http://localhost:8080/students', myOptions).then((res) => {
      res.status === 200 ? res.json().then((res) => {console.log(res[0])}) : console.log('fuck');
    });
*/

/*
fetch('http://localhost:8080/students', myOptions).then((res) => {
        res.json().then((res) => {
            console.log('Output: ', res[0]);
          })
          .catch((err) => console.error(err));
    });
*/

const Request = {
  getStudents() {
    return fetch('http://localhost:8080/students', myOptions).then((res) => {
      res.status === 200 
        ? res.json().then((res) => console.log('Output: ', res))
        : console.log('fuck ' + res.status);
    });
  }
};

export default Request;
