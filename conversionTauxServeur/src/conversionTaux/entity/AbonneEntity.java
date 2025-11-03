package conversionTaux.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Abonne")
public class AbonneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAbonne;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String passwd;

    public AbonneEntity() {}

    public AbonneEntity(String login, String passwd) {
        this.login = login;
        this.passwd = passwd;
    }

    // Getters & Setters
    public int getIdAbonne() { return idAbonne; }
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }
    public String getPasswd() { return passwd; }
    public void setPasswd(String passwd) { this.passwd = passwd; }
}
