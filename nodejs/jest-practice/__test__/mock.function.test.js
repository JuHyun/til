function forEach(items, callback) {
    for (let index = 0; index < items.length; index++) {
        callback(items[index])
    }
}

const mockCallback = jest.fn()

test('mock callback', () => {
    forEach([10, 20], mockCallback)

    expect(mockCallback.mock.calls.length).toBe(2)
    expect(mockCallback.mock.calls[0][0]).toBe(10)
    expect(mockCallback.mock.calls[1][0]).toBe(20)
    // expect(mockCallback.mock.results[0].value).toBe(42)
})

test('mock callback2', () => {
    const a = new mockCallback();
    const b = {}
    const bound = mockCallback.bind(b)

    console.log(mockCallback.mock.instances)
})

test('mock return values', () => {
    expect(mockCallback()).toBeUndefined()

    mockCallback.mockReturnValueOnce(10)
    mockCallback.mockReturnValueOnce('x')
    mockCallback.mockReturnValue(true)

    expect(mockCallback()).toBe(10)
    expect(mockCallback()).toBe('x')
    expect(mockCallback()).toBeTruthy()
})


test('mock test', () => {
    const filterTestFn = jest.fn()

    filterTestFn.mockReturnValueOnce(true)
        .mockReturnValueOnce(false)

    const result = [11, 12].filter(filterTestFn)

    expect(filterTestFn.mock.calls.length).toBe(2)
    expect(result).toContain(11)
})
