const clockContainer = document.querySelector(".js-clock");
const clockTitle = document.querySelector(".js-clock-title");


function updateTime(){
    const date = new Date();
    
    const time = [date.getHours(), date.getMinutes(), date.getSeconds()];

    for(var i=0; i<3; i++)
        time[i] = time[i] < 10 ? `0${time[i]}` : time[i];

    clockTitle.innerText = `${time[0]}:${time[1]}:${time[2]}`;
}

function init() {
    updateTime();
    setInterval(updateTime, 1000);
}

init();