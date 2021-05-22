var divBody = document.querySelector(".div-body")
var divSubmit = document.querySelector(".div-body-submit")
var divViewPending = document.querySelector(".div-body-view-pending")
var divViewResolved = document.querySelector(".div-body-view-resolved")
var divUploadReceipt = document.querySelector(".div-body-upload-receipt")
var divViewInfo = document.querySelector(".div-body-view-info")
var divUpdateInfo = document.querySelector(".div-body-update-info")



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



var windowHeight = window.innerHeight
var bodyHeight = windowHeight - 150

// divSubmit.style.height = bodyHeight + "px"
// divViewPending.style.height = bodyHeight + "px"
// divViewResolved.style.height = bodyHeight + "px"
// divUploadReceipt.style.height = bodyHeight + "px"
// divViewInfo.style.height = bodyHeight + "px"
// divUpdateInfo.style.height = bodyHeight + "px"
divBody.style.height = bodyHeight + "px"

divOptions.style.height = bodyHeight + "px"

// window.addEventListener("resize", ()=>{
//     windowHeight = window.innerHeight
//     bodyHeight = windowHeight - 150

//     divBody.style.height = bodyHeight + "px"
//     // divSubmit.style.height = bodyHeight + "px"
//     // divViewPending.style.height = bodyHeight + "px"
//     // divViewResolved.style.height = bodyHeight + "px"
//     // divUploadReceipt.style.height = bodyHeight + "px"
//     // divViewInfo.style.height = bodyHeight + "px"
//     // divUpdateInfo.style.height = bodyHeight + "px"

//     divOptions.style.height = bodyHeight + "px"
// })