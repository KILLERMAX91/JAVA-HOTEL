package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import Annotation.Model;
import Entity.Utilisateur;
import Session.Session;

@Model(entity="Utilisateur")
public class User extends Parent.ModelParent{
	
	/**
	 * 
	 * @return
	 */
	public Collection<Utilisateur> listUser(){
		Session session = (Session) this.getDependance().get("session");
		PreparedStatement ts;
	
		LinkedList<Utilisateur> users = new LinkedList<Utilisateur>();
		
		try {
			ts = this.getEntityManager().prepareStatement("SELECT * FROM utilisateur LEFT JOIN role ON utilisateur.id_role = role.id WHERE role.id != ?");
			ts.setLong(1, session.getUtilisateur().getId());
			
			ResultSet rs = ts.executeQuery();
			 while (rs.next()) {
				 Utilisateur user = new Utilisateur();
				 
				 user.setId(rs.getLong("utilisateur.id"));
				 user.setLastname(rs.getString("lastname"));
				 user.setFirstname(rs.getString("firstname"));
				 user.setLogin(rs.getString("login"));
				 user.setPassword(rs.getString("password"));
				 
				 Entity.Role role = new Entity.Role();
				 role.setId(rs.getLong("role.id"));
				 role.setTypeRole(rs.getString("type_role"));
				 
				 user.setRole(role);
				 
				 users.add(user);
			 }
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		 return users;
	}
	
	/**
	 * Cette m�thode v�rifie si l'email existe bien
	 * @param mail
	 * @return
	 */
	public boolean MailExist(String mail){

		
		PreparedStatement ts;
	
		
		
		Utilisateur user=null;
		
		
		try {
			ts = this.getEntityManager().prepareStatement("SELECT * FROM utilisateur LEFT JOIN role ON utilisateur.id_role = role.id WHERE mail = ?");
			ts.setString(1, mail);
			
			ResultSet rs = ts.executeQuery();
			 while (rs.next()) {
				 user = new Utilisateur();
				 
				 user.setId(rs.getLong("utilisateur.id"));
				 user.setLastname(rs.getString("lastname"));
				 user.setFirstname(rs.getString("firstname"));
				 user.setLogin(rs.getString("login"));
				 user.setPassword(rs.getString("password"));
				 
				 Entity.Role role = new Entity.Role();
				 role.setId(rs.getLong("role.id"));
				 role.setTypeRole(rs.getString("type_role"));
				 
				 user.setRole(role);
				 
				
			 }
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(user==null){
			return false;
		}else{
			return true;
		}
		 
	}
	
	/**
	 * Cette m�thode v�rifie si le login existe bien
	 * @param mail
	 * @return
	 */
	public boolean LoginExist(String login){
	
		PreparedStatement ts;
		
		Utilisateur user = null;
		
		
		try {
			ts = this.getEntityManager().prepareStatement("SELECT * FROM utilisateur LEFT JOIN role ON utilisateur.id_role = role.id WHERE login = ?");
			ts.setString(1, login);
			
			ResultSet rs = ts.executeQuery();
			 while (rs.next()) {
				 user = new Utilisateur();
				 
				 user.setId(rs.getLong("utilisateur.id"));
				 user.setLastname(rs.getString("lastname"));
				 user.setFirstname(rs.getString("firstname"));
				 user.setLogin(rs.getString("login"));
				 user.setMail(rs.getString("mail"));
				 user.setPassword(rs.getString("password"));
				 
				 Entity.Role role = new Entity.Role();
				 role.setId(rs.getLong("role.id"));
				 role.setTypeRole(rs.getString("type_role"));
				 
				 user.setRole(role);
				 
				
			 }
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(user==null){
			return false;
		}else{
			return true;
		}
	}
	
	
	
	public void insert(Utilisateur user){
		PreparedStatement ts;
		try {
			ts = this.getEntityManager().prepareStatement("INSERT INTO utilisateur(lastname, firstname, password, login, mail, id_role) values (?, ?, ?, ?, ?, ?)");
			ts.setString(1, user.getLastname());
			ts.setString(2, user.getFirstname());
			ts.setString(3, user.getPassword());
			ts.setString(4, user.getLogin());
			ts.setString(5, user.getMail());
			ts.setLong(6, user.getRole().getId());
			ts.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void remove(Utilisateur user){
		PreparedStatement ts;
		try {
			ts = this.getEntityManager().prepareStatement("DELETE FROM utilisateur WHERE id = ?");
		
			ts.setLong(1, user.getId());
			ts.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
