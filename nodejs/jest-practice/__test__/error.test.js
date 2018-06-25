'use strict'

class DisgustingFlavorError extends Error {
    constructor(...args) {
        super(...args)
        Error.captureStackTrace(this, DisgustingFlavorError)
    }
}

function drinkFalvor(flavor) {
    if (flavor === 'octopus') {
        throw new DisgustingFlavorError('yuck, octopus flavor')
    }

    return `${flavor} is really nice`
}

describe('drinkFalvor', () => {
    it('throws on octopus', () => {
        expect(() => {drinkFalvor('octopus')}).toThrowError(/yuck/)
        // expect(() => {drinkFalvor('octopus')}).toThrowError('yuck')
    })
})
