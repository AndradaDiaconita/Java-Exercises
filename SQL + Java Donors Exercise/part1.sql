-- a) Create Tables
CREATE TABLE Donors (
    donorID INT PRIMARY KEY,
    firstName VARCHAR(50),
    middleInitial CHAR(1),
    lastName VARCHAR(50),
    dateOfBirth DATE,
    city VARCHAR(50),
    address VARCHAR(100),
    postalCode VARCHAR(10),
    province VARCHAR(50),
    gender CHAR(1),
    SSN CHAR(9),
    hobby VARCHAR(50),
    phone VARCHAR(15),
    email VARCHAR(100)
);

CREATE TABLE Products (
    pID INT PRIMARY KEY,
    description VARCHAR(255),
    date DATE,
    price DECIMAL(10, 2),
    weight DECIMAL(10, 2)
);

CREATE TABLE Donations (
    dID INT PRIMARY KEY,
    donorID INT,
    date DATE,
    type VARCHAR(10),
    amount DECIMAL(10, 2),
    FOREIGN KEY (donorID) REFERENCES Donors(donorID)
);


CREATE TABLE Sales (
    sID INT PRIMARY KEY,
    date DATE,
    amount DECIMAL(10, 2),
    deliveryFee DECIMAL(10, 2)
);

CREATE TABLE salesItems (
    sID INT,
    pID INT,
    PRIMARY KEY (sID, pID),
    FOREIGN KEY (sID) REFERENCES Sales(sID),
    FOREIGN KEY (pID) REFERENCES Products(pID)
);

-- b) Alter Donors Table
ALTER TABLE Donors 
DROP COLUMN hobby;

-- c) Alter Products Table
ALTER TABLE Products 
ADD color VARCHAR(50) DEFAULT 'Unknown';
ALTER TABLE Products 
ADD location VARCHAR(255) DEFAULT 'Unknown';


-- d) Insert Data into Donors and Donations
INSERT INTO Donors (donorID, firstName, lastName, middleInitial, dateOfBirth, address, city, postalCode, province, gender, SSN, phone, email) 
VALUES (1, 'Andrada', 'Diaconita', 'I', '2002-10-10', '4372 Avalon Street', 'Montreal', 'H9H1V6', 'QC', 'F', '3444596766', '438-499-6603', 'a_diaco@live.concordia.ca');

INSERT INTO Donors (donorID, firstName, lastName, middleInitial, dateOfBirth, address, city, postalCode, province, gender, SSN, phone, email) 
VALUES (2, 'Jeffrey', 'Morgan', 'D', '2000-05-23', '123 Walking Street', 'Laval', 'H1H1H1', 'QC', 'F', '2395483920', '222-333-4444', 'email@gmail.com');

INSERT INTO Donations (dID, donorID, date, type, amount) 
VALUES (1, 1, '2024-07-10', 'money', 150.00);

INSERT INTO Donations (dID, donorID, date, type, amount)
VALUES (2, 2, '2023-06-01', 'products', 333.00);

INSERT INTO Donations (dID, donorID, date, type, amount)
VALUES (3, 1, '2023-07-01', 'products', 456.00);

-- e) Delete Data from Donors and Donations
DELETE FROM Donations 
WHERE dID IN (1);
DELETE FROM Donors 
WHERE donorID IN (1, 2);

-- f) Drop All Tables
DROP TABLE salesItems;
DROP TABLE Sales;
DROP TABLE Products;
DROP TABLE Donations;
DROP TABLE Donors;
