const title = document.querySelector("#title");

const CLICKED_CLASS = "clicked"

function handleColor() {
    // const hasClass = title.classList.contains(CLICKED_CLASS);
    // if (hasClass) {
    //     title.classList.remove(CLICKED_CLASS);
    // } else {
    //     title.classList.add(CLICKED_CLASS);
    // }
    // toggle은 위에 코드를 압축해서 작동시키는 기능을 함.
    title.classList.toggle(CLICKED_CLASS);
}

function init() {
    title.addEventListener('click', handleColor);
}

init();

