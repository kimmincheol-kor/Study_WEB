const dom_body = document.querySelector("body");

let randNum;

const NUM_IMAGES = 3;

function paintImage(){
    const image = new Image();

    image.src = `./img/${getRandom() + 1}.jpg`;
    image.classList.add("bgImage");

    dom_body.prepend(image);
}

function getRandom(){
    const rn = Math.random()*NUM_IMAGES;
    return Math.floor(rn);
}

function init(){
    paintImage();
}

init();