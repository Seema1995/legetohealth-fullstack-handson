//var Set = require("collections/set");

function User() {
    this.name = 'something';
}

var clients = new Set();

var a = new User();
var b = new User();
clients.add(a);
clients.add(b);

for (var user of clients) {
    console.log(user.name+' iterated');
}