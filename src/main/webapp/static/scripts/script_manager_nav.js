var divFrontOptions = document.querySelector(".p-man-front")
var divViewPendingOptions = document.querySelector(".p-man-view-pending")
var divViewResolvedOptions = document.querySelector(".p-man-view-resolved")
var divViewOneEmplOptions = document.querySelector(".p-man-viewone-employee")
var divViewAllEmplOptions = document.querySelector(".p-man-viewall-employees")
var divLogout = document.querySelector(".p-man-logout")
var pTitle = document.querySelector(".h1-title")



var divFront = document.querySelector(".div-body-front")
var divViewPending = document.querySelector(".div-body-view-pending")
var divViewResolved = document.querySelector(".div-body-view-resolved")
var divViewOneEmpl = document.querySelector(".div-body-viewone-employee")
var divViewAllEmpl = document.querySelector(".div-body-viewall-employees")



// Havd this one on top when the page loads
divFront.style.zIndex = "2"
pTitle.innerHTML = "Home"
divFrontOptions.addEventListener("click", ()=>{
    divFront.style.zIndex = "2"
    divViewPending.style.zIndex = "1"
    divViewResolved.style.zIndex = "1"
    divViewOneEmpl.style.zIndex = "1"
    divViewAllEmpl.style.zIndex = "1"

    pTitle.innerHTML = "Home"
})
divViewPendingOptions.addEventListener("click", ()=>{
    divFront.style.zIndex = "1"
    divViewPending.style.zIndex = "2"
    divViewResolved.style.zIndex = "1"
    divViewOneEmpl.style.zIndex = "1"
    divViewAllEmpl.style.zIndex = "1"

    pTitle.innerHTML = "Pending"
})
divViewResolvedOptions.addEventListener("click", ()=>{
    divFront.style.zIndex = "1"
    divViewPending.style.zIndex = "1"
    divViewResolved.style.zIndex = "2"
    divViewOneEmpl.style.zIndex = "1"
    divViewAllEmpl.style.zIndex = "1"

    pTitle.innerHTML = "Resolved"
})
divViewOneEmplOptions.addEventListener("click", ()=>{
    divFront.style.zIndex = "1"
    divViewPending.style.zIndex = "1"
    divViewResolved.style.zIndex = "1"
    divViewOneEmpl.style.zIndex = "2"
    divViewAllEmpl.style.zIndex = "1"

    pTitle.innerHTML = "Employee"
})
divViewAllEmplOptions.addEventListener("click", ()=>{
    divFront.style.zIndex = "1"
    divViewPending.style.zIndex = "1"
    divViewResolved.style.zIndex = "1"
    divViewOneEmpl.style.zIndex = "1"
    divViewAllEmpl.style.zIndex = "2"

    pTitle.innerHTML = "Employees"
})



// logout functionality
divLogout.addEventListener("click", ()=>{
    sessionStorage.removeItem('token');
    
    window.location.href="http://localhost:8080/Project1/"
})
