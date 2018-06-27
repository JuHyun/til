'use strict'

function change(obj, source) {
    let tmpObj = obj
    console.log(obj, tmpObj)
    if (!obj) {
        return tmpObj
    }
    Object.keys(obj).forEach(key => {
        if (source.hasOwnProperty(key)) {
            console.log('1 => ' + key, obj[key])
            tmpObj[key] = source[key]
        }

        if (typeof obj[key] === 'object') {
            console.log('2 => ' + key, obj[key])
            tmpObj[key] = change(obj[key], source)
        }
    })
    return tmpObj
}

test('change', () => {
    let target = {
        name: '성주현',
        age: 35
    }

    expect(change(target, {name: '페더러'})).toEqual({
        name: '페더러',
        age: 35
    })
})

test('change', () => {
    let target = {
        name: '성주현',
        age: 35,
        address: {
            city: 'Seoul'
        }
    }

    expect(change(target, {city: '서울'})).toEqual({
        name: '성주현',
        age: 35,
        address: {
            city: '서울'
        }
    })
})

test('change', () => {
    let target = {
        name: '성주현',
        age: 35,
        address: {
            city1: 'Seoul',
            city2: 'Songpa'
        }
    }

    expect(change(target, {city1: null})).toEqual({
        name: '성주현',
        age: 35,
        address: {
            city1: null,
            city2: 'Songpa'
        }
    })
})
