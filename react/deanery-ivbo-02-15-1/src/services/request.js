const Request = {
    getStudents() {
    	return fetch("http://localhost:8080/students").then(res => res.json);
    }
};

export default Request;
