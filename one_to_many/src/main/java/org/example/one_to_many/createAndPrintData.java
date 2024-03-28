package org.example.one_to_many;

import org.example.entity.Player;
import org.example.entity.Team;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.ArrayList;
import java.util.List;

public class createAndPrintData {
    public static void createData(SessionFactory sessionFactory) {   	
    	try(Session session = sessionFactory.openSession()){
    		session.beginTransaction();
    		
    		Team t1 = new Team();
            t1.setTeamname("Cricket 11");
            t1.setCaptainname("Ajay Karode");

            List<Player> list = new ArrayList<>();

            Player p1 = new Player();
            p1.setPlayername("Ajay Karode");
            p1.setNickname("Ajju");
            p1.setSkill("Batsman");
            list.add(p1);

            Player p2 = new Player();
            p2.setPlayername("Mayur Gurjar");
            list.add(p2);

            p1.setTeam(t1);
            p2.setTeam(t1);
            t1.setPlayers(list);
            
            session.persist(t1);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printData(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()){
            System.out.println("Team :  ");
            Team teamlist = session.get(Team.class, 1L);
            System.out.println(teamlist);

            System.out.println("Players :  ");
            List<Player> players = teamlist.getPlayers();
            for (Player player : players) {
                System.out.println(player);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
