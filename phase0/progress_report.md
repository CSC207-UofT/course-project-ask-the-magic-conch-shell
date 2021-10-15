**Progress Report for Phase0 - Team Magic Conch Shell**

The report should include:

A brief summary of your specification, CRC model, scenario walk-through, and skeleton program,
open questions your group is struggling with,
what has worked well so far with your design,
and a brief summary of what each group member has been working on and plans to work on next.

1. Brief summery of specification, CRC model, scenario walk-through

Our system is a Library management system that allows people to create account,
borrow and return books, also let staff users to manage the book within the library.
It gives each student account a credit score to make sure they keep up with the
returning date. Each staff account has access to adding new books to
the library inventory and return books from students as well. For more information,
please see specification.md, CRC model.pdf,

2. open question
   For now, we categorize our books with a book abstract class and several subclasses
   with its category. However, we have come to notice that we could also create a public
   enum, with these book categories as constants in this enum. Then create a new parameter
   in book constructor, so we could delete our subclasses.

the question is which way would be better from a clean architecture perspective and why.

3. Things that has worked well so far

We have implemented all entities and manager level classes, for controllers, we have
implemented Inventory controller and has drawn out the skeleton of BorrowBook, ReturnBook,
LoginWindow controllers. For the main, we made a demo with command executor that shows
how is the progrma intended to run.

4. work assign plan for each group member
