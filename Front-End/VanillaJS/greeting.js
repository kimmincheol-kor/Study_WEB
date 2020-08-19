const dom_form = document.querySelector(".js-form");
const dom_username = document.querySelector("#username");
const dom_greeting = document.querySelector(".js-greeting");
const dom_logout = document.querySelector("#logout");

const USER_NAME_LS = "userName";
const HIDE_DOM = "hide";

function handlerLogout(event){
    localStorage.removeItem(USER_NAME_LS);
    askForName();
}

function handlerSubmit(event){
    event.preventDefault();

    const inputName = dom_username.value;
    console.log(inputName);

    dom_logout.classList.remove(HIDE_DOM);
    saveName(inputName);
}

//////////////////////////////////////////////////////////////////

function askForName(){
    dom_form.classList.remove(HIDE_DOM);

    dom_logout.classList.add(HIDE_DOM);
    dom_greeting.classList.add(HIDE_DOM);
}

function showGreeting(text){
    dom_form.classList.add(HIDE_DOM);

    dom_greeting.innerText = `Hello ${text}`;
    dom_greeting.classList.remove(HIDE_DOM);
}

///////////////////////////////////////////////////

function saveName(name){
    localStorage.setItem(USER_NAME_LS, name);
    loadName();
}

function loadName(){
    const cur_username = localStorage.getItem(USER_NAME_LS);

    if(cur_username === null){
        // no name
        askForName();
    }
    else{
        // exist name
        showGreeting(cur_username);
    }
}

function init(){
    loadName();
    dom_form.addEventListener("submit", handlerSubmit);
    dom_logout.addEventListener("click", handlerLogout);
}

init();