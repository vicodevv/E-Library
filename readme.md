	
Description ::
	Develop a spring boot web application for managing a small library.
	The application should have a frontend interface and a backend (admin) interface.
	Library Managers should be able to add books to the library's collection via the
	admin interface.
	Customers should be able to browse for books, borrow and return the books via the 
	frontend interface.
	They should also be able to see past books they have borrowed.
	When a book has exceeded it's rental period, an automatic mail should be triggered
	remind the customer to return it.
	
Entities (NOTE: Not all possible fields are provided, use your intuition where necessary) ::

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
		
		# library-store
# library-store
