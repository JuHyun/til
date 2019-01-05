const body = document.querySelector('body');

const IMG_NUMBER = 4;

function init() {
    const randomNumber = generateNumber();
    painttmage(randomNumber);
}

function generateNumber() {
    return Math.floor(Math.random() * IMG_NUMBER) + 1;
}

function painttmage(number) {
    const image = new Image();
    image.src = `./images/${number}.jpg`
    image.classList.add('bgImg');
    body.prepend(image);

}

init();