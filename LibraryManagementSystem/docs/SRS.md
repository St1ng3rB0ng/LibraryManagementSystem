# Software Requirements Specification (SRS)

This document outlines the requirements for the Online Library Management System, developed as a solo project using Java, Spring Boot, and PostgreSQL. It follows the IEEE 830-1998 standard and supports the system's goals of automating library operations, ensuring scalability, security, and user-friendliness.

## 1. Introduction

### 1.1 Purpose
The purpose of this SRS is to define the functional and non-functional requirements for an online library management system. The system automates the management of library resources (books, e-books, users, infrastructure, etc.) to improve operational efficiency, provide user-friendly access to services, and support scalability for future enhancements.

### 1.2 Scope
The Online Library Management System enables clients, librarians, and administrators to manage library resources and services. Key features include searching and borrowing books, user registration and authentication, room/parking reservations, and fine management. The system supports both physical and digital assets, with a focus on scalability (up to 1,000 concurrent users), security (encrypted data), and performance (response time <2 seconds). The system is built using Java, Spring Boot, PostgreSQL, and a simple frontend (Thymeleaf or React), with version control on GitHub.

### 1.3 Definitions, Acronyms, and Abbreviations
- **OPAC**: Online Public Access Catalog, the user-facing search interface.
- **RFID**: Radio-Frequency Identification, used for tracking physical materials.
- **SRS**: Software Requirements Specification.
- **CRUD**: Create, Read, Update, Delete operations.
- **API**: Application Programming Interface.
- **HTTPS**: Hypertext Transfer Protocol Secure, for encrypted communication.

### 1.4 References
- IEEE 830-1998: Recommended Practice for Software Requirements Specifications.
- ISO/IEC 12207: Systems and Software Engineering – Software Life Cycle Processes.
- Resource List: [docs/resources.md](resources.md).

### 1.5 Overview
This SRS is organized as follows:
- Section 2: Functional Requirements for core system features.
- Section 3: Non-Functional Requirements for performance, scalability, and security.
- Section 4: Requirements Traceability Matrix to map requirements to system components.

## 2. Functional Requirements

### 2.1 Book Search (FR1)
- **Description**: Users (clients, librarians) can search for books by title, author, or ISBN through the online catalog (OPAC).
- **Input**: Search query (title, author, or ISBN).
- **Output**: List of matching books with details (title, author, ISBN, availability).
- **Constraints**: Search results must display within 2 seconds.
- **Priority**: High.

### 2.2 User Registration and Authentication (FR2)
- **Description**: Users (clients, librarians, administrators) can register and log in to access system features.
- **Input**: User details (name, email, password) for registration; email and password for login.
- **Output**: User account creation confirmation or successful login with role-based access.
- **Constraints**: Passwords must be encrypted; role-based permissions enforced (e.g., clients cannot access admin features).
- **Priority**: High.

### 2.3 Book Checkout and Return (FR3)
- **Description**: Clients can borrow books, and librarians can process checkouts and returns. The system sends reminders for overdue books.
- **Input**: User ID, Book ID for checkout/return; system-generated reminders for overdue items.
- **Output**: Updated borrowing status, fine calculation (if applicable), and email/SMS reminders.
- **Constraints**: Borrowing history must be tracked; reminders sent 24 hours before and after due dates.
- **Priority**: High.

### 2.4 Room and Parking Reservation (FR4)
- **Description**: Users (clients, librarians) can reserve reading rooms or parking spaces for specific dates and times.
- **Input**: Room/Parking Space ID, Date, Time, User ID.
- **Output**: Confirmation of reservation or error if unavailable.
- **Constraints**: Reservations must check availability in real-time; conflicts must be prevented.
- **Priority**: Medium.

### 2.5 Fine Management (FR5)
- **Description**: The system calculates and tracks fines for overdue, lost, or damaged books, with payment options for clients.
- **Input**: User ID, Book ID, Fine Reason (overdue, lost, damaged), Payment Details.
- **Output**: Fine record, payment confirmation, and updated user account status.
- **Constraints**: Fines must be calculated automatically based on library policies (e.g., $1/day for overdue books).
- **Priority**: Medium.

## 3. Non-Functional Requirements

### 3.1 Performance (NFR1)
- **Description**: The system must respond to user requests (e.g., search, login, checkout) within 2 seconds under normal load.
- **Measurement**: API response time measured using tools like Postman or JMeter.
- **Priority**: High.

### 3.2 Scalability (NFR2)
- **Description**: The system must support up to 1,000 concurrent users without performance degradation.
- **Measurement**: Load testing to ensure system stability at peak usage.
- **Priority**: High.

### 3.3 Security (NFR3)
- **Description**: User data (e.g., names, emails, passwords, borrowing history) must be encrypted, and communication must use HTTPS.
- **Measurement**: Compliance with AES-256 for data encryption and SSL/TLS for network security.
- **Priority**: High.

### 3.4 Usability (NFR4)
- **Description**: The system must provide an intuitive interface for clients, librarians, and administrators.
- **Measurement**: User feedback during acceptance testing; average task completion time <1 minute for common tasks (e.g., book search).
- **Priority**: Medium.

### 3.5 Maintainability (NFR5)
- **Description**: The system must be modular to facilitate updates and bug fixes by a solo developer.
- **Measurement**: Codebase follows Spring Boot best practices; updates take <2 hours for minor features.
- **Priority**: Medium.

## 4. Requirements Traceability Matrix

The following table maps requirements to system components and tracks implementation status.

| Requirement ID | Description 				| System Component 				     | Status 	       |
|----------------|--------------------------------------|----------------------------------------------------|-----------------|
| FR1 		 | Book Search 				| API `/books/search` 				     | Not Implemented |
| FR2 		 | User Registration and Authentication | API `/users/register`, `/users/login` 	     | Not Implemented |
| FR3 		 | Book Checkout and Return 		| API `/circulation/checkout`, `/circulation/return` | Not Implemented |
| FR4		 | Room and Parking Reservation 	| API `/reservations`    			     | Not Implemented |
| FR5		 | Fine Management 			| API `/fines` 					     | Not Implemented |
| NFR1		 | Performance (<2s response) 		| All APIs 					     | Not Tested      |
| NFR2		 | Scalability (1,000 users) 		| System Architecture 				     | Not Tested      |
| NFR3 		 | Security (Encryption, HTTPS) 	| Authentication Module, Network Layer 		     | Not Implemented |
| NFR4 		 | Usability 				| Frontend (Thymeleaf/React) 			     | Not Implemented |
| NFR5		 | Maintainability 			| Codebase Structure 				     | Not Implemented |

## 5. Assumptions and Constraints

### 5.1 Assumptions
- Users have basic computer literacy to interact with the online catalog.
- The system will be hosted on a cloud provider (e.g., AWS, Heroku) with PostgreSQL support.
- Initial development focuses on core features (book search, user management, circulation) for the MVP.

### 5.2 Constraints
- Developed by a solo developer, limiting parallel task execution.
- Budget constraints require open-source tools (e.g., IntelliJ IDEA Community Edition, PostgreSQL).
- Initial deployment targets a single library with potential for multi-library support in the future.

## 6. Future Enhancements
- Interlibrary loans for resource sharing.
- AI-powered book recommendations based on borrowing history.
- Mobile app (M-OPAC) for remote access to services.

## 7. Approval
This SRS will be reviewed and updated iteratively during sprints, with changes tracked in the GitHub repository.

---
**Last Updated**: May 26, 2025