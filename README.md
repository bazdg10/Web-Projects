# Uni Web Dev

######################################################################################

# Flight Booking App
# React | Java Spring Boot | MySQL

Show User the available flights by retrieving data from Database.<br />
Allow users can sort the flight by route (start->end), prices and timinngs<br />
Data is rendered based on the time user logs in
Data in the database is removed if time for flight is behind time of request<br />

Admin can add data but data is always added in sorted order so adding flights might be slower<br />
By default the flights are added and the database is sorted in the order of increasing time<br /><br />

Database<br />

FLIGHT<br />
>id<br />
departure<br />
arrival<br />
start<br />
destination<br />


######################################################################################
<br />

# Shopping App
# React | Java Spring Boot | Spring Security | PostgreSQL

This app has a cart feature as well!<br />
Simple UI that shows users the product's type, picture, price and the discount available on those products<br />
Cart displays the user all this being added to the cart |  These can be sorted accoring to type of product (Done in frontend) <br />
<br /><br />

When admin adds product / discount to a product, data is stored in the database by sorting the elements as per the end discount date <br />
If there is no discount, the product is treated as if it has MAX value for end date of discount<br />

Databases<br />

ITEM<br />
>id<br />
type<br />
name<br />
discount<br />
image<br /><br />

CART<br />
>id<br />
user_id<br />
itemList[Item]<br /><br />


USER<br />
>id<br />
name<br />
password<br />
card_id<br /><br />

#######################################################################################
<br />

# ALL APPS ARE DONE ASSUMING USER WILL USE THE APP MORE FREQUENTLY THAN THE ADMIN

