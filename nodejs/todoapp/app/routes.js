'use strict'

var express = require('express')
var todoRoutes = express.Router()
var Todo = require('./todo')

// get all todos in the db.
todoRoutes.route('/all').get((req, res, next) => {
    Todo.find((err, todos) => {
        if (err) {
            return next(new Error(err))
        }

        // return all todos.
        res.json(todos)
    })
})

// create a todo item.
todoRoutes.route('/add').post((req, res) => {

})


https://dev.to/abiodunjames/build-a-todo-app-with-nodejs-expressjs-mongodb-and-vuejs--part-1--29n7
https://dev.to/abiodunjames/build-a-todo-app-with-nodejs-expressjs-mongodb-and-vuejs--part-1--29n7
https://docs.microsoft.com/ko-kr/visualstudio/javascript/quickstart-vuejs-with-nodejs?view=vs-2017
https://jinblog.kr/192