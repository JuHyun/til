connection = new Mongo('localhost:27017');
db = connection.getDB('reviews');

print(db.portion.find());