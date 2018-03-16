const MongoClient = require('mongodb').MongoClient;
const assert = require('assert');

const url = "mongodb://localhost:27017";

const dbName = "myproject";

MongoClient.connect(url, (err, client) => {
  assert.equal(null, err);
  console.log("Connected successfully to server.");
  
  const db = client.db(dbName);
  
  client.close();
});
