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
                pendingText += "Amount: $" + pendingData[i].reimb_amount
                pendingText += "<br>"
                
                pendingText += "Submitted: " + pendingData[i].reimb_submitted
                pendingText += "<br>"
                
                pendingText += "Resolved: " + pendingData[i].reimb_resolved
                pendingText += "<br>"
                
                pendingText += "Description: " + pendingData[i].reimb_description
                pendingText += "<br>"
                
                pendingText += "Receipt: " + pendingData[i].reimb_receipt
                pendingText += "<br>"
                
                pendingText += "Author: " + pendingData[i].reimb_author
                pendingText += "<br>"
                
                pendingText += "Resolver: " + pendingData[i].reimb_resolver
                pendingText += "<br>"
                
                pendingText += "Status: "
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

                pendingText += `Type: `
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
                text += "Amount: $" + resolvedData[i].reimb_amount
                text += "<br>"
                
                text += "Submitted: " + resolvedData[i].reimb_submitted
                text += "<br>"
                
                text += "Resolved: " + resolvedData[i].reimb_resolved
                text += "<br>"
                
                text += "Description: " + resolvedData[i].reimb_description
                text += "<br>"
                
                text += "Receipt: " + resolvedData[i].reimb_receipt
                text += "<br>"
                
                text += "Author: " + resolvedData[i].reimb_author
                text += "<br>"
                
                text += "Resolver: " + resolvedData[i].reimb_resolver
                text += "<br>"
                
                text += "Status: "
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

                text += `Type: `
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
            text += `User Id: ${data.ers_user_id} <br>`
            text += `Username: ${data.ers_username} <br>`
            text += `First Name: ${data.user_first_name} <br>`
            text += `Last Name: ${data.user_last_name} <br>`
            text += `Email: ${data.user_email} <br>`
        text += `</div>`

        divViewBody.innerHTML = text



        // for the update info section
        text = `
            <div class="div-card-update-info">
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
        `

        divUpdateBody.innerHTML = text
    }
    else {
        alert("Nothing found")
    }
}


async function setDataSubmit() {
    let text = `
            <div class="div-card-update-info">
                <form class="form-submit" action="/Project1/reimbursement" method="POST">
                    <input type="number" class="form-sumbit-id" name="id" value="${userId}" style="display: none;"></input>
                    
                    <label>Amount</label><br>
                    <input type="text" class="form-submit-amount" name="amount" value=""></input><br><br>
                    
                    <label>Description</label><br>
                    <input type="text" class="form-submit-description" name="description" value=""></input><br><br>
                    
                    <label>Receipt</label><br>
                    <input type="text" class="form-submit-receipt" name="receipt" value=""></input><br><br>
                    
                    <label>Type<br>(Lodging: 1, Travel: 2, Food: 3, Other: 4)</label><br>
                    <input type="number" class="form-submit-type" name="type" value=""></input><br><br>

                    <input type="submit" class="form-update-info-submit" name="submit" value="Submit"></input>
                </form>
            </div>
        `
     divSubmitBody.innerHTML = text
}



document.addEventListener("DOMContentLoaded", () => {
    // call the functions to populate the page on dom content load
    setDataSubmit()
    getDataPending()
    getDataResolved()
    getDataInfo()
})