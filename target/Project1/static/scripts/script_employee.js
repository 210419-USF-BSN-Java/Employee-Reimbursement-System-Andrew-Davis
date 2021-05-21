var divSubmitOptions = document.querySelector(".p-emp-submit")
var divViewPendingOptions = document.querySelector(".p-emp-view-pending")
var divViewResolvedOptions = document.querySelector(".p-emp-view-resolved")
var divUploadReceiptOptions = document.querySelector(".p-emp-upload-receipt")
var divViewInfoOptions = document.querySelector(".p-emp-view-info")
var divUpdateInfoOptions = document.querySelector(".p-emp-update-info")
var divLogout = document.querySelector(".p-emp-logout")
var pTitle = document.querySelector(".h1-title")



var divSubmit = document.querySelector(".div-body-submit")
var divViewPending = document.querySelector(".div-body-view-pending")
var divViewResolved = document.querySelector(".div-body-view-resolved")
var divUploadReceipt = document.querySelector(".div-body-upload-receipt")
var divViewInfo = document.querySelector(".div-body-view-info")
var divUpdateInfo = document.querySelector(".div-body-update-info")



// Havd this one on top when the page loads
divSubmit.style.zIndex = "2"
divSubmitOptions.addEventListener("click", ()=>{
    divSubmit.style.zIndex = "2"
    divViewPending.style.zIndex = "1"
    divViewResolved.style.zIndex = "1"
    divUploadReceipt.style.zIndex = "1"
    divViewInfo.style.zIndex = "1"
    divUpdateInfo.style.zIndex = "1"

    pTitle.innerHTML = "Submit"
})
divViewPendingOptions.addEventListener("click", ()=>{
    divSubmit.style.zIndex = "1"
    divViewPending.style.zIndex = "2"
    divViewResolved.style.zIndex = "1"
    divUploadReceipt.style.zIndex = "1"
    divViewInfo.style.zIndex = "1"
    divUpdateInfo.style.zIndex = "1"

    pTitle.innerHTML = "Pending"
})
divViewResolvedOptions.addEventListener("click", ()=>{
    divSubmit.style.zIndex = "1"
    divViewPending.style.zIndex = "1"
    divViewResolved.style.zIndex = "2"
    divUploadReceipt.style.zIndex = "1"
    divViewInfo.style.zIndex = "1"
    divUpdateInfo.style.zIndex = "1"

    pTitle.innerHTML = "Resolved"
})
divUploadReceiptOptions.addEventListener("click", ()=>{
    divSubmit.style.zIndex = "1"
    divViewPending.style.zIndex = "1"
    divViewResolved.style.zIndex = "1"
    divUploadReceipt.style.zIndex = "2"
    divViewInfo.style.zIndex = "1"
    divUpdateInfo.style.zIndex = "1"

    pTitle.innerHTML = "Upload"
})
divViewInfoOptions.addEventListener("click", ()=>{
    divSubmit.style.zIndex = "1"
    divViewPending.style.zIndex = "1"
    divViewResolved.style.zIndex = "1"
    divUploadReceipt.style.zIndex = "1"
    divViewInfo.style.zIndex = "2"
    divUpdateInfo.style.zIndex = "1"

    pTitle.innerHTML = "View Info"
})
divUpdateInfoOptions.addEventListener("click", ()=>{
    divSubmit.style.zIndex = "1"
    divViewPending.style.zIndex = "1"
    divViewResolved.style.zIndex = "1"
    divUploadReceipt.style.zIndex = "1"
    divViewInfo.style.zIndex = "1"
    divUpdateInfo.style.zIndex = "2"

    pTitle.innerHTML = "Update Info"
})