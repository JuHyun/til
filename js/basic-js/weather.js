const CODRDS = 'coords';
const OPEN_WEATHER_API_KEY = '57e159d1317f08711d7c93f70cda17c4';

const weatherDiv = document.querySelector('.weather'),
    weatherSpan = weatherDiv.querySelector('span');

function loadCoords() {
    const coords = localStorage.getItem(CODRDS);
    if (coords) {
        // get weather;
        const parsedCoords = JSON.parse(coords);
        requestWeather(parsedCoords);
    } else {
        askForCoords();
    }
}

function askForCoords() {
    navigator.geolocation.getCurrentPosition(handleGeoSuccess, handelGeoError);
}

function handleGeoSuccess(position) {
    const latitude = position.coords.latitude;
    const longitude = position.coords.longitude;
    const coordsObj = {
        latitude,
        longitude
    };

    saveCoords(coordsObj);
    requestWeather(coordsObj);
}

function handelGeoError() {
    console.log('error');
}

function saveCoords(coordsObj) {
    localStorage.setItem(CODRDS, JSON.stringify(coordsObj));
}

function requestWeather(coordsObj) {
    const weatherUrl = `https://api.openweathermap.org/data/2.5/weather?lat=${coordsObj.latitude}&lon=${coordsObj.longitude}&appid=${OPEN_WEATHER_API_KEY}&units=metric`;
    // const req = new XMLHttpRequest();
    // req.open('GET', weatherUrl)
    // req.onreadystatechange = function (aEvt) {
    //     if (req.readyState === 4) {
    //        if(req.status === 200) {
    //            const parsedResponse = JSON.parse(req.response);
    //             console.dir(parsedResponse);
    //             paintWeather(parsedResponse);
    //        } else {
    //             console.log("Error loading page\n");
    //        }
    //     }
    //   };
    //   req.send(null);
    fetch(weatherUrl)
        .then(function(response) {
            console.log(response);
            return response.json();
        })
        .then(function(json) {
            paintWeather(json);
        })
}

function paintWeather(weatherInfo) {
    const temperature = weatherInfo.main.temp;
    const place = weatherInfo.name;
    weatherSpan.innerText = `${temperature}  @${place}`;
}

function init() {
    loadCoords();
}

init();