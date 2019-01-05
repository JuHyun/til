const form = document.querySelector('.js-form'),
      input = form.querySelector('input'),
      greetings = document.querySelector('.js-greetings');

const USER_LS = 'currentUser',
      SHOW_CL = 'show';

function init() {
    loadName();
}

function loadName() {
    const myName = localStorage.getItem(USER_LS);
    if (myName) {
        printGreeting(myName);
    } else {
        askForName();
    }
}

function printGreeting(text) {
    greetings.innerText = `Hello, ${text}`;
    form.classList.remove(SHOW_CL);
    greetings.classList.add(SHOW_CL);
}

function askForName() {
    form.classList.add(SHOW_CL);
    form.addEventListener('submit', handleSubmit);
}

function handleSubmit(event) {
    event.preventDefault();
    const currentValue = input.value;
    printGreeting(currentValue);
    saveMyName(currentValue);
}

function saveMyName(value) {
    localStorage.setItem(USER_LS, value);
}

init();