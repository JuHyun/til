const Joi = require('joi')

function validate(message) {
    const schema = Joi.object({
        txId: Joi.string().length(22).required(),
        data: Joi.object({
            code: Joi.string().required(),
            name: Joi.string().length(50, 'utf8').required(),
            categoryCode: Joi.string().required(),
            synonyms: Joi.string().required(),
            image: Joi.string().required(),
            chargeYn: Joi.string().regex(/^(Y|N)$/).required()
        })
    }).required()

    var {error, value} = Joi.validate(message, schema)
    if (error) {
        console.error(error.message)
        throw new Error('something happens')
    }
}

test('joi test', () => {
    expect(() => {validate(undefined)}).toThrowError(/something/)
    expect(() => {validate({})}).toThrowError(/something/)
    expect(() => {validate(null)}).toThrowError(/something/)
    expect(() => {validate(false)}).toThrowError(/something/)
    expect(() => {validate('')}).toThrowError(/something/)
})
