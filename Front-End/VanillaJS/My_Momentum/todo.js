const dom_toDoform = document.querySelector(".js-todoform");
const dom_toDoInput = document.querySelector("#usertodo");
const dom_toDoList = document.querySelector(".js-todolist");

const TODO_LIST_LS = "toDoList";

var toDoArray = [];

function handlerSubmit(event){
    event.preventDefault();

    const curInput = dom_toDoInput.value;
    dom_toDoInput.value = "";
    
    toDoArray.push({id : toDoArray.length + 1, text : curInput});

    saveTodo();
}

function handlerDelete(event){
    const btn = event.target;
    const target_li = btn.parentNode;

    toDoArray = toDoArray.filter(function(todo) {
        if(todo.id > target_li.id)
        {
            todo.id -= 1;
            return true;
        }

        return todo.id != target_li.id;
    });
    console.log(toDoArray);

    saveTodo();
}

function paintToDo(){
    while (dom_toDoList.firstChild) {
        dom_toDoList.removeChild(dom_toDoList.firstChild);
    }

    for(let i=0; i<toDoArray.length; i++)
    {
        const li = document.createElement("li");
        const delBtn = document.createElement("button");
        const span = document.createElement("span");

        delBtn.addEventListener("click", handlerDelete);

        delBtn.innerText = "X";

        span.innerText = toDoArray[i].text;

        li.appendChild(span);
        li.appendChild(delBtn);
        li.id = i+1;

        dom_toDoList.appendChild(li);
    }
}

function delToDo(target){
    localStorage.removeItem(TODO_LIST_LS);
    loadToDo()
}

function saveTodo(){
    localStorage.setItem(TODO_LIST_LS, JSON.stringify(toDoArray));
    loadToDo();
}

function loadToDo(){
    const list = JSON.parse(localStorage.getItem(TODO_LIST_LS));

    if(list !== null){
        // exist todo
        toDoArray = [];

        for(let i=0; i<list.length; i++)
        {
            toDoArray.push({id:list[i].id, text:list[i].text});
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