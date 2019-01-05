const todoForm = document.querySelector('.js-toDoForm'),
    todoInput = todoForm.querySelector('input'),
    todoList = document.querySelector('.js-toDoList');

const TODOS_LS = 'todos';
let TODOS = []

function init() {
    loadToDos();
}
function loadToDos() {
    const todos = localStorage.getItem(TODOS_LS);
    if (todos) {
        const parsedTodos = JSON.parse(todos);
        setTodos(parsedTodos);
        printTodos(parsedTodos);
    }
    askForTodo();
}

function setTodos(array) {
    array.forEach(function (element) {
        TODOS.push(element);
    });
}

function printTodos(array) {
    array.forEach(function (element) {
        printTodo(element);
    });
}

function printTodo(todo) {
    const childLi = document.createElement('li');
    const span = document.createElement('span');
    const deleteBtn = document.createElement('button');
    const id = todo.id || TODOS.length + 1;

    span.innerText = todo.value;
    deleteBtn.innerText = '❌';
    deleteBtn.classList.add('btn');

    childLi.id = id;
    childLi.appendChild(span);
    childLi.appendChild(deleteBtn);

    todoList.appendChild(childLi);

    deleteBtn.addEventListener('click', deleteTodo);
}

function askForTodo() {
    todoForm.addEventListener('submit', handleSubmit);
}

function handleSubmit(event) {
    event.preventDefault();
    const currentValue = todoInput.value;
    printTodo({value: currentValue});
    saveTodos(currentValue);
    earaseTodo();
}

init();

function saveTodos(value) {
    const todoObj = {
        id: TODOS.length + 1,
        value: value
    };
    TODOS.push(todoObj);
    saveTodosLS(TODOS);

    
}

function saveTodosLS(value) {
    localStorage.setItem(TODOS_LS, JSON.stringify(value));
}

function earaseTodo() {
    todoInput.value = '';
}

function deleteTodo(event) {
    event.preventDefault();
    const btn = event.target;
    const li = btn.parentNode;
    todoList.removeChild(li);
    const cleanTods = TODOS.filter(function (todo) {
        return todo.id !== parseInt(li.id);
    });

    TODOS = cleanTods;
    saveTodosLS(TODOS);
}