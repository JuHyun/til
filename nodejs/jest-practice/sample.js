function fetchData(callback) {
    let data = getButter()
    return callback(data)
}

function getButter() {
    return 'peanut butter'
}

function fetchData2(callback) {
    return new Promise(function (resolve, reject) {
        resolve(getButter())
    })
}

function fetchData3(callback) {
    return new Promise(function (resolve, reject) {
        if (1 !== 1) {
            resolve(getButter())
        } else {
            reject('error')
        }
    })
}

module.exports = {
    fetchData,
    fetchData2,
    fetchData3,
}
