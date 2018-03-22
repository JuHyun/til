const express = require('express');
const session = require('express-session');
const assert = require('assert');

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
    maxAge: 60*1000
  }
}))


const User = {
  'user1': 'password1',
  'user2': 'password2',
  'user3': 'password3'
}

app.get('/', (req, res) => {
  let output = ''
  console.log(req.session.username);
  if (req.session.username) {
    output = `
        <h1>Hello, ${req.session.username}</h1>
    `;
  } else {
    output = `
      <h1>Hello, there!</h1>
      <div>
          <a href="/auth/login">로그인</a>
      </div>
  `;
  }
  res.send(output);
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
  if (User.hasOwnProperty(username) && User[username] === req.body.password) {
    req.session.username = username;
    res.redirect('/welcome');
  } else {
    res.redirect('/auth/login');
  }
})

app.get('/welcome', (req, res) => {
  if (req.session.username) {
    res.render('welcome', {name: req.session.username});
  } else {
    res.redirect('/');
  }
})

app.get('/auth/logout', (req, res) => {
  req.session.destroy((err) => {
    assert.equal(err, null);
    
    console.log('session destroyed!');
  });
  
  res.redirect('/');
})

app.listen('3000', () => {
  console.log('Connected to 3000 port!');
})
