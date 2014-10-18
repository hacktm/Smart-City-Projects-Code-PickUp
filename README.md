Smart-City-Projects-Code-PickUp
===============================

Mentor-
Nu stim cum il cheama, tipu ala cu laptop apple avea un badge lol :))
Devs:
Lucian Stefanoaica,
Leonardocezary Ioan Chisciuc,
Stefan Ghitescu.

PRODUCT INFORMATION
-------------------
Shopping Assistant (food only, can be extended to other types of products)

Requirements:
- shopping list (add item, remove item, item to be bought)
- alternatives for the same product
- owned product list
- details for the product (price, brand, name, quantity)
- touchscreen android mobile app(view)
- web service (controller)
- database (model)

Use case 1 (basic flow):
- create shopping list (1 list)
- add items (show alternatives)
- check bought items
	-> item added to bought list
- show bought list (full)

Use case 2 (extras):
- add from bought list to shopping list
- browse database for products from each market
- app proposes from where to buy the item/s


Mobile app:
--> Main view:
	- show bought list
	--> Bought view:
		- check box (re-add to shopping list)
	- show shopping list
	--> Shopping view:
		- add new item
		- remove item
		- check box (for bought item) --> move to bought list

PC, Web service (tomcat):
--> receive JSON file from mobile app
	- parsing
	- insert in db
	- delete from db
	- populate db with items

PC, Database (sqlite):
--> bought list
--> shopping list
--> main product list

DB structure:
Food Table
price, brand, type, market

Shopping List Table
price, brand, type, quantity, market

Bought List Table
price, brand, type, quantity, market


WHAT WORKS
----------
web service (query db, receive json, send json)
mobile app (send json, receive json)
