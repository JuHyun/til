const MongoClient = require('mongodb').MongoClient;
const assert = require('assert');

// Connection URL
const url = 'mongodb://127.0.0.1:27017';

// Database Name
const dbName = 'exampleDB';

MongoClient.connect(url, (error, client) => {
  assert.equal(null, error);
  console.log('Connected successfully to server!');
  
  const db = client.db(dbName);

  inserStudent(db, () => {
    console.log('one insert success');
  });

  insertDocuments(db, () => {
    console.log('multi insert success');
    findDocumentsWithFilter(db, (result) => {
      console.log('find documents...');
    });

    updateDocument(db, (result) => {
      console.log('one update success.');
      console.log(result.result);
      console.log(result.matchedCount);
      console.log(result.modifiedCount);
      console.log(result.upsertedCount);
      console.log(result.upsertedId);
      
    });
  
    removeDocuments(db, (result) => {
      console.log('one removed success.');
      console.log('result.result:' + result);
      console.log('result.deletedCount:' + result.deletedCount);
  
      indexCollection(db, () => {
        findDocuments(db, (result) => {
          client.close();
        });
      });
    });
  });
});

const inserStudent = function(db, collback) {
  const collection = db.collection('student');

  collection.insertOne({
    name: 'Michael',
    age:15,
    gender: 'Male'
  }, (err, result) => {
    assert.equal(err, null);
    assert.equal(1, result.result.n);

    console.log('Inserted 1 documents into the collection');
    collback(result);
  });
}

const findStudents = function(db, callback) {
    const collection = db.collection('student');

    collection.find().toArray((err, docs) => {
        // assert.equal(err, null);
        // assert.ok(docs != null);

        console.log("Found the following student records.");
        console.log(docs);

        callback(docs);
    });
}

const insertDocuments = function(db, callback) {
  const collection = db.collection('documents');

  collection.insertMany([
      {a: 1},
      {a: 2},
      {a: 7}
  ], (err, result) => {
    assert.equal(err, null);
    assert.equal(3, result.result.n);
    assert.equal(3, result.ops.length);

    console.log('Inserted 3 documents into the collection');
    callback(result);
  });
}

const findDocuments = function(db, callback) {
  const collection = db.collection('documents');

  collection.find().toArray((err, docs) => {
    console.log(err);
    assert.equal(err, null);
    assert.ok(docs != null);

    console.log("Found the following records.");
    console.log(docs);
    callback(docs);
  });
}

const findDocumentsWithFilter = function (db, callback) {
  const collection = db.collection('documents');
  
  collection.find({a: 7}).toArray((err, docs) => {
    assert.equal(err, null);
    console.log("Found the following records.");
    console.log(docs);

    callback(docs);
  });
}

const updateDocument = function(db, callback) {
  const collection = db.collection('documents');

  collection.updateOne({a: 7},
    { $set: {b: 5}},
    (err, result) => {
      assert.equal(err, null);
      assert.equal(1, result.result.n);
      console.log("Updated the document with the field a equal to 7");
      callback(result);
    });
}

const removeDocument = function(db, callback) {
  const collection = db.collection('documents');
  
  collection.deleteOne({ a: 2 }, (error, result) => {
    assert.equal(error, null);
    assert.ok(result.result.ok);
    
    callback(result);
  });
};

const removeDocuments = function (db, callback) {
  const collection = db.collection('documents');
  
  collection.deleteMany({ a: 7 }, (error, result) => {
    assert.equal(error, null);
    
    console.log('removed many documents success.');
    callback(result);
  });
}

const indexCollection = function (db, callback) {
  db.collection('documents').createIndex({ a: 1 }, null, (err, result) => {
    assert.equal(err, null);
  
    console.log('index create success!!');
    console.log(result);
    
    callback(result);
  });
}
