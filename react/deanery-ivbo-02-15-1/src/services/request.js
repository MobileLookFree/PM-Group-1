const Request = {
    getStudents() {
    	return fetch("http://up-lab2.mirea.ru/student/all").then(res => res.json);
    }
};

export default Request;
