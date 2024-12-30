
CREATE SCHEMA `assessmentdb` ;

USE `assessmentdb` ;

CREATE TABLE GROCERYITEM (
    GroceryItemID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    Price DECIMAL(10, 2) NOT NULL,
    StockQuantity INT NOT NULL,
    CreatedBy VARCHAR(255),
    CreatedAt DATE,
    ModifiedBy VARCHAR(255),
    ModifiedAt DATE
);

CREATE TABLE `ORDER` (
    OrderID INT AUTO_INCREMENT PRIMARY KEY,
    UserID VARCHAR(255) NOT NULL,
    TotalAmount DECIMAL(10, 2) NOT NULL,
    CreatedBy VARCHAR(255),
    CreatedAt DATE
);

CREATE TABLE ORDERITEM (
    OrderItemID INT AUTO_INCREMENT PRIMARY KEY,
    GroceryItemID INT NOT NULL,
    OrderID INT NOT NULL,
    Quantity INT NOT NULL,
    Price DECIMAL(10, 2) NOT NULL,
    CreatedBy VARCHAR(255),
    CreatedAt DATE,
    FOREIGN KEY (GroceryItemID) REFERENCES GROCERYITEM(GroceryItemID) ON DELETE CASCADE,
    FOREIGN KEY (OrderID) REFERENCES `ORDER`(OrderID) ON DELETE CASCADE
);