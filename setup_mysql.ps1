# MySQL Setup Script for EduFeedback Backend
# Run this script after installing MySQL

Write-Host "Setting up MySQL for EduFeedback Backend..." -ForegroundColor Green

# Check if MySQL is installed
$mysqlPath = Get-Command mysql -ErrorAction SilentlyContinue
if (-not $mysqlPath) {
    Write-Host "MySQL not found in PATH. Please add MySQL bin directory to PATH or run MySQL commands manually." -ForegroundColor Red
    Write-Host "Typical MySQL bin path: C:\Program Files\MySQL\MySQL Server X.X\bin" -ForegroundColor Yellow
    exit 1
}

Write-Host "MySQL found at: $($mysqlPath.Source)" -ForegroundColor Green

# Database setup commands
$sqlCommands = @"
CREATE DATABASE IF NOT EXISTS edufeedback;
USE edufeedback;
GRANT ALL PRIVILEGES ON edufeedback.* TO 'root'@'localhost';
FLUSH PRIVILEGES;
SHOW DATABASES;
"@

Write-Host "Creating database and granting permissions..." -ForegroundColor Yellow

# Execute MySQL commands
$sqlCommands | mysql -u root -p

Write-Host "Database setup complete!" -ForegroundColor Green
Write-Host "You can now run your Spring Boot application." -ForegroundColor Green