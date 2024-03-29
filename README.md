# Registration-of-students-living-in-a-dormitory
This project is a comprehensive Student Dormitory Management System designed to streamline operations for administrators, accountants, and dormitory staff.
It provides functionality for managing student information,dormitory information, room allocations, events, payments, and additional services. 
The project is structured with two main branches: main and bd.
Features
Common Features (Available in both branches)

Student Management:
Add, edit  student records.
View detailed information about each student.
View in which room lives choosen student

Room Management:
Manage dormitory room details.
Add, edit, and delete room records.
View in which dormitory located choosen room

Dormitory Management:
Add, edit, and delete dormitory  records.
View students who lives in choosen dormitory.

Event and Activity Management:
Add, edit, and delete  events and activities.
Allow students to sign up for events.

Payment Management:
Add, edit, and delete payment records.
Track payments for dormitory accommodation.

Additional Services:
Add, edit, and delete additional services records.
Record payments for additional services.
Allow students to sign up for additional services.

Branch: main.
- In this branch, the system includes all the mentioned features but lacks user registration and authentication.

Branch: bd.
- The bd branch incorporates user registration, authentication, and role-based access control, ensuring that each user has access only to the features relevant to their role.

## Database Schema
- **student Table**: Information about students.
- **hostel Table**: Information about dormitory.
- **payment Table**: Information about payment.
- **room Table**: Information about rooms.
- **service Table**: Information about additional services.
- **event Table**: Information about events and activities.
- **student_events Table**: additional table to connect student and event tables.
- **student_services Table**: additional table to connect student and service tables.
- **users Table**: Information about users.
- **roles Table**: Information about roles.
- **users_roles Table**: additional table to connect users and roles tables.

## Installation
Clone the repository. To set up the database, you'll need a SQL database server like MySQL or PostgreSQL. You also need Mariadb. 
