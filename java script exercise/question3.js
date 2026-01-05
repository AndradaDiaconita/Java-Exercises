const express = require('express');
const app = express();
const bodyParser = require('body-parser');

app.use(bodyParser.urlencoded({ extended: true }));

app.get('/', (req, res) => {
    res.sendFile(__dirname + '/index.html');
});

app.post('/checkPhoneNumber', (req, res) => {
    const phoneNumber = req.body.phoneNumber;
    const phoneNumberPattern = /^\d{3}-\d{3}-\d{4}$/;

    if (phoneNumber.match(phoneNumberPattern)) {
        res.send(`<p>Phone number "${phoneNumber}" is correct!</p>`);
    } else {
        res.send(`<p>Phone number "${phoneNumber}" is incorrect. Please use the format ddd-ddd-dddd.</p>`);
    }
});

const PORT = process.env.PORT || 5085;
app.listen(PORT, () => {
    console.log(`Server is running on port ${PORT}`);
});
