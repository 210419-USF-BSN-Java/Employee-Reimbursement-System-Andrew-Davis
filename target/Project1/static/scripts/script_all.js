var divBody = document.querySelector(".div-body")
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

divBody.style.height = bodyHeight + "px"
divOptions.style.height = bodyHeight + "px"

window.addEventListener("resize", ()=>{
    windowHeight = window.innerHeight
    bodyHeight = windowHeight - 150

    divBody.style.height = bodyHeight + "px"
    divOptions.style.height = bodyHeight + "px"
})