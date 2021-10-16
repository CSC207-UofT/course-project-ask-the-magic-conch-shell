**Specification**

Create a library management system that allows students to borrow and return books with the help of a library staff.

Students need to register a student account in order to borrow and return books. A newly registered student account 
would have a default credit score of 100 and an empty current-borrowing record. Students are able to login using their 
username and password, and can change their password. Each student is able to access their own credit scores and 
current-borrowing record. Each student account can borrow at most five books at a time, the number of books students can
borrow depends on their credit score **(detailed _conditions_ attached below)**.

Each book is given a unique ID when storing into the library, along with their name, ISBN, published date, author, 
status(whether it is lent or not) and its Return Date. All books would be stored in the inventory.

Each library staff would use a staff account that has different access than student accounts. Staff accounts are able 
to add new books and delete damaged books from inventory. Their accounts can also change the status of books when books 
are borrowed and returned. Besides, staff accounts are able to access all student accounts’ credit scores and 
current-borrowing records, and can manually edit student accounts’ credit scores.

If students wanted to borrow a book, their credit scores and the status of the book that they want to borrow would be 
checked. If conditions are met, the book would be successfully borrowed. Students can request to extend their return 
dates under certain **_conditions._**

>_**Conditions:**_
> 
>The credit score starts at 100, and maximum is also 100.
> 
> - For each day each book is returned after the Return Date, 5 points will be deducted off of the student's current credit score.
>
> 
>- If the credit score is not at 100, and the student returned the book on time, then their credit score can increase 3 points.
> 
>If:
> 
> credit score >= 80,  the student can borrow up to 5 books at a time. They can extend the return deadline of the book 
> by a week, and the request will be approved automatically;
> 
> credit score >= 50, the student can borrow up to 4 books at a time, and will not be able to extend the return deadline;
> 
> credit score >= 10, the student can borrow 1 book at a time. and will not be able to extend the return deadline;
> 
> credit score < 10,  the student will not be able to borrow book anymore.
