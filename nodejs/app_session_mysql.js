const express = require('express');
const session = require('express-session');
const MySQLStore = require('express-mysql-session')(session);
const assert = require('assert');
const sha512 = require('sha512');

const app = express();

app.set('views', './views/login');
app.set('view engine', 'pug');

app.use(express.json())
app.use(express.urlencoded({
  extended: true
}))

const COOKIE_SECRET = 'afjio2r8uo1!$#@uoauio';
app.use(session({
  secret: COOKIE_SECRET,
  resave: false,
  saveUninitialized: true,
  cookie: {
    maxAge: 60 * 1000
  },
  store: new MySQLStore({
    host: 'localhost',
    port: 3306,
    user: 'user1',
    password: 'password1',
    database: 'exam'
  })
}))

const User = [
  {
    username: 'user1',
    password: 'fc7f433f78ce28e7d769a36084d09bbbc527181bbb6bf776f8ea5088f76b83ae83a8d7a1ee008b03d7ddd89c7a1503505819bc6df18b32e06188459276bfa7bd',
    salt: 'dfjgq4rio23r5$#%qr839249#$',
    displayName: 'Apple'
  },
  {
    username: 'user2',
    password: 'a06dd6814971a71f5bf83c8d538afe380f0e22d3cf1399169365e8b680465f70ee135ce49a49a236f78f0e2f04c00dd9d313347e0086e9649ac52d9973c266d6',
    salt: '&#^)fgwklwtu4ifliqr#$#)$2j@',
    displayName: 'Pear'
  }
]

app.get(['/', '/welcome'], (req, res) => {
  if (req.session.username) {
    res.render('welcome', {name: req.session.username});
  } else {
    res.redirect('/auth/login');
  }
});

app.get('/auth/login', (req, res) => {
  if (req.session.username) {
    res.redirect('/welcome');
  } else {
    res.render('login', {});
  }
});

app.post('/login', (req, res) => {
  let username = req.body.username;
  for (var user of User) {
    if (user.username === username && user.password === sha512(req.body.password + user.salt).toString('hex')) {
      req.session.username = user.displayName;
      return req.session.save(() => {
        res.redirect('/welcome');
      });
    }
  }
  console.log('login fail!');
  res.redirect('/auth/login');
})

app.get('/auth/logout', (req, res) => {
  req.session.destroy((err) => {
    assert.equal(err, null);
    
    console.log('session destroyed!');
    res.redirect('/');
  });
})

app.listen('3000', () => {
  console.log('Connected to 3000 port!');
})
