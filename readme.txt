Holes: 9

Todo:
-	Make windows and keys work
-	Fullscreenify windows
- 	Write Physics Engine
-	Make More Maps

Procedure:
1) 	make all the windows, bringing forward the start menu.
2) 	when start is pressed from the start menu, make an instance of game.
3) 	start the game loop
	a) 	set the map to hole 1
	b) 	while the ball has not been sunk, keep taking input via shots.
	c)	produce the next position until vel = 0 (method call from a physics engine)
	d) 	after ball has been sunk, tally #shots on a scorecard.
	e) 	move onto the next hole by clearing gamedata, then loading the next map on.
4)	when hole# > 9, exit game loop
5)  show the score for the game for a little bit (new frame), then load the main menu.
 
* All the image handling stuff should be done inside the "map" class.


1080 by 1920
768 by 1366


update 3 june 2014:
put the flag at a random location on the map
when the ball hits the flag, load the next map
when the last map is cleared, end the game.