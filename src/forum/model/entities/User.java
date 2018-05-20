package forum.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "user")
public class User implements Serializable, DatabaseEntity {

	public User() { }
	
	private static final long serialVersionUID = -6435980634495906249L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "login")
	private String login;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;

	@Column(name = "date_reg")
	@Temporal(TemporalType.DATE)
	private Date registerDate;
	
	@OneToMany(
		mappedBy = "author",
		cascade = CascadeType.ALL,
		fetch = FetchType.EAGER)
	Set<Topic> postedTopic;
	
	public Integer getId() {
		return id;
	}
	public String getLogin() {
		return login;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public Set<Topic> getPostedTopic() {
		return postedTopic;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public void setPostedTopic(Set<Topic> postedTopic) {
		this.postedTopic = postedTopic;
	}
	
}
