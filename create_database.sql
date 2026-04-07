-- Create the database
CREATE DATABASE IF NOT EXISTS edufeedback;

-- Use the database
USE edufeedback;

-- Create tables (Spring Boot will create them with ddl-auto=update, but you can create them manually if needed)

-- Example: Create users table manually (optional - Spring Boot will handle this)
-- CREATE TABLE users (
--     id BIGINT AUTO_INCREMENT PRIMARY KEY,
--     username VARCHAR(255) NOT NULL UNIQUE,
--     email VARCHAR(255),
--     password VARCHAR(255) NOT NULL
-- );

-- Grant permissions to your user
GRANT ALL PRIVILEGES ON edufeedback.* TO 'root'@'localhost';
FLUSH PRIVILEGES;