const MongoClient = require('mongodb').MongoClient;
const assert = require('assert');

const url = "mongodb://localhost:27017";

const dbName = "myproject";

MongoClient.connect(url, (err, client) => {
  assert.equal(null, err);
  console.log("Connected successfully to server.");
  
  const db = client.db(dbName);
  const collection = db.collection('documents');
  
  console.log("__dirname: " + __dirname);
  
  indexCollection(collection, () => {});
  
  insertDocuments(collection, () => {
    findDocuments(collection, () => {
      findDocumentsWithQuery(collection, () => {
        updateDocument(collection, () => {
          deleteDocument(collection, () => {
            client.close();
          });
        });
      });
    });
  });
});

const insertDocuments = function(collection, callback) {
  collection.insertMany([
    {a:1}, {a:2}, {a:3}
  ], (err, result) => {
    assert.equal(err, null);
    assert.equal(3, result.result.n);
    assert.equal(3, result.insertedCount);

    console.log("Inserted 3 documents into the collection.");
    callback(result);
  });
}

const findDocuments = function(collection, callback) {
  collection.find({}).toArray((err, docs) => {
    assert.equal(err, null);
    console.log("Found the following records.");
    console.log(docs);
    callback(docs);
  });
}

const findDocumentsWithQuery = function(collection, callback) {
  collection.find({'a': 3}).toArray((err, docs) => {
    assert.equal(err, null);
    console.log("Found the following a:3 records.");
    console.log(docs);
    callback(docs);
  });
}

const updateDocument = function(collection, callback) {
  collection.updateMany({'a': 2}, {$set: {'c':2}}, (err, result) => {
    assert.equal(err, null);
    assert.equal(result.result.ok, 1);
  
    console.log('Updated the document with the field a equal to 2');
    callback(result);
  });
}

const deleteDocument = function(collection, callback) {
  collection.deleteMany({'a': 3}, (err, result) => {
    assert.equal(err, null);
    assert.equal(result.result.ok, 1);
  
    console.log('Removed the document with the field a equal to 2');
    callback(result);
  });
}

const indexCollection = function (collection, callback) {
  collection.createIndex({'a':2}, null, (err, result) => {
    assert.equal(err, null);
    
    console.log("Created index with the field a equal 2");
    callback(result);
  });
}

const createCollection = function(db, callback) {
  db.create
}
