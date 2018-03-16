connection = new Mongo('localhost:27017');
db = connection.getDB('reviews');

db.collection('inventory').insertOne({
  item: "canvas",
  qty: 100,
  tags: ["cotton"],
  size: { h: 28, w: 35.5, uom: "cm" }
})
.then(function(result) {
  // process result
  print("result = " + result);
})