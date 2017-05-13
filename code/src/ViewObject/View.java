package ViewObject;

import java.io.IOException;

import Dependance.Dependance;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class View {
	public Dependance dependance;
	private Stage primaryStage;
	public View(Dependance dependance){
		this.dependance = dependance;
		primaryStage = (Stage) this.dependance.get("stage");
	}
	
	public void callView(String url, String title, Object controller){
		try {
			this.callViewScene(url, title, controller);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


	
	private void callViewScene(String url, String title,  Object controller) throws IOException{

		url = "../view/"+url;
	
		

		// Localisation du fichier FXML.
	      // Cr�ation du loader.
			FXMLLoader fxmlLoader;
	
	    	   fxmlLoader = new FXMLLoader( getClass().getResource(url));
	    
	    	   fxmlLoader.setController(controller);
	      // Chargement du FXML.
	       AnchorPane root = (AnchorPane) fxmlLoader.load();
	       //root.getChildren().setAll( fxmlLoader.load());
	     
	      // Cr�ation de la sc�ne.
	      Scene scene = new Scene(root);
	     
	      
	      
	      //Scene scene2 = primaryStage.getScene();
	    
	      
	      primaryStage.setScene(scene);
	      primaryStage.setTitle(title);
		  primaryStage.show();
		  
	}
	
}