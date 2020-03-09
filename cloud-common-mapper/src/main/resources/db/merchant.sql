CREATE TABLE merchant(

    MerchantId BIGINT PRIMARY KEY AUTO_INCREMENT,
    MerchantCode VARCHAR(50),
    MerchantName VARCHAR(50),
    `AddTime` DATETIME,
    `Status` TINYINT,
    MerchantKey VARCHAR(50),
    `PassWord` VARCHAR(50),
    ApiAddress VARCHAR(50),
    Remark VARCHAR(50),
    Sort INT,
    DataNode INT

);