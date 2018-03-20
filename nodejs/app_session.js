const express = require('express');
const session = require('express-session');

const app = express();

var sess = {
  secret: 'afjlaifjlaeflaef',
  resave: false,
  saveUninitialized: true,
  cookie: {
    maxAge: 60*1000
  }
}

if (app.get('env') === 'production') {
  app.set('trust proxy', 1)
  sess.cookie.secure = true;
}

app.use(session(sess));

app.get('/', (req, res) => {
  res.send('Hi, there!');
});

app.get('/session', (req, res, next) => {
  console.log(req.session.views);
  if(req.session.views) {
    req.session.views++;
    
    var output = `
    <p>views: ${req.session.views}</p>
    <p>exires in: ${req.session.cookie.maxAge / 1000}'s</p>
    `;
    res.send(output);
  } else {
    req.session.views = 1;
    res.send('welcome to the sesison demo. refresh!');
  }
});

app.get('/views', (req, res) => {
  res.send('session views:' + req.session.views);
})

app.listen(3004, () => {
  console.log('Connected 3004 port!');
});
