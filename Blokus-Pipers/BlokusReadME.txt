ReadMe blokus 

Blokus is coposite of nine package seven for the game and two for the test

package
	blokus.pipers :
		contain the class :
			Blokus.pipers.java 
				this is the main class, this class launch the game for play in console mode
		
	esi.atl.g39864.blokus.model.io:
		contain the class :
			ReadFile.java			this the class allows to read the file text container the list of the stock of the player
									and create a list of four stock for each player
	
	esi.atl.g39864.blokus.ia.model:
		contain the class :
			AnalyzePos.java			this class create a list of position for the ia know the position possible for played
			Context.java			this class allows to change the strategy of the ia
			PlayIAMostScore.java	this class allows to make play the ia for fine the best piece for to mark the most point (is not termined)
			PlayIARandom.java		this class allows to make play the ia to selected the piece and the position so random (is not termined)
			Strategy.java			this is an interface for applicate the method play of the class implemented it
			
	esi.atl.g39864.blokus.mvc1:
		contain the class :
			Observer.java			this class allows to have a observer after each modification
			Subject.java			this interface allows of the class implement him to be a subject and add it
									and notify it if there is one change
									
	esi.atl.G39864.blokus.view.Console:
		contain the class :
			Display.java					this class allows to displayed he different element of the game
			Treatment.java					this class allows to play the game and treat each element 
			
	esi.atl.G39864.blokus.view.javaFx :
		contain the class :
			ArreterButtonHandler			this method allows to make the action stop the game for the current player
											where the button arreter is clicked
			BarMenu							this class allows to build the MenuBar of the game Blokus
			GridPaneBoard					this class allows to build the GridPane who represent the Board of the game
			GridPanePieces					this method allows to build the gridpanePiece for each piece of each stock of
											each player
			GridPaneStock					this mehtod allows to build the gridpanestock container each stock and
											information on each player
			HBoxAction						this class allows to build a HBox with the four action possible, Nouvelle
											Partie, Passer, J'arrête and Tourner
			HBoxCentrale					this class allows to build the HBox central with the VBox of left and the
											GridPane of right
			HBoxTextPlayer					this class allows to build hboxTextplayer container the different information
											of the player
			MirrorsButtonHandler			this class allows to make the action mirrors on a piece when the button
											mirror is pressed
			NouvellePartieButtonHandler		this class allows to make the action nouvelle partie when the button nouvelle
											partie is clicked
			PasserButtonHandler				this class allows to actionned the action of passed the turn of the player
											when the button passed of the game is clicked
			TournerButtonHandler			this class allows to actionned the action of turn piece when the button 
											tourner of the game is clicked
			VBoxGlobal						this class allows to build the VBox global with all Layout of the game,
											MenuBar, HBox central and HBox with the action
			VBoxLeft						this class allows to build the left VBox with the four VBox who contain the
											four Stock of each Player
			VBoxStock						this class allows to build the vbox container four gridPaneStock
			launchFx						this class allows to launch the javaFx application
			
	esi.atl.gg39864.blokus.model :
		contain the class :
			Board							this class initialize a Board of Piece, the size is 20 * 20
			Color							this Enumeration is the enumeration of the Color of the Piece
			Game							this method allows to play the game make the all of treatment of the game.
			Piece							this class build the Piece
			Player							this is the class for create a List of four new Players or modified her
											argument
			PlayerManager					this class allows to create a List of four Player and manager it
			Position						this class allows to build a position and use it
			Score							this class allows to build a score and manage it
			Stock							this class allows to build a Stock
	
	esi.atl.G39864.Blokus.Mode.IO.test :
		contain the class :
			ReadFileTest					this class test the method of ReadFile 
			
	esi.atl.G39864.Blokus.Model.test :
		contain the class : 
			BoardTest						this class test the method of the class board 
			PieceTest						this class test the method of the class piece
			PositionTest					
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			