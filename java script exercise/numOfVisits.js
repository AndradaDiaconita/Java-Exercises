const express = require('express');
const cookieParser = require('cookie-parser');
const moment = require('moment-timezone'); // For handling time and date

const app = express();
const port = 5085;

app.use(cookieParser());

app.get('/', (req, res) => {
  let visits = req.cookies.visits ? parseInt(req.cookies.visits) : 0;
  visits++;

  const isFirstVisit = visits === 1;
  const currentDate = moment().tz('America/New_York'); // Change time zone as needed
  const lastVisitDate = req.cookies.lastVisit
    ? moment(req.cookies.lastVisit).tz('America/New_York')
    : null;

  res.cookie('visits', visits);
  res.cookie('lastVisit', currentDate.toISOString());

  let message;

  if (isFirstVisit) {
    message = 'Welcome to my webpage! It is your first time here.';
  } else {
    message = `Hello, this is the ${visits} time that you are visiting my webpage.`;

    if (lastVisitDate) {
      const lastVisitFormatted = lastVisitDate.format('ddd MMM D HH:mm:ss z YYYY');
      message += `\nLast time you visited my webpage on: ${lastVisitFormatted}`;
    }
  }

  res.send(message);
});

app.listen(port, () => {
  console.log(`Server is running on port ${port}`);
});
