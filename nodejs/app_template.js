const express = require('express');
const app = express();
const cookieParser = require('cookie-parser');

app.use(cookieParser());

app.get('/', (req, res) => {
  res.send('Hello, there!');
});

app.get('/count', (req, res) => {
  console.log(req.cookies.count);
  var count = 1;
  if(req.cookies.count) {
    count += parseInt(req.cookies.count);
  }
  res.cookie('count', count);
  res.send('<h1>Cooke:' + count + '</h1>');
});

app.listen(3003, () => {
  console.log('App Cookie listening on port 3003.');
});
