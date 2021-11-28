**Progress Report for Phase 0 - Team Magic Conch Shell**


`1. Brief summary of specification, CRC model, scenario walk-through`

Our system is a Library management system that allows people to create account,
borrow and return books, also let staff users to manage the book within the library.
It gives each student account a credit score to make sure they keep up with the
returning date. Each staff account has access to adding new books to the library inventory and return books from students
as well. For more information, please see [specification](specification.md).

For now, our [CRC model](CRC%20model.pdf) has four main entity classes: (1) An User Abstract class, with its two children: (2) Student and (3) Staff
and (4) Book with some of its subclasses.
Two use cases: (1) UserManager (2) BookManager.
Five controllers: (1) BorrowBook (2) ReturnBook (3) InventoryController (4) LoginWindow (5) Main


Our [Scenario walk-through](walkthrough.md) follows our CRC model and demonstrates two cases from different users' perspectives 
(Student and Staff).


`2. Things that has worked well so far in our skeleton program`

- We have implemented all codes in entities and use case level classes (see **Book, User Package**), for controllers, we have
implemented InventoryController and has drawn out the skeleton of BorrowBook, ReturnBook,
LoginWindow controllers. 


- For the main, we made a demo (see **com.bookSystem.uiDemo package**) with command executor that shows
how our program is intended to run giving input and produce output by using command lines.


- We also implemented several unittest for Book, BookManager and User (Student/Staff) (See **test Package**).


- We have fixed all errors and tried to fix all warnings. However, there are methods and imports in our codes that have 
never been used during phase 0, so we would be able to fix it when we implement more codes in phase 1.

`3. Open questions`

   - For now, we categorize our books with a book abstract class and several subclasses
   with its category. However, we have come to notice that we could also create a public
   enum, with these book categories as constants in this enum. Then create a new parameter
   in book constructor, so we could delete our subclasses. Therefore, our question is that which way would be better 
   from a clean architecture perspective and why.


   - Another question is that we are considering where to throw and catch exceptions in our codes, so it would be nice to
give us some insights about this.



`4. Work assigned & plans for each group member`

**- What we have done:**

Miley (Mileyz023): Organizing specification, scenario walk-through and progress report into file, implement BookManager

Nicole (nzhou27): Organizing and planning method skeleton, Implement UI and main

Vannie (van1): Implementing UserManager, BorrowBook, ReturnBook

Stark (StarkSQ): Implementing Book com.bookSystem.entity, BookManager, LoginWindow com.bookSystem.controller

Kris (lanmanc): Implement User com.bookSystem.entity (student/staff)

Hewitt (Hewitt6): writing subclasses of Book


**- What we are planning on doing:**

Connect com.bookSystem.controller to UI including make UI more user-friendly.

Miley (Mileyz023): Connect LoginWindow (com.bookSystem.controller) to UI

Nicole (nzhou27): Connect BorrowBook(com.bookSystem.controller) to UI

Vannie (van1): Connect ReturnBook(com.bookSystem.controller) to UI

Stark (StarkSQ): Connect Inventory(com.bookSystem.controller) to UI

Kris (lanmanc): Complete testing for UserManager and BookManager(come up with more than one unit test for each method)

Hewitt (Hewitt6): Complete testing for the rest of the entities(come up with more than one unit test for each method)





**Progress Report for Phase 0 - Team Magic Conch Shell**


`1. Brief summary of specification, CRC model, scenario walk-through`

Our system is a Library management system that allows people to create account,
borrow and return books, also let staff users to manage the book within the library.
It gives each student account a credit score to make sure they keep up with the
returning date. Each staff account has access to adding new books to the library inventory and return books from students
as well. For more information, please see [specification](specification.md).

For now, our [CRC model](CRC%20model.pdf) has four main entity classes: (1) An User Abstract class, with its two children: (2) Student and (3) Staff
and (4) Book with some of its subclasses.
Two use cases: (1) UserManager (2) BookManager.
Five controllers: (1) BorrowBook (2) ReturnBook (3) InventoryController (4) LoginWindow (5) Main


Our [Scenario walk-through](walkthrough.md) follows our CRC model and demonstrates two cases from different users' perspectives 
(Student and Staff).


`2. Things that has worked well so far in our skeleton program`

- We have implemented all codes in entities and use case level classes (see **Book, User Package**), for controllers, we have
implemented InventoryController and has drawn out the skeleton of BorrowBook, ReturnBook,
LoginWindow controllers. 


- For the main, we made a demo (see **com.bookSystem.uiDemo package**) with command executor that shows
how our program is intended to run giving input and produce output by using command lines.


- We also implemented several unittest for Book, BookManager and User (Student/Staff) (See **test Package**).


- We have fixed all errors and tried to fix all warnings. However, there are methods and imports in our codes that have 
never been used during phase 0, so we would be able to fix it when we implement more codes in phase 1.

`3. Open questions`

   - For now, we categorize our books with a book abstract class and several subclasses
   with its category. However, we have come to notice that we could also create a public
   enum, with these book categories as constants in this enum. Then create a new parameter
   in book constructor, so we could delete our subclasses. Therefore, our question is that which way would be better 
   from a clean architecture perspective and why.


   - Another question is that we are considering where to throw and catch exceptions in our codes, so it would be nice to
give us some insights about this.



`4. Work assigned & plans for each group member`

**- What we have done:**

Miley: Organizing specification, scenario walk-through and progress report into file, implement BookManager

Nicole: Organizing and planning method skeleton, Implement UI and main

Vannie: Implementing UserManager, BorrowBook, ReturnBook

Stark: Implementing Book com.bookSystem.entity, BookManager, LoginWindow com.bookSystem.controller

Kris: Implement User com.bookSystem.entity (student/staff)

Hewitt: writing subclasses of Book


**- What we are planning on doing:**

Connect com.bookSystem.controller to UI including make UI more user-friendly.

Miley: Connect LoginWindow (com.bookSystem.controller) to UI

Nicole: Connect BorrowBook(com.bookSystem.controller) to UI

Vannie: Connect ReturnBook(com.bookSystem.controller) to UI

Stark: Connect Inventory(com.bookSystem.controller) to UI

Kris: Complete testing for UserManager and BookManager(come up with more than one unit test for each method)

Hewitt: Complete testing for the rest of the entities(come up with more than one unit test for each method)





