const Request = {
    getStudents() {
    	return fetch("http://localhost:8080/mark/1").then(res => res.json);
    }
};

export default Request
