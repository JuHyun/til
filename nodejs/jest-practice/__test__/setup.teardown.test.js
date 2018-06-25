beforeAll(() => {
    return {a: 1000, b: 'abc'}
})

afterAll(() => {
    return {a: 9999, b: 'zzz'}
});


describe('setup and teardown', () => {
    beforeEach((param) => {
        console.log('beforeEach - param = ' + param);
    })

    let param = 1234
    test('works', () => {
        console.log('test param = ' + param)
    })
})
