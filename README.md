# CEN4010-BookStore
This feature will allow Users to Create, Retrieve , and update their account information 

Create a User with username, password and optional fields (name, email address, home address)

o Logic: Provided the user fields, create the user in the database.

o HTTP Request Type: POST

o Parameters Sent: User Object

o Response Data: None

 Retrieve a User Object and its fields by their username
 
o Logic: Given a specific username, retrieve the user details.

o HTTP Request Type: GET

o Parameters Sent: Username

o Response Data: JSON User object.

 Update the user and any of their fields except for mail
 
o Logic: Given the username as a key lookup value and any other user field, update that user field with the
new param value.

o HTTP Request Type: PUT / PATCH

o Parameters Sent: Username

o Response Data: None

 Create Credit Card that belongs to a User
 
o Logic: Given a user name and credit card details, create a credit card for that user.

o HTTP Request Type: POST

o Parameters Sent: User name, Credit Card Object

Response Data: None
