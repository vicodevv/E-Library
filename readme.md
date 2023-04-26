# Library-store	
A spring boot web application for managing a small library. The application has a frontend interface and a backend (admin) interface. Library Managers can add books to the library's collection via the admin interface. Customers can browse for books, borrow and return the books via the frontend interface. They can see past books they have borrowed. When a book has exceeded it's rental period, an automatic mail is being triggered to remind the customer to return it.

## Technologies
- Spring Boot
- Angular
- MySQL

## Features
- Login/Register
- Admin Interface
- searching for books
- pagination
- book borrow system
- user list (activating/deactivating, deleting..)
- Create/Read/Delete operations for copies, books, authors and categories

## Security
Project provides authentication and authorization with JWT Spring Security.
There are parts of application available for not logged users, and parts that require specific
permissions.
> User types:
- not logged in
- unauthorized
- authorized
- admin

<img src="https://user-images.githubusercontent.com/55485439/234560693-0ddf3b27-7751-4a08-8f8f-ca7e6ae1d62b.png" width=700>

User: 
		FirstName
		LastName
		Email
		PhoneNumber
		Address
		
	Roles:
		Admin
		Customers
		
	Book:
		Author
		Title
		PublishedDate
		Category (Enum: Science, Fiction, Arts, Religious, Business, Law, Social)
		PackageType (Enum: Paperback, Hardcover)
		AvailableQuantity (number of books available to borrow)
		TotalQuantity (total books stocked)
		CoverPage (image)
		
	Order:
		User  
		Book
		RequestedDate
		DueDate
		ReturnedDate

