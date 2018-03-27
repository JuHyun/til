const express = require('express');
const session = require('express-session');
const MySQLStore = require('express-mysql-session')(session);
const assert = require('assert');
const md5 = require('md5');

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
    password: 'ab538bd080d82d91ce60a6c83fb1a179',
    salt: 'dfjgq4rio23r5$#%qr839249#$',
    displayName: 'Apple'
  },
  {
    username: 'user2',
    password: '93d8b557fc2c37cfcc653e9e4d51fb0f',
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
    console.log(user.username + ':' + user.password);
    if (user.username === username && user.password === md5(req.body.password + user.salt)) {
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
