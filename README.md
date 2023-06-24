# University Management System
A Spring Boot Application to Manage University Database.
PostgreSQL Database

## Tables
### Address
| id | houseNo | street | city | state | country | pincode |
|----|---------|--------|------|-------|---------|---------|
### Departments
| id | name | abbreviation | hodId | description | imageURL |
|----|------|--------------|-------|-------------|----------|
### Lecturer
| id | firstName | middleName | lastName | email | phoneNumber | gender | addressId | dateOfBirth | profilePictureURL | employeeId | departmentId |
|----|-----------|------------|----------|-------|-------------|--------|-----------|-------------|-------------------|------------|--------------|
### Student
| id | firstName | middleName | lastName | email | phoneNumber | gender | addressId | dateOfBirth | profilePictureURL | rollNumber | departmentId |
|----|-----------|------------|----------|-------|-------------|--------|-----------|-------------|-------------------|------------|--------------|
### Subject
| id | name | departmentId | subjectCode | credits | description |
|----|------|--------------|-------------|---------|-------------|
### Student Credit Mapping
| id | studentId | subjectId | credits | semester | isCompleted |
|----|-----------|-----------|---------|----------|-------------|