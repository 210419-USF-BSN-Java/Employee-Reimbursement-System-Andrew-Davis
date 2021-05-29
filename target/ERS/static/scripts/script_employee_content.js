var divSubmitBody = document.querySelector(".div-body-submit")
var divPendingBody = document.querySelector(".div-body-view-pending")
var divResolvedBody = document.querySelector(".div-body-view-resolved")
var divUploadBody = document.querySelector(".div-body-upload-receipt")
var divViewBody = document.querySelector(".div-body-view-info")
var divUpdateBody = document.querySelector(".div-body-update-info")



// get the user id from the token and assign it globally for any route that may need it
var token = sessionStorage.getItem("token")
var tokenArr = []
tokenArr = token.split(":")
var userId = tokenArr[0]



async function setDataSubmit() {
    let text = `
            <div class="div-card-update-info">
                <div class='div-buffer-card-centered'>
                    <form class="form-submit" action="/Project1/reimbursement" method="POST">
                        <input type="number" class="form-sumbit-id" name="id" value="${userId}" style="display: none;"></input>
                        
                        <label>Amount</label><br>
                        <input type="text" class="form-submit-amount" name="amount" value=""></input><br><br>
                        
                        <label>Description</label><br>
                        <input type="text" class="form-submit-description" name="description" value=""></input><br><br>
                        
                        <label>Receipt</label><br>
                        <input type="text" class="form-submit-receipt" name="receipt" value=""></input><br><br>
                        
                        <label>Type<br>(Lodging: 1, Travel: 2, Food: 3, Other: 4)</label><br>
                        <input type="number" min=1 max=4 maxclass="form-submit-type" name="type" value=""></input><br><br>

                        <input class="form-submit-reimb" type="submit"  name="submit" value="Submit"></input>
                    </form>
                </div>
            </div>
        `
     divSubmitBody.innerHTML = text
}



let apiURLreimbursement = 'http://localhost:8080/Project1/reimbursement';
async function getDataPending(){
    let response = await fetch(apiURLreimbursement);

    if(response.status >= 200 && response.status < 300){
        let data = await response.json();
        let pendingData = []

        // filter the list/array so that only PENDING reimbersements are left
        for(var i = 0; i < data.length; i++) {
            if(data[i].reimb_status_id == 1 && data[i].reimb_author == userId){
                pendingData.push(data[i])
            }
        }
        // populateData(data)

        // IMPORTANT
        // you will need to filter out the reimbursements for only this one employee in the code here ...
        // ... above the rest of the logic
        let pendingText = ``

        for(var i = 0; i < pendingData.length; i++) {
            pendingText += `<div class='div-card-pending-${i}'>`
                pendingText += "<div class='div-buffer-card-left'>"
                    pendingText += "<label>Amount: $</label>" + pendingData[i].reimb_amount
                    pendingText += "<br>"
                    
                    pendingText += "<label>Submitted:</label> " + pendingData[i].reimb_submitted
                    pendingText += "<br>"
                    
                    pendingText += "<label>Resolved:</label> " + pendingData[i].reimb_resolved
                    pendingText += "<br>"
                    
                    pendingText += "<label>Description:</label> " + pendingData[i].reimb_description
                    pendingText += "<br>"
                    
                    pendingText += "<label>Receipt:</label> " + pendingData[i].reimb_receipt
                    pendingText += "<br>"
                    
                    pendingText += "<label>Author:</label> " + pendingData[i].reimb_author
                    pendingText += "<br>"
                    
                    pendingText += "<label>Resolver:</label> " + pendingData[i].reimb_resolver
                    pendingText += "<br>"
                    
                    pendingText += "<label>Status:</label> "
                    if(pendingData[i].reimb_status_id == 1) {
                        pendingText += "Pending"
                    }
                    else if(pendingData[i].reimb_status_id == 2) {
                        pendingText += "Accepted"
                    }
                    else {
                        pendingText += "Rejected"
                    }
                    pendingText += "<br>"

                    pendingText += `<label>Type: </label>`
                    if(pendingData[i].reimb_type_id == 1){
                        pendingText += "Lodging"
                    }
                    else if (pendingData[i].reimb_type_id == 2) {
                        pendingText += "Travel"
                    }
                    else if (pendingData[i].reimb_type_id == 3) {
                        pendingText += "Food"
                    }
                    else {
                        pendingText += "Other"
                    }

                pendingText += "</div>"
            pendingText += "</div>"
        }
        
        divPendingBody.innerHTML = pendingText
    }
}



async function getDataResolved(){
    let response = await fetch(apiURLreimbursement);

    if(response.status >= 200 && response.status < 300){
        let data = await response.json();
        let resolvedData = []

        // filter the list/array so that only RESOLVED reimbersements are left
        for(var i = 0; i < data.length; i++) {
            if((data[i].reimb_status_id == 2 || data[i].reimb_status_id == 3) && data[i].reimb_author == userId) {
                resolvedData.push(data[i])
            }
        }
        // populateData(data)
        //alert(finalData.length)

        // IMPORTANT
        // you will need to filter out the reimbursements for only this one employee in the code here ...
        // ... above the rest of the logic
        let text = ``

        for(var i = 0; i < resolvedData.length; i++) {
            text += `<div class='div-card-resolved-${i}'>`
                text += "<div class='div-buffer-card-left'>"
                    text += "<label>Amount: $</label> " + resolvedData[i].reimb_amount
                    text += "<br>"
                    
                    text += "<label>Submitted:</label> " + resolvedData[i].reimb_submitted
                    text += "<br>"
                    
                    text += "<label>Resolved:</label> " + resolvedData[i].reimb_resolved
                    text += "<br>"
                    
                    text += "<label>Description:</label> " + resolvedData[i].reimb_description
                    text += "<br>"
                    
                    text += "<label>Receipt:</label> " + resolvedData[i].reimb_receipt
                    text += "<br>"
                    
                    text += "<label>Author:</label> " + resolvedData[i].reimb_author
                    text += "<br>"
                    
                    text += "<label>Resolver:</label> " + resolvedData[i].reimb_resolver
                    text += "<br>"
                    
                    text += "<label>Status:</label> "
                    if(resolvedData[i].reimb_status_id == 1) {
                        text += "Pending"
                    }
                    else if(resolvedData[i].reimb_status_id == 2) {
                        text += "Accepted"
                    }
                    else {
                        text += "Rejected"
                    }
                    text += "<br>"

                    text += `<label>Type:</label> `
                    if(resolvedData[i].reimb_type_id == 1){
                        text += "Lodging"
                    }
                    else if (resolvedData[i].reimb_type_id == 2) {
                        text += "Travel"
                    }
                    else if (resolvedData[i].reimb_type_id == 3) {
                        text += "Food"
                    }
                    else {
                        text += "Other"
                    }
                text += "</div>"
            text += "</div>"
        }
        
        divResolvedBody.innerHTML = text
    }
}



var apiURLuser = `http://localhost:8080/Project1/user/${userId}`;
async function getDataInfo() {
    let response = await fetch(apiURLuser);
    if(response.status >= 200 && response.status < 300){
        let data = await response.json();

        // for the view data section
        let text = ``
        text += `<div class="div-card-view-info">`
            text += "<div class='div-buffer-card-centered'>"
                text += `<label>User Id:</label> ${data.ers_user_id} <br>`
                text += `<label>Username:</label> ${data.ers_username} <br>`
                text += `<label>First Name:</label> ${data.user_first_name} <br>`
                text += `<label>Last Name:</label> ${data.user_last_name} <br>`
                text += `<label>Email:</label> ${data.user_email} <br>`
            text += `</div>`
        text += `</div>`

        divViewBody.innerHTML = text



        // for the update info section
        text = `
            <div class="div-card-update-info">
                <div class='div-buffer-card-centered'>
                    <form class="form-update-info" action="/Project1/user/${userId}" method="POST">
                        <label>Username</label><br>
                        <input type="text" class="form-update-info-username" name="username" value="${data.ers_username}"></input><br><br>
                        
                        <label>Password</label><br>
                        <input type="text" class="form-update-info-password" name="password" value=""></input><br><br>
                        
                        <label>First Name</label><br>
                        <input type="text" class="form-update-info-firstname" name="firstname" value="${data.user_first_name}"></input><br><br>
                        
                        <label>Last Name</label><br>
                        <input type="text" class="form-update-info-lastname" name="lastname" value="${data.user_last_name}"></input><br><br>
                        
                        <label>Email</label><br>
                        <input type="text" class="form-update-info-email" name="email" value="${data.user_email}"></input><br><br><br>
                        
                        <input type="number" class="form-update-info-hidden-role" name="role" value="${data.user_role_id}" style="display: none;"></input>

                        <input type="submit" class="form-update-info-submit" name="submit" value="Update"></input>
                    </form>
                </div>
            </div>
        `

        divUpdateBody.innerHTML = text
    }
    else {
        alert("Nothing found")
    }
}





document.addEventListener("DOMContentLoaded", () => {
    // call the functions to populate the page on dom content load
    setDataSubmit()
    getDataPending()
    getDataResolved()
    getDataInfo()
})