create database DemoDb2;

--tables--
Create TABLE Categories(
	CategoryID INT PRIMARY KEY IDENTITY(1,1),
	CName VARCHAR(255));

Create TABLE Products(
	ProductID INT PRIMARY KEY IDENTITY(1,1),
	PName VARCHAR(255),
	Description TEXT,
	Price DECIMAL(10,2),
	CategoryID INT,
	FOREIGN KEY (CategoryID) REFERENCES Categories(CategoryID)
	);

CREATE TABLE Customers (
    CustomerID INT PRIMARY KEY IDENTITY(1,1),
    Name VARCHAR(255),
    Email VARCHAR(255) UNIQUE,
    Address VARCHAR(255)
);

CREATE TABLE Orders (
    OrderID INT PRIMARY KEY IDENTITY(1,1),
    CustomerID INT,
    OrderDate DATETIME,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);


CREATE TABLE Cart (
    CartID INT PRIMARY KEY IDENTITY(1,1),
    CustomerID INT,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

--constraints--
ALTER TABLE Customers ADD CONSTRAINT chk_email CHECK(Email LIKE '%@%.%')

--Keys, Referential Integrity and CASCADE
CREATE TABLE CartItems (
    CartItemID INT PRIMARY KEY IDENTITY(1,1),
    CartID INT,
    ProductID INT,
    Quantity INT,
    FOREIGN KEY (CartID) REFERENCES Cart(CartID) ON DELETE CASCADE,
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);

CREATE TABLE OrderItems (
    OrderItemID INT PRIMARY KEY IDENTITY(1,1),
    OrderID INT,
    ProductID INT,
    Quantity INT,
    FOREIGN KEY (OrderID) REFERENCES Orders(OrderID) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);

/*
FOREIGN KEY (OrderID) REFERENCES Orders(OrderID) ON DELETE SET NULL
FOREIGN KEY (OrderID) REFERENCES Orders(OrderID) ON DELETE SET DEFAULT
FOREIGN KEY (OrderID) REFERENCES Orders(OrderID) ON DELETE NO ACTION
*/

CREATE INDEX ind_cname ON Customers(Name);

--Triggers--
CREATE TABLE OrderHistory (
    OrderID INT,
    CustomerID INT,
    DeletedAt DATETIME DEFAULT GETDATE()
);

CREATE TRIGGER trg_AfterDelete ON Orders
AFTER DELETE
AS
BEGIN
    INSERT INTO OrderHistory (OrderID, CustomerID, DeletedAt)
    SELECT OrderID, CustomerID, GETDATE() FROM deleted;
END;