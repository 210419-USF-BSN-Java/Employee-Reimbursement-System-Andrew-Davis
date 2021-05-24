var divPendingBody = document.querySelector(".div-body-view-pending")
var divResolvedBody = document.querySelector(".div-body-view-resolved")
var divViewOne = document.querySelector(".div-body-viewone-employee")
var divViewAll = document.querySelector(".div-body-viewall-employees")



// get the user id from the token and assign it globally for any route that may need it
var token = sessionStorage.getItem("token")
var tokenArr = []
tokenArr = token.split(":")
var userId = tokenArr[0]



var apiURLreimbursement = 'http://localhost:8080/Project1/reimbursement';

async function getDataPending() {
    let response = await fetch(apiURLreimbursement);

    if(response.status >= 200 && response.status < 300){
        let data = await response.json();
        let pendingData = []

        // filter the list/array so that only PENDING reimbersements are left
        for(var i = 0; i < data.length; i++) {
            if(data[i].reimb_status_id == 1){
                pendingData.push(data[i])
            }
        }
        
        let pendingText = ``

        for(var i = 0; i < pendingData.length; i++) {
            pendingText += `<div class='div-reimb-card-pending-${i}'>`
                pendingText += "Amount: " + pendingData[i].reimb_amount
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
                    pendingText = "Accepted"
                }
                else {
                    pendingText = "Rejected"
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

                pendingText += `<br><br>`
                // APPROVE or deny
                pendingText += `
                    <form action="/Project1/reimbursement/${data.reimb_id}" method="POST">
                        <input type="text" name="id" value="${data.reimb_id}" style="display: none;">
                        <input type="text" name="amount" value="${data.reimb_amount}" style="display: none;">
                        <input type="text" name="submitted" value="${data.reimb_submitted}" style="display: none;">
                        <input type="text" name="resolved" value="${data.reimb_resolved}" style="display: none;">
                        <input type="text" name="description" value="${data.reimb_description}" style="display: none;">
                        <input type="text" name="receipt" value="${data.reimb_receipt}" style="display: none;">
                        <input type="text" name="author" value="${data.reimb_author}" style="display: none;">
                        <input type="text" name="resolver" value="${userId}" style="display: none;">
                        <input type="text" name="status" value="2" style="display: none;">
                        <input type="text" name="type" value="${data.reimb_type_id}" style="display: none;">
                        
                        <input type="submit" name="accept" value="Approve"></input>
                    </form>
                `


                pendingText += `<br><br>`
                // approve or DENY
                pendingText += `
                    <form action="/Project1/reimbursement/${data.reimb_id}" method="POST">
                        <input type="text" name="id" value="${data.reimb_id}" style="display: none;">
                        <input type="text" name="amount" value="${data.reimb_amount}" style="display: none;">
                        <input type="text" name="submitted" value="${data.reimb_submitted}" style="display: none;">
                        <input type="text" name="resolved" value="${data.reimb_resolved}" style="display: none;">
                        <input type="text" name="description" value="${data.reimb_description}" style="display: none;">
                        <input type="text" name="receipt" value="${data.reimb_receipt}" style="display: none;">
                        <input type="text" name="author" value="${data.reimb_author}" style="display: none;">
                        <input type="text" name="resolver" value="${userId}" style="display: none;">
                        <input type="text" name="status" value="3" style="display: none;">
                        <input type="text" name="type" value="${data.reimb_type_id}" style="display: none;">
                        
                        <input type="submit" name="deny" value="Deny"></input>
                    </form>
                `


            pendingText += "</div>"
        }
        
        divPendingBody.innerHTML = pendingText
    }
}



async function getDataResolved() {
    let response = await fetch(apiURLreimbursement);

    if(response.status >= 200 && response.status < 300){
        let data = await response.json();
        let resolvedData = []

        // filter the list/array so that only RESOLVED reimbersements are left
        for(var i = 0; i < data.length; i++) {
            if(data[i].reimb_status_id != 1){
                resolvedData.push(data[i])
            }
        }
        // populateData(data)

        // IMPORTANT
        // you will need to filter out the reimbursements for only this one employee in the code here ...
        // ... above the rest of the logic
        let resolvedText = ``

        for(var i = 0; i < resolvedData.length; i++) {
            resolvedText += `<div class='div-reimb-card-pending-${i}'>`
                resolvedText += "Amount: " + resolvedData[i].reimb_amount
                resolvedText += "<br>"
                
                resolvedText += "Submitted: " + resolvedData[i].reimb_submitted
                resolvedText += "<br>"
                
                resolvedText += "Resolved: " + resolvedData[i].reimb_resolved
                resolvedText += "<br>"
                
                resolvedText += "Description: " + resolvedData[i].reimb_description
                resolvedText += "<br>"
                
                resolvedText += "Receipt: " + resolvedData[i].reimb_receipt
                resolvedText += "<br>"
                
                resolvedText += "Author: " + resolvedData[i].reimb_author
                resolvedText += "<br>"
                
                resolvedText += "Resolver: " + resolvedData[i].reimb_resolver
                resolvedText += "<br>"
                
                resolvedText += "Status: "
                if(resolvedData[i].reimb_status_id == 1) {
                    resolvedText += "Pending"
                }
                else if(resolvedData[i].reimb_status_id == 2) {
                    resolvedText += "Accepted"
                }
                else {
                    resolvedText += "Rejected"
                }
                resolvedText += "<br>"

                resolvedText += `Type: `
                if(resolvedData[i].reimb_type_id == 1){
                    resolvedText += "Lodging"
                }
                else if (resolvedData[i].reimb_type_id == 2) {
                    resolvedText += "Travel"
                }
                else if (resolvedData[i].reimb_type_id == 3) {
                    resolvedText += "Food"
                }
                else {
                    resolvedText += "Other"
                }
            resolvedText += `</div>`
        }
        
        divResolvedBody.innerHTML = resolvedText
    }
}



let apiURLemployees = 'http://localhost:8080/Project1/employees';
async function getDataAllEmployees() {
    let response = await fetch(apiURLemployees);

    

    if(response.status >= 200 && response.status < 300){
        let data = await response.json();
        let emps = []

        // filter the list/array so that only PENDING reimbersements are left
        for(var i = 0; i < data.length; i++) {
            if(data[i].user_role_id == 1){
                emps.push(data[i])
            }
        }

        let text = ``

        for(var i = 0; i < emps.length; i++) {
            text += `<div class=div-employee-info-${i}>`
                text += `User Id: ${emps[i].ers_user_id} <br>`
                text += `Username: ${emps[i].ers_username} <br>`
                text += `First Name: ${emps[i].user_first_name} <br>`
                text += `Last Name: ${emps[i].user_last_name} <br>`
                text += `Email: ${emps[i].user_email} <br>`
            text += `</div>`
        }
    
        divViewAll.innerHTML = text
    }
}

async function oneEmployee() {
    let text =  `
        <div class="div-search-emp">
            <label>Username: </label><br>
            <input type="text" class="emp-userId"></input><br><br>
            <input type="button" class="emp-search" value="Search"></input>
        </div>
    `
    divViewOne.innerHTML = text

    var searchBtn = document.querySelector(".emp-search")
    searchBtn.addEventListener("click", () => {
        let userId = document.querySelector(".emp-userId").value

        alert(userId)
    })
}


document.addEventListener("DOMContentLoaded", () => {
    // call the functions to populate the page on dom content load
    getDataPending()
    getDataResolved()
    oneEmployee()
    getDataAllEmployees()
})