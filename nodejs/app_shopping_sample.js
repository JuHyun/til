const express = require('express');
const cookieParser = require('cookie-parser');

const app = express();
app.use(cookieParser('a3qio!#%Qiruafjio!!$o9p2j'));

app.set('views', './views');
app.set('view engine', 'pug');

app.get('/', (req, res) => {
  res.send('Hello, there! I\'m shopping app.');
});

app.get('/products', (req, res) => {
  res.render('products',);
});

app.get(['/cart', '/cart/:productId'], (req, res) => {
  var productId = req.params.productId;
  
  var cart = {};
  if (req.signedCookies.cart) {
    cart = req.signedCookies.cart;
  }
  
  if(cart[productId]) {
    cart[productId] = parseInt(cart[productId]) + 1;
  } else if (!isNaN(parseInt(productId))) {
    cart[productId] = 1;
  }
  
  res.cookie('cart', cart, {signed: true});
  res.render('cart', {'cart': cart});
});

app.listen(3003, () => {
  console.log('Connected 3003 port!');
});
