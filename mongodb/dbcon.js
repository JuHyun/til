const MongoClient = require('mongodb').MongoClient;
const assert = require('assert');

const url = 'mongodb://localhost:27017';

const dbName = 'myproject';

MongoClient.connect(url, (err, client) => {
  assert.equal(err, null);
  console.log('Connected successfully to server!');
  
  const db = client.db(dbName);
  
  client.close();
});
