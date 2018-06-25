import axios from 'axios'
import Users from '../app/users'

jest.mock('axios')

test('should fetch users', () => {
    const res = {data: [{name: 'Bob'}]}
    axios.get.mockResolvedValue(res)

    return Users.all().then(users => expect(users).toEqual(res.data))
})

const myMockFn = jest.fn(cb => cb(null, null))

myMockFn((err, val) => console.log(val))
