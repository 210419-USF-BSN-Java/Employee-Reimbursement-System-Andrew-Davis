var divBody = document.querySelector(".div-body")
var divSubmit = document.querySelector(".div-body-submit")
var divViewPending = document.querySelector(".div-body-view-pending")
var divViewResolved = document.querySelector(".div-body-view-resolved")
var divUploadReceipt = document.querySelector(".div-body-upload-receipt")
var divViewInfo = document.querySelector(".div-body-view-info")
var divUpdateInfo = document.querySelector(".div-body-update-info")



var windowHeight = window.innerHeight
var bodyHeight = windowHeight - 150

divSubmit = bodyHeight + "px"
divViewPending = bodyHeight + "px"
divViewResolved = bodyHeight + "px"
divUploadReceipt = bodyHeight + "px"
divViewInfo = bodyHeight + "px"
divUpdateInfo = bodyHeight + "px"
divBody.style.height = bodyHeight + "px"

divOptions.style.height = bodyHeight + "px"

window.addEventListener("resize", ()=>{
    windowHeight = window.innerHeight
    bodyHeight = windowHeight - 150

    divBody.style.height = bodyHeight + "px"
    divSubmit = bodyHeight + "px"
    divViewPending = bodyHeight + "px"
    divViewResolved = bodyHeight + "px"
    divUploadReceipt = bodyHeight + "px"
    divViewInfo = bodyHeight + "px"
    divUpdateInfo = bodyHeight + "px"
    divBody.style.height = bodyHeight + "px"

    divOptions.style.height = bodyHeight + "px"
})





// Code for manipulating the options menu
var divOptions = document.querySelector(".div-options")
var divOptionsBtn = document.querySelector(".div-button-options")

var optionState = false
divOptionsBtn.addEventListener("click", ()=>{
    if(!optionState) {
        divOptions.style.right = "0px"
        optionState = true
    } else {
        divOptions.style.right = "-250px"
        optionState = false
    }
})