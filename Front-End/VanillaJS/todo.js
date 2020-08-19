const dom_toDoform = document.querySelector(".js-todoform");
const dom_toDoInput = document.querySelector("#usertodo");
const dom_toDoList = document.querySelector(".js-todolist");

const TODO_LIST_LS = "toDoList";

const toDoArray = [];

localStorage.removeItem(TODO_LIST_LS);

function handlerSubmit(event){
    event.preventDefault();

    const curInput = dom_toDoInput.value;
    dom_toDoInput.value = "";
    
    const toDoObj = {
        id : toDoArray.length + 1,
        text : curInput
    };

    console.log(toDoObj);

    toDoArray.push(toDoObj);

    console.log(toDoArray);
    saveTodo();
}

function handlerDelete(event){

}

function paintToDo(){

    for(let i=0; i<toDoArray.length; i++)
    {
        const li = document.createElement("li");
        const delBtn = document.createElement("button");
        const span = document.createElement("span");

        delBtn.innerText = "X";

        span.innerText = toDoArray[i].text;

        li.appendChild(span);
        li.appendChild(delBtn);

        dom_toDoList.appendChild(li);
    }
}

function delToDo(target){
    localStorage.removeItem(TODO_LIST_LS);
    loadToDo()
}

function saveTodo(){
    localStorage.setItem(TODO_LIST_LS, toDoArray);
    loadToDo();
}

function loadToDo(){
    const list = localStorage.getItem(TODO_LIST_LS);

    if(list !== null){
        // exist todo
        for(let i=0; i<list.length; i++)
        {
            toDoArray.push({id:toDoArray.length+1, text:list[i].text});
        }

        paintToDo();
    }
    else{
        // do not exist todo
    }
}

function init(){
    loadToDo();

    dom_toDoform.addEventListener("submit", handlerSubmit);

}

init();