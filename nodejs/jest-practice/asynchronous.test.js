const {fetchData, fetchData2, fetchData3} = require('./app/sample')

test('the data is peanut butter', done => {
    function callback(data) {
        expect(data).toBe('peanut butter')
        done()
    }

    fetchData(callback)
})

test('the data is peanut butter2', () => {
    expect.assertions(1)
    return fetchData2().then(data => {
        expect(data).toBe('peanut butter')
    })
})

test('the data is peanut butter2 with resolves', () => {
    expect.assertions(1)
    return expect(fetchData2()).resolves.toBe('peanut butter')
})

test('the fetch fails with an error', () => {
    expect.assertions(1)
    return fetchData3().catch(e => expect(e).toMatch('error'))
})

test('the fetch fails with an error with rejects', () => {
    expect.assertions(1)
    return expect(fetchData3()).rejects.toMatch('error')
})

test('the data is peanut butter with async/await', async () => {
    expect.assertions(1)
    const data = await fetchData2()
    expect(data).toBe('peanut butter')
})

test('the fetch fails with an error with async/awiat', async () => {
    expect.assertions(1)
    try {
        await fetchData3()
    } catch (e) {
        expect(e).toMatch('error')
    }
})

test('the data is peanut butter with async/await and resolve', async () => {
    expect.assertions(1)
    await expect(fetchData2()).resolves.toBe('peanut butter')
})

test('the data is peanut butter with async/await and reject', async () => {
    expect.assertions(1)
    await expect(fetchData3()).rejects.toMatch('error')
})

test.only('this will be the only test that runs', () => {
    expect(true).toBeTruthy();
});

test('this test will not run', () => {
    expect('A').toBe('A');
});
