var divPendingBody = document.querySelector(".div-body-view-pending")
var divResolvedBody = document.querySelector(".div-body-view-resolved")
var divViewOne = document.querySelector(".div-body-viewone-employee")
var divViewAll = document.querySelector(".div-body-viewall-employees")
var divOneSearchBar = document.querySelector(".div-one-search-bar")
var divOneResults = document.querySelector(".div-one-results")


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
                        pendingText = "Accepted"
                    }
                    else {
                        pendingText = "Rejected"
                    }
                    pendingText += "<br>"

                    pendingText += `<label>Type:</label> `
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
                    // APPROVE or...
                    pendingText += `
                        <form action="/Project1/reimbursements" method="POST">
                            <input type="text" name="id" value='${pendingData[i].reimb_id}' style="display: none;">
                            <input type="text" name="choice" value="2" style="display: none;">
                            <input type="text name="resolver" value="${userId}" style="display: none;">
                            
                            <input type="submit" name="accept" value="Approve"></input>
                        </form>
                    `


                    pendingText += `<br><br>`
                    // ... DENY
                    pendingText += `
                        <form action="/Project1/reimbursements" method="POST">
                            <input type="text" name="id" value="${pendingData[i].reimb_id}" style="display: none;">
                            <input type="text" name="choice" value="3" style="display: none;">
                            <input type="text name="resolver" value="${userId}" style="display: none;">
                            
                            <input type="submit" name="deny" value="Deny"></input>
                        </form>
                    `

                pendingText += "</div>"
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
            resolvedText += `<div class='div-card-resolved-${i}'>`
                resolvedText += "<div class='div-buffer-card-left'>"
                    resolvedText += "<label>Amount: $</label>" + resolvedData[i].reimb_amount
                    resolvedText += "<br>"
                    
                    resolvedText += "<label>Submitted:</label> " + resolvedData[i].reimb_submitted
                    resolvedText += "<br>"
                    
                    resolvedText += "<label>Resolved:</label> " + resolvedData[i].reimb_resolved
                    resolvedText += "<br>"
                    
                    resolvedText += "<label>Description:</label> " + resolvedData[i].reimb_description
                    resolvedText += "<br>"
                    
                    resolvedText += "<label>Receipt:</label> " + resolvedData[i].reimb_receipt
                    resolvedText += "<br>"
                    
                    resolvedText += "<label>Author:</label> " + resolvedData[i].reimb_author
                    resolvedText += "<br>"
                    
                    resolvedText += "<label>Resolver:</label> " + resolvedData[i].reimb_resolver
                    resolvedText += "<br>"
                    
                    resolvedText += "<label>Status:</label> "
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

                    resolvedText += `<label>Type:</label> `
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
            resolvedText += `</div>`
        }
        
        divResolvedBody.innerHTML = resolvedText
    }
}



async function getOneEmployee() {
    let text =  `
        <div class="div-card-emp">
            <div class='div-buffer-card-centered'>
                <label>User ID </label><br>
                <input type="text" class="emp-userId"></input><br><br>
                <input type="button" class="emp-search" value="Search"></input>
            </div>
        </div>
    `
    divOneSearchBar.innerHTML = text

    var searchBtn = document.querySelector(".emp-search")
    searchBtn.addEventListener("click", async () => {
        let userId = document.querySelector(".emp-userId").value
        
        let response = await fetch(apiURLreimbursement);
        if(response.status >= 200 && response.status < 300){
            let data = await response.json();
            let specificUserReimbs = []
    
            // filter the list/array so that only RESOLVED reimbersements are left
            for(var i = 0; i < data.length; i++) {
                if(data[i].reimb_author == userId && data[i].reimb_status_id != 1){
                    specificUserReimbs.push(data[i])
                }
            }

            let text = ``
            for(let i = 0; i < specificUserReimbs.length; i++) {
                text += `<div class='div-card-resolved-${i}'>`
                    text += `<div class='div-buffer-card-left'></div>`
                        text += "<label>Amount: $</label>" + specificUserReimbs[i].reimb_amount
                        text += "<br>"
                        
                        text += "<label>Submitted:</label> " + specificUserReimbs[i].reimb_submitted
                        text += "<br>"
                        
                        text += "<label>Resolved:</label> " + specificUserReimbs[i].reimb_resolved
                        text += "<br>"
                        
                        text += "<label>Description:</label> " + specificUserReimbs[i].reimb_description
                        text += "<br>"
                        
                        text += "<label>Receipt:</label> " + specificUserReimbs[i].reimb_receipt
                        text += "<br>"
                        
                        text += "<label>Author:</label> " + specificUserReimbs[i].reimb_author
                        text += "<br>"
                        
                        text += "<label>Resolver:</label> " + specificUserReimbs[i].reimb_resolver
                        text += "<br>"
                        
                        text += "<label>Status:</label> "
                        if(specificUserReimbs[i].reimb_status_id == 1) {
                            text += "Pending"
                        }
                        else if(specificUserReimbs[i].reimb_status_id == 2) {
                            text += "Accepted"
                        }
                        else {
                            text += "Rejected"
                        }
                        text += "<br>"

                        text += `<label>Type:</label> `
                        if(specificUserReimbs[i].reimb_type_id == 1){
                            text += "Lodging"
                        }
                        else if (specificUserReimbs[i].reimb_type_id == 2) {
                            text += "Travel"
                        }
                        else if (specificUserReimbs[i].reimb_type_id == 3) {
                            text += "Food"
                        }
                        else {
                            text += "Other"
                        }
                    text += `</div>`
                text += `</div>`
            }
            divOneResults.innerHTML = text
        }
    })
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
            text += `<div class='div-card-employee-${i}'>`
                text += `<div class='div-buffer-card-centered'>`
                    text += `<label>User Id:</label> ${emps[i].ers_user_id} <br>`
                    text += `<label>Username:</label> ${emps[i].ers_username} <br>`
                    text += `<label>First Name:</label> ${emps[i].user_first_name} <br>`
                    text += `<label>Last Name:</label> ${emps[i].user_last_name} <br>`
                    text += `<label>Email:</label> ${emps[i].user_email} <br>`
                text += `</div>`
            text += `</div>`
        }
    
        divViewAll.innerHTML = text
    }
}





document.addEventListener("DOMContentLoaded", () => {
    // call the functions to populate the page on dom content load
    getDataPending()
    getDataResolved()
    getOneEmployee()
    getDataAllEmployees()
})