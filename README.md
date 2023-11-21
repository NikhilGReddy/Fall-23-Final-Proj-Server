# Fall-23-Final-Proj-Server

Objective:
Online Auction Server handles customer bidding and selling of several items.
Java Concepts:
- Server-Client Architecture
- Java Server
- Client Sockets,
- Multithreading,
- JavaFX Graphics,
- Data Structures, And
- OOP Concepts

Database/ Data/ File Design:
Item Auction
- Id (auto-increment #, unique)
- Item Name
o unique names that are single words
- Description (extra credit –v1)
- Item Image Ref (extra credit –v2)– Assuming Multiple images
- Starting price &gt; 0 (extra credit –v1) (Double)
- Min. Acceptable Price (Double)
- Buy It Now Price (extra credit –v1) (Double)
- Current Max Bid Ref (Bids id ref)
- Current Max Bid Price – From Bids (Double)
- Item Auction End Date (extra credit –v2)
- Item Auction End Time (extra credit –v2)
- Status
o Sold
 Sold to customer
 Current Max Bid Ref fields holds the bid that won
o Available
 Auction In Progress
o Draft
 Not yet available for Auction

Item Images File Ref (extra credit –v2)
- Id (auto-increment #, unique)
- Image Name (unique)
- Image Ref
- For Item
Customer
- Id (auto-increment #, unique)
- Email (unique)
- Name

Bids
- Id (auto-increment #, unique)
- Bid Number
- Customer (id ref)
- Item Auction (id ref)
- Bid Amount (Double)

Server Backend
- Use a cloud server to host the auction Server. (extra credit –v1/v2)
- Use Apache Derby or other database. (extra credit –v1/v2)
- A valid bid is a bid that is greater than the previous high bid for that item and on an item
whose auction is not closed.
- New bid
o inform all active customers of the new highest bid
- Item Auction termination mechanism
o set price being met
o time running out (extra credit –v2)
o server somehow terminating the auction (not needed)
- Item Auction termination rules
o Status = Sold
o Do not accept bids at this time.
o Notify clients that the bidding is closed, and highest bid has been accepted, with $
information
- Concurrency requirements
o 5 auction items
o 5 customers
o Concurrent bidding on 5+ items be allowed
o proper synchronization so that multiple clients can bid on the same item at the
same time in a thread-safe way
- Server console logs for debugging
Client GUI And Client Backend
- JavaFX graphical user interface. Must use only JavaFX for the GUI.
- Using the Observable class and Observer interface. (extra credit –v1)
- Login screen
o User name / Email
o Password (extra credit –v2)
- Items available to Bid
o List – Show the latest bid, as the update happens without updating the whole
screen
o As show pop-up with most recent highest bid

- Item Details
o Show Status
o Show the current highest bid
o Bid on item
 Valid vs Invalid
 Show reason for bid
o See the history of bids
 Amount, who (extra credit –v1)
- Closed Items for Bid (extra credit –v2)
o buyer and the selling price
- Log out
- Search Features (extra credit –v3)
- Sound effects. (extra credit –v3)
- Nice GUI in general. (extra credit –v1)
- Count down clocks for items. (extra credit –v2)
Additional Rules
- Sockets between Client and Server
- Multiple machines Testing
- During testing, no Java source file should be shared between the server and customers
or between customers. Make separate Eclipse (or other IDE) projects for the server and
customer, and duplicate files as necessary across projects.
- Your code should not throw Exceptions under normal operation. For example, if the
server terminates normally (such as when the auction time-out happens), or a client
leaves normally, there should be no uncaught exception thrown.
- The server’s top class (containing main) should be called Server, and the client’s top class
should be called Client.
- Follow good style, synchronization, and OOP practices.
- Cryptography techniques – encryption of passwords, password hashing and salting,
encryption of messages. (extra credit –v2)
-
Need to confirm
 Non-volatile history of auctions, customer activity etc. What does this mean?
