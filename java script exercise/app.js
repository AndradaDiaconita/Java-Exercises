const express = require('express');
const path = require('path');
const cookieParser= require("cookie-parser");

const app = express();
app.use(
	express.json(),
	express.urlencoded({
		extended: true,
  }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));


app.get('/Q1F1', (req, res) => {
  console.log(req.query);
  let num = req.query.number;
  res.send("Received your request! number: " + num +"<br>result is "+     findSummation(num));
});

app.get('/Q1F2', (req, res) => {
console.log(req.query);
  let str = req.query.str;
  res.send("Received your request! str: " + str +"<br>result is "+
    uppercaseFirstandLast(str));
});

app.get('/Q1F3', (req, res) => {
    const nums = req.query.nums;
    const result = findAverageAndMedian(nums);
    res.send("Received your request! nums: " + nums +
             "<br>average: " + result.average + "<br>median: " + result.median);
});

app.get('/Q1F4', (req, res) => {
    const str = req.query.str;
    const result = find4Digits(str);
    res.send("Received your request! str: " + str +
             "<br>result: " + (result || "false"));
});



app.get('/readcookie', (req, res) => {
    const visitCount = req.cookies.visitCount || 0;
    res.send(`You have visited this site ${visitCount} times.`);
});


app.get('/delcookie', (req, res) => {
    res.clearCookie('visitCount');
    res.send('Cookie deleted. Visit count reset.');
});


app.get('/phone', (req, res) => {
    const name = req.query.name;
    const phone = req.query.phone;

    // Assuming you want to store the phone number in a cookie
    res.cookie('userPhone', phone);

    res.send(`Thank you, ${name}! Your phone number ${phone} has been saved.`);
});


//change the port number to your port number
app.listen(5085, () => {
  console.log("Example app listening on port 5085");
});


function findSummation(n) {
    if (isNaN(n) || n <= 0) {
        return false;
    }
    
    let summation = 0;
    for (let i = 1; i <= n; i++) {
        summation += i;
    }
    
    return summation;
}


function uppercaseFirstandLast(wordString) {
    const words = wordString.split(' ');
    const modifiedWords = words.map(word => {
        if (word.length >= 2) {
            const firstChar = word[0].toUpperCase();
            const lastChar = word[word.length - 1].toUpperCase();
            return firstChar + word.slice(1, -1) + lastChar;
        }
        return word;
    });
    
    return modifiedWords.join(' ');
}


function findAverageAndMedian(numsString) {
    const numsArray = numsString.split(',').map(num => parseFloat(num.trim()));
    const sum = numsArray.reduce((acc, num) => acc + num, 0);
    const average = sum / numsArray.length;

    // Sort the array to calculate the median
    const sortedNums = numsArray.slice().sort((a, b) => a - b);
    const middleIndex = Math.floor(sortedNums.length / 2);
    const median = sortedNums.length % 2 === 0
        ? (sortedNums[middleIndex - 1] + sortedNums[middleIndex]) / 2
        : sortedNums[middleIndex];

    return { average, median };
}


function find4Digits(str) {
    const numbers = str.split(' ').filter(item => /^\d+$/.test(item));
    const fourDigitNumber = numbers.find(item => item.length === 4);
    return fourDigitNumber || false;
}


