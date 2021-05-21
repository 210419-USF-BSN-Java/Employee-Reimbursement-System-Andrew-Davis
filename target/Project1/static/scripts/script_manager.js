var divViewPendingOptions = document.querySelector(".p-man-view-pending")
var divViewResolvedOptions = document.querySelector(".p-man-view-resolved")
var divViewOneEmplOptions = document.querySelector(".p-man-viewone-employee")
var divViewAllEmplOptions = document.querySelector(".p-man-viewall-employees")
var divLogout = document.querySelector(".p-man-logout")
var pTitle = document.querySelector("p-title")



var divViewPending = document.querySelector(".div-body-view-pending")
var divViewResolved = document.querySelector(".div-body-view-resolved")
var divViewOneEmpl = document.querySelector(".div-body-viewone-employee")
var divViewAllEmpl = document.querySelector(".div-body-viewall-employees")


// Havd this one on top when the page loads
// divViewPending.style.zIndex = "2"
divViewPendingOptions.addEventListener("click", ()=>{
    divViewPending.style.zIndex = "2"
    divViewResolved.style.zIndex = "1"
    divViewOneEmpl.style.zIndex = "1"
    divViewAllEmpl.style.zIndex = "1"

    pTitle.innerHTML = "Pending"
})
divViewResolvedOptions.addEventListener("click", ()=>{
    divViewPending.style.zIndex = "1"
    divViewResolved.style.zIndex = "2"
    divViewOneEmpl.style.zIndex = "1"
    divViewAllEmpl.style.zIndex = "1"

    pTitle.innerHTML = "Resolved"
})
divViewOneEmplOptions.addEventListener("click", ()=>{
    divViewPending.style.zIndex = "1"
    divViewResolved.style.zIndex = "1"
    divViewOneEmpl.style.zIndex = "2"
    divViewAllEmpl.style.zIndex = "1"

    pTitle.innerHTML = "Employee"
})
divViewAllEmplOptions.addEventListener("click", ()=>{
    divViewPending.style.zIndex = "1"
    divViewResolved.style.zIndex = "1"
    divViewOneEmpl.style.zIndex = "1"
    divViewAllEmpl.style.zIndex = "2"

    pTitle.innerHTML = "View All"
})
