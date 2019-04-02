let myOptions = {
  method: "GET"
};

const request = {
  getStudents() {
    return fetch('http://localhost:8080/students', myOptions).then((res) => 
      res.json());  
  },

  getGroups() {
    return fetch('http://localhost:8080/groups', myOptions).then((res) => 
      res.json());  
  }
};


// const request = {
//   getStudents() {
//     return fetch('http://localhost:8080/students', myOptions).then((res) => {
//       res.status === 200 
//         ? res.json().then((data) => data)
//         : console.log('fuck ' + res.status);
//     });
//   }
// };

export default request;
