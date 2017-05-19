package Entity;


import java.io.UnsupportedEncodingException;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import Metier.Crypt;
import Parent.Personne;

@Entity
@Table(name="utilisateur")
public class Utilisateur extends Personne{
	

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_role")
	protected Role role;
	
	@Column(name="password")
	private String password;
	
	@Column(unique=true, name="login")
	private String login;
	
	public String getPassword() {
		return password;
	}
	public void setPasswordCrypt(String password){
		/*String crypt = "hdof,��=)vqfsxgs+�;,";
		if(this.login!=null){
			crypt = this.login;
		}
		
		try {
			this.password = Crypt.get_SHA_512_SecurePassword(password, crypt);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		this.password = password;

	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	public String getMailLastNameFirstName(){
		return this.mail+"_"+this.lastname+"_"+this.firstname;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
}
