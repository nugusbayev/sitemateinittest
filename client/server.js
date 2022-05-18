var express = require("express")
var app = express()
const request = require('request');
var bodyParser = require("body-parser");
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());

var HTTP_PORT = 8000

// Start server
app.listen(HTTP_PORT, () => {
    console.log("Server running on port %PORT%".replace("%PORT%",HTTP_PORT))
});


app.get("/api/issue/:id", (req, res, next) => {
    var params = [req.params.id]
    request('http://localhost:8080/issues/10', { json: true }, (err, res, body) => {
        if (err) { return console.log(err); }
        console.log(body);
    });
    res.sendStatus(200);
});


app.post("/api/issue/", (req, res, next) => {
    var data = {
        id: 10,
        title: "title",
        description : "desc"
    }
    request.post({url:'http://localhost:8080/issues',json: true, body: data }, (err, res, body) => {
        if (err) { return console.log(err); }

    });
    res.sendStatus(200);
})



app.put("/api/issue/:id", (req, res, next) => {
    var data = {
        id: 10,
        title: "title",
        description : "desc"
    }
    request.put({url:'http://localhost:8080/issues/10',json: true, body: data }, (err, res, body) => {
        if (err) { return console.log(err); }
    });
    res.sendStatus(200);
})


app.delete("/api/issue/:id", (req, res, next) => {
    request.delete({url:'http://localhost:8080/issues/10',json: true}, (err, res, body) => {
        if (err) { return console.log(err); }
    });
    res.sendStatus(204);
})


// Root path
app.get("/", (req, res, next) => {
    res.json({"message":"Ok"})
});

