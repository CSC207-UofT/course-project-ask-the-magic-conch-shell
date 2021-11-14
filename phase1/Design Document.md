**Design Document for Phase 1 - Team Magic Conch Shell**


The document should include:

`1. Updated Specification`

 This is our updated version of [specification](phase1specification.md). Compare to phase0, one of the main changes
is that we add several different Search Algorithm. Student users now can search books by **their ISBN, type and author** 
rather than can just input the book's id before. (UML)
 
Another main change in our functionality is that we implemented **MongoDB** as our database to store all students, staff and 
books data as a method to let the state become persistent across runs of our program. More specifically, we created three
database(student, staff and book) in MongoDB, and we implemented methods that allow us to save, read and update information
of our entities.


`2. Major design decisions`

Interface - spring boot
A description of any major design decisions your group has made (along with brief explanations of why you made them).

MongoDB


`3. Design Patterns`

A summary of any design patterns your group has implemented (or plans to implement).
dependency-injection - refactoring
command



`4. Clean architecture & Packaging strategies`

A brief description of how your project adheres to Clean Architecture (if you notice a violation and aren't sure how to fix it, talk about that too!)
A brief description of which packaging strategies you considered, which you decided to use, and why. (see slide 7 from the packages slides)

code organization


`5. SOLID principle`

A brief description of how your project is consistent with the SOLID design principles (if you notice a violation and aren't sure how to fix it, talk about that too!)


`6. Progress report`

open questions your group is struggling with
if staff forget their password? - admin or let other staff to change?
iml file - library?


what has worked well so far with your design -github features

a summary of what each group member has been working on and plans to work on next