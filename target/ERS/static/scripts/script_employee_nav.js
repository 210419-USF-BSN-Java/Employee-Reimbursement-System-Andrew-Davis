var divFrontOptions = document.querySelector(".p-emp-front")
var divSubmitOptions = document.querySelector(".p-emp-submit")
var divViewPendingOptions = document.querySelector(".p-emp-view-pending")
var divViewResolvedOptions = document.querySelector(".p-emp-view-resolved")
var divUploadReceiptOptions = document.querySelector(".p-emp-upload-receipt")
var divViewInfoOptions = document.querySelector(".p-emp-view-info")
var divUpdateInfoOptions = document.querySelector(".p-emp-update-info")
var divLogout = document.querySelector(".p-emp-logout")
var pTitle = document.querySelector(".h1-title")



var divFront = document.querySelector(".div-body-front")
var divSubmit = document.querySelector(".div-body-submit")
var divViewPending = document.querySelector(".div-body-view-pending")
var divViewResolved = document.querySelector(".div-body-view-resolved")
var divUploadReceipt = document.querySelector(".div-body-upload-receipt")
var divViewInfo = document.querySelector(".div-body-view-info")
var divUpdateInfo = document.querySelector(".div-body-update-info")



// zIndex functionality
// Have this one on top when the page loads
divFront.style.zIndex = "2"
pTitle.innerHTML = "Home"
divFrontOptions.addEventListener("click", ()=>{
    divFront.style.zIndex = "2"
    divSubmit.style.zIndex = "1"
    divViewPending.style.zIndex = "1"
    divViewResolved.style.zIndex = "1"
    divUploadReceipt.style.zIndex = "1"
    divViewInfo.style.zIndex = "1"
    divUpdateInfo.style.zIndex = "1"

    pTitle.innerHTML = "Home"
})
divSubmitOptions.addEventListener("click", ()=>{
    divFront.style.zIndex = "1"
    divSubmit.style.zIndex = "2"
    divViewPending.style.zIndex = "1"
    divViewResolved.style.zIndex = "1"
    divUploadReceipt.style.zIndex = "1"
    divViewInfo.style.zIndex = "1"
    divUpdateInfo.style.zIndex = "1"

    pTitle.innerHTML = "Submit"
})
divViewPendingOptions.addEventListener("click", ()=>{
    divFront.style.zIndex = "1"
    divSubmit.style.zIndex = "1"
    divViewPending.style.zIndex = "2"
    divViewResolved.style.zIndex = "1"
    divUploadReceipt.style.zIndex = "1"
    divViewInfo.style.zIndex = "1"
    divUpdateInfo.style.zIndex = "1"

    pTitle.innerHTML = "Pending"
})
divViewResolvedOptions.addEventListener("click", ()=>{
    divFront.style.zIndex = "1"
    divSubmit.style.zIndex = "1"
    divViewPending.style.zIndex = "1"
    divViewResolved.style.zIndex = "2"
    divUploadReceipt.style.zIndex = "1"
    divViewInfo.style.zIndex = "1"
    divUpdateInfo.style.zIndex = "1"

    pTitle.innerHTML = "Resolved"
})
divUploadReceiptOptions.addEventListener("click", ()=>{
    divFront.style.zIndex = "1"
    divSubmit.style.zIndex = "1"
    divViewPending.style.zIndex = "1"
    divViewResolved.style.zIndex = "1"
    divUploadReceipt.style.zIndex = "2"
    divViewInfo.style.zIndex = "1"
    divUpdateInfo.style.zIndex = "1"

    pTitle.innerHTML = "Upload"
})
divViewInfoOptions.addEventListener("click", ()=>{
    divFront.style.zIndex = "1"
    divSubmit.style.zIndex = "1"
    divViewPending.style.zIndex = "1"
    divViewResolved.style.zIndex = "1"
    divUploadReceipt.style.zIndex = "1"
    divViewInfo.style.zIndex = "2"
    divUpdateInfo.style.zIndex = "1"

    pTitle.innerHTML = "View"
})
divUpdateInfoOptions.addEventListener("click", ()=>{
    divFront.style.zIndex = "1"
    divSubmit.style.zIndex = "1"
    divViewPending.style.zIndex = "1"
    divViewResolved.style.zIndex = "1"
    divUploadReceipt.style.zIndex = "1"
    divViewInfo.style.zIndex = "1"
    divUpdateInfo.style.zIndex = "2"

    pTitle.innerHTML = "Update"
})



// logout functionality
divLogout.addEventListener("click", ()=>{
    sessionStorage.removeItem('token');

    window.location.href="http://localhost:8080/Project1/"
})