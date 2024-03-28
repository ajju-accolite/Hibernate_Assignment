package org.example.entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name="id")
    private int id;
    
    @Column(name="teamname")
    private String teamname;
    
    @Column(name="captainname")
    private String captainname;
      
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    
    private List<Player> players;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getTeamname() {
		return teamname;
	}
	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}

	public String getCaptainname() {
		return captainname;
	}
	public void setCaptainname(String captainname) {
		this.captainname = captainname;
	}

	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	

	@Override
    public String toString() {
        StringBuilder res = new StringBuilder("Team{" +
                "id=" + id +
                 ", teamname=" + teamname +
                ", captainname='" + captainname + '\'' +
                ", Player Name= ");

        for(Player play : players){
            res.append(play.getPlayername()).append(", ");
        }
        res.append("}");
        return res.toString();
    }   
}
