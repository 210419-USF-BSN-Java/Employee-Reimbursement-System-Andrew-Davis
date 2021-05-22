var divSubmitBody = document.querySelector(".div-body-submit")
var divPendingBody = document.querySelector(".div-body-view-pending")
var divResolvedBody = document.querySelector(".div-body-view-resolved")
var divUploadBody = document.querySelector(".div-body-upload-receipt")
var divViewBody = document.querySelector(".div-body-view-info")
var divUpdateBody = document.querySelector(".div-body-update-info")



let apiURL = 'http://localhost:8080/Project1/reimbursement';



async function getDataPending(){
    let response = await fetch(apiURL);

    if(response.status >= 200 && response.status < 300){
        let data = await response.json();
        let pendingData = []

        // filter the list/array so that only PENDING reimbersements are left
        for(var i = 0; i < data.length; i++) {
            if(data[i].reimb_status_id == 1){
                pendingData.push(data[i])
            }
        }
        // populateData(data)

        // IMPORTANT
        // you will need to filter out the reimbursements for only this one employee in the code here ...
        // ... above the rest of the logic
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
            pendingText += "</div>"
        }
        
        divPendingBody.innerHTML = pendingText
    }
}


async function getDataResolved(){
    let response = await fetch(apiURL);

    if(response.status >= 200 && response.status < 300){
        let data = await response.json();
        let resolvedData = []

        // filter the list/array so that only RESOLVED reimbersements are left
        for(var i = 0; i < data.length; i++) {
            if(data[i].reimb_status_id == 2 || data[i].reimb_status_id == 3) {
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
            text += `<div class='div-reimb-card-resolved-${i}'>`
                text += "Amount: " + resolvedData[i].reimb_amount
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



/*
function populateData(response){
    
    //Use DOM Manipulation to write the data into our HTML page in the section tag.
    
    console.log(response);

    let dataSection = document.getElementById('data');
   
    // Resets the innerHTML before loading new data
    dataSection.innerHTML ='';

    let nameTag = document.createElement('h3');
    nameTag.innerHTML = response.name.toUpperCase();
   
    let abilitiesArray = response.abilities;
    let abilities = document.createElement('ul');
    // Appending list elements to a ul
    for(let ability of abilitiesArray){
        let abilityLi = document.createElement('li');
        abilityLi.innerHTML = ability.ability.name;
        abilities.appendChild(abilityLi);
    }

    // Appending h3 and List to the section tag
    dataSection.appendChild(nameTag);
    dataSection.appendChild(abilities);

    // Appending sprites to section
    let spritesObject = response.sprites;
    for(let sprite in spritesObject){
        if(spritesObject[sprite] && spritesObject[sprite].length > 2){
            let spriteImg = document.createElement('img');
            spriteImg.src = spritesObject[sprite];
            dataSection.appendChild(spriteImg);
        }
    }
}
*/


document.addEventListener("DOMContentLoaded", () => {
    // Call the functions to populate the page on dom content load
    getDataPending()
    getDataResolved()
    
})