package data;

import Dependance.Dependance;
import Entity.Role;
import Enum.Environment;
import javafx.application.Application;
import javafx.stage.Stage;

public class Fixture extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		Dependance dependance = new Dependance(arg0, Environment.DEV);
		
		
		
		String[][] roles = new String[6][1];
		roles[0][0] = "Directeur de l�h�tel";
		roles[0][1] = "Directeur du restaurant";
		roles[0][2] = "Directeur d�h�bergement";
		roles[0][3] = "Chef de r�ception";
		roles[0][4] = "Gouvernante g�n�rale";
		roles[0][5] = "Gouvernante g�n�rale";
		
		for(int i=0;i<roles.length;i++){
			Role role = new Role();
			role.setTypeRole(roles[i][0]);
			
		}
		
		
	}

}
