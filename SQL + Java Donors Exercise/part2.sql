-- a) List male Donors in Montreal or Laval
SELECT donorID, firstName, lastName, middleInitial, dateOfBirth, phone, email, SSN
FROM Donors
WHERE gender = 'M' AND (city = 'Montreal' OR city = 'Laval');

-- b) Details of red products delivered on February 14th, 2024
SELECT Sales.sID, Products.pID, Products.description, Products.price, Products.weight
FROM Sales
JOIN salesItems ON Sales.sID = salesItems.sID
JOIN Products ON salesItems.pID = Products.pID
WHERE Products.color = 'red' AND Sales.date = '2024-02-14';

-- c) Total amount of sales on February 14th, 2024
SELECT SUM(amount) AS totalSales
FROM Sales
WHERE date = '2024-02-14';

-- d) Monthly report of sales for 2023
SELECT 
    MONTH(date) AS month,
    COUNT(sID) AS totalSales,
    SUM(amount) AS totalAmount,
    SUM(deliveryFee) AS totalDeliveryFee
FROM Sales
WHERE YEAR(date) = 2023
GROUP BY MONTH(date);

-- e) Total donations by Donors in Brossard between 2022 and 2023
SELECT Donors.donorID, Donors.firstName, Donors.lastName, Donors.gender, SUM(Donations.amount) AS totalDonations
FROM Donors
JOIN Donations ON Donors.donorID = Donations.donorID
WHERE Donors.city = 'Brossard' AND Donations.date BETWEEN '2022-01-01' AND '2023-12-31'
GROUP BY Donors.donorID, Donors.firstName, Donors.lastName, Donors.gender
ORDER BY Donors.gender DESC, Donors.lastName, Donors.firstName;
