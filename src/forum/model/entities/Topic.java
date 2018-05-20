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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "topic")
public class Topic implements Serializable, DatabaseEntity {
	
	public Topic() { }

	private static final long serialVersionUID = -3390766510231376270L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne(
		fetch = FetchType.EAGER,
		targetEntity = User.class)
	@JoinColumn(name = "id_user")
	private User author;
	
	@OneToMany(
		mappedBy = "answerTopic",
		cascade = CascadeType.ALL,
		fetch = FetchType.EAGER)
	private Set<Answer> answers;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "post_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date postDate;

	public Integer getId() {
		return id;
	}
	public User getAuthor() {
		return author;
	}
	public Set<Answer> getAnswers() {
		return answers;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public Date getPostDate() {
		return postDate;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

}
