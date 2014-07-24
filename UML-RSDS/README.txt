The structure of this specification is 'agent-based': each player role (goal-keeper, defender, midfielder, etc) 
has its own reactive behaviour, defined by the Player
operations goalkeeperaction, defenderaction, etc. The transformation creates a new Update instance and populates 
its actions by invoking the behaviour operations on each of the players in turn. The player with the ball is in 
charge of coordinating other players: if a player needs to pass the ball to another, then he requests the 
other player to move to the appropriate position, and this overrides their intrinsic behaviour. 
For attack, as many non-defender players are pushed as far forwards as possible. Any of these can shoot at goal. 
For defence, players track back to follow the ball, and defenders try to intercept the ball.

An alternative, more declarative approach would be to have separate transformation rules for each case of a 
player role and game situation, for example:

number = 1 & ball.size > 0  =>
    ShootBall->exists( sb | sb.player = 1 & ... )

This would probably be less efficient, however.

Only a client for the Blue player (connecting first to the server) is implemented, this is invoked by:

  java SoccerClientBlue <port>

where <port> is the port number. 



There is a single use case: 

Use Case, name: play
Parameters: []
Result type: null
Superclass: null
Description: 
Postcondition 0 is: 
   theball = Ball->any() & goalkeeper = GoalKeeper->select(team /= "RED")->any() & 
   player5 = FieldPlayer->select(team /= "RED" & number = 5)->any() & 
   player2 = FieldPlayer->select(team /= "RED" & number = 2)->any() & 
   player3 = FieldPlayer->select(team /= "RED" & number = 3)->any() & 
   player4 = FieldPlayer->select(team /= "RED" & number = 4)->any() & 
   player6 = FieldPlayer->select(team /= "RED" & number = 6)->any() & 
   player7 = FieldPlayer->select(team /= "RED" & number = 7)->any() & 
   player8 = FieldPlayer->select(team /= "RED" & number = 8)->any() & 
   player9 = FieldPlayer->select(team /= "RED" & number = 9)->any() => 
      Update->exists( u | goalkeeper.goalkeeperaction(u) & player5.cmaction(u,theball) & 
                          player2.defenderaction(u,theball) & player3.defenderaction(u,theball) & 
                          player4.midfielderaction(u,theball) & player6.midfielderaction(u,theball) & 
                          player7.midfielderaction(u,theball) & player8.midfielderaction(u,theball) & 
                          player9.midfielderaction(u,theball) ) 


This uses the following operations: 

*** Operations of entity Ball:

blueTeamhasBall(): boolean
pre: true
post: player.size > 0 & "RED" /: player.team => result = true


*** Operations of entity Player:

cmaction(u: Update,theball: Ball)
pre: true
post: ( ball.size > 0 & field.xPos < 39 => 
           MovePlayer->exists( m | m.playerNumber = number & m.xDist = 2 & m.yDist = 0 & m : u.actions ) ) & 
      ( ball.size > 0 & field.xPos >= 39 => 
           ShootBall->exists( m | m.playerNumber = number & m.xDist = 44 - field.xPos & m.yDist = 0 & m : u.actions ) ) & 
      ( theball.blueTeamhasBall() = false => moveToBall(u,theball) )

"If the player 5 has the ball, not near to the red goal, then he should move forwards. If he is close to the goal, 
he should shoot. Otherwise, if he does not have the ball, he should move to the ball if the blue team does not have 
the ball."


withinShootingDist(x: int,y: int): boolean
pre: true
post: ( field.xPos - x <= 7 & field.xPos - x >= -7 & field.yPos - y <= 7 & field.yPos - y >= -7 => result = true ) & 
      ( field.xPos - x > 7 or field.xPos - x < -7 or field.yPos - y > 7 or field.yPos - y < -7 => result = false )



goalkeeperaction(u: Update)
pre: true
post: ( ball.size > 0 => ShootBall->exists( a | a.playerNumber = number & a.xDist = 7 & a.yDist = -3 & a : u.actions ) & 
                         MovePlayer->exists( m | m.playerNumber = 5 & m.xDist = -3 & m.yDist = -3 & m : u.actions ) )

"The goalkeeper shoots and passes to player 5". 


defenderaction(u: Update,theball: Ball)
pre: true
post: ( ball.size > 0 & field.xPos < 22 => 
          MovePlayer->exists( m | m.playerNumber = number & m.xDist = 2 & m.yDist = 0 & m : u.actions ) ) & 
      ( ball.size > 0 & field.xPos >= 22 & field.yPos <= 12 => 
          ShootBall->exists( s | s.playerNumber = number & s.xDist = 0 & s.yDist = 4 & s : u.actions ) ) & 
      ( ball.size > 0 & field.xPos >= 22 & field.yPos > 12 => 
          ShootBall->exists( s1 | s1.playerNumber = number & s1.xDist = 0 & s1.yDist = -4 & s1 : u.actions ) ) & 
      ( ball.size = 0 & theball.blueTeamhasBall() & field.xPos < 22 => 
          MovePlayer->exists( mp | mp.playerNumber = number & mp.xDist = 2 & mp.yDist = 0 & mp : u.actions ) ) & 
      ( theball.blueTeamhasBall() = false => moveToBall(u,theball) )


"If the defender has the ball in his own half, move forward. If he reaches the half-way line, pass the ball to 
a team-mate. Otherwise, if he doesn't have the ball but the blue team has the ball, move up to the half-way 
line. If the blue team does not have the ball, move to the ball."



moveToBall(u: Update,b: Ball)
pre: true
post: 
  ( field.xPos > b.field.xPos & field.yPos > b.field.yPos => 
      MovePlayer->exists( mp | mp.playerNumber = number & mp.xDist = -Set{( field.xPos - b.field.xPos ),3}->min() & 
                               mp.yDist = -Set{( field.yPos - b.field.yPos ),3}->min() & mp : u.actions ) ) & 
  ( field.xPos > b.field.xPos & field.yPos <= b.field.yPos => 
      MovePlayer->exists( mp1 | mp1.playerNumber = number & mp1.xDist = -Set{( field.xPos - b.field.xPos ),3}->min() & 
                                mp1.yDist = Set{( b.field.yPos - field.yPos ),3}->min() & mp1 : u.actions ) ) & 
  ( field.xPos <= b.field.xPos & field.yPos > b.field.yPos => 
      MovePlayer->exists( mp2 | mp2.playerNumber = number & mp2.xDist = Set{( b.field.xPos - field.xPos ),3}->min() & 
                                mp2.yDist = -Set{( field.yPos - b.field.yPos ),3}->min() & mp2 : u.actions ) ) & 
  ( field.xPos <= b.field.xPos & field.yPos <= b.field.yPos => 
      MovePlayer->exists( mp3 | mp3.playerNumber = number & mp3.xDist = Set{( b.field.xPos - field.xPos ),3}->min() & 
                                mp3.yDist = Set{( b.field.yPos - field.yPos ),3}->min() & mp3 : u.actions ) )

"Move so as to reduce the distance to the ball"



midfielderaction(u: Update,theball: Ball)
pre: true
post: 
  ( ball.size > 0 & field.xPos >= 37 & 2 <= field.yPos & field.yPos <= 22 => 
      ShootBall->exists( sb | sb.playerNumber = number & sb.xDist = 44 - field.xPos & sb.yDist = Set{( 22 - field.yPos ),( field.yPos - 2 )}->min() & sb : u.actions ) ) & 
  ( ball.size > 0 & field.xPos < 37 => 
      MovePlayer->exists( mp | mp.playerNumber = number & mp.xDist = 2 & mp.yDist = 0 & mp : u.actions ) ) & 
  ( ball.size > 0 & field.xPos >= 37 & field.yPos < 2 => 
      MovePlayer->exists( mp1 | mp1.playerNumber = number & mp1.xDist = 0 & mp1.yDist = 2 & mp1 : u.actions ) ) & 
  ( ball.size > 0 & field.xPos >= 37 & field.yPos > 22 => 
      MovePlayer->exists( mp2 | mp2.playerNumber = number & mp2.xDist = 0 & mp2.yDist = -2 & mp2 : u.actions ) ) & 
  ( ball.size = 0 & field.xPos < 42 & theball.blueTeamhasBall() => 
      MovePlayer->exists( mp3 | mp3.playerNumber = number & mp3.xDist = 2 & mp3.yDist = 0 & mp3 : u.actions ) ) & 
  ( theball.blueTeamhasBall() = false => moveToBall(u,theball) )

"If the midfielder has the ball and can shoot to goal, do so. Otherwise, if he has the ball, move forward to a 
scoring position. If he doesn't have the ball but the blue team has the ball, move forwards to be close to goal. 
If the blue team does not have the ball, move to the ball."

