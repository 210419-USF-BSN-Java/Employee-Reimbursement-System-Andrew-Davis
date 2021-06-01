document.getElementById("input-login").addEventListener("click", requestLogin);

function requestLogin() {
	let user = document.querySelector(".input-username").value;
	let pass = document.querySelector(".input-password").value;
	
	let xhr = new XMLHttpRequest();
	let url = "http://localhost:8080/ers/login";
	xhr.open("POST", url);
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			let auth = xhr.getResponseHeader("Authorization");
			/*
				session is a storage that lasts for that specific page session(tab)
				here we store our auth token
			*/
			sessionStorage.setItem("token", auth);
			/*
				if the login is successful, redirects to the home page
			*/
            // You will need to differentiate between and employee and manager
			let sessionVariable = sessionStorage.getItem("token");
			let tokenArr = []
			tokenArr = sessionVariable.split(":");

			if(tokenArr[1] == "Employee") {
				window.location.href="http://localhost:8080/ers/employee"
			}
			else if(tokenArr[1] == "Manager") {
				window.location.href="http://localhost:8080/ers/manager"
			}
		} 
		else if (xhr.readyState == 4){
			document.getElementById('message').innerHTML='Incorrect credentials!';
		}
	}
	
	/*
		Allows us to send form data as a single block in the body rather than as query params in the URL
	*/
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	let requestBody = `username=${user}&password=${pass}`;
	xhr.send(requestBody);
}