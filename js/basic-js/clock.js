const clockContainer = document.querySelector(".js-clock");
const clockTitle = clockContainer.querySelector("h1");

function init() {
    changeTime();
}

init();

function getTime() {
    const now = new Date();
    const hour = now.getHours();
    const minute = now.getMinutes();
    const second = now.getSeconds();
    clockTitle.innerText = `${zeroPadding(hour)} : ${zeroPadding(minute)} : ${zeroPadding(second)}`;
}

function changeTime() {
    const nIntervalId = setInterval(getTime, 1000);
}

function zeroPadding(number) {
    return number < 10 ? `0${number}` : number;
}
