package references.socialnetwork;

import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {

    private List<Member> members = new ArrayList<>();

    public void addMember(String name) {
        Member member = new Member(name);
        members.add(member);
    }

    public void connect(String name, String otherName) {
        for (Member search : members) {
            if (search.getName().equals(name)) {
                for (Member connect : members) {
                    if (connect.getName().equals(otherName)) {
                        search.connectMember(connect);
                    }
                }
            }
        }
    }

    public List<String> bidirectionalConnections() {
        List<String> connections = new ArrayList<>();
        for (Member search : members) {
            for (Member  member : search.getConnections()){
                if(member.getConnections().contains(search)){
                    connections.add(search.getName() + " - " + member.getName());
                }
            }
        }
        return connections;
    }

    public Member findByName(String name){
        List<Member> match = new ArrayList<>();
        for (Member search : members){
            if(search.getName().equals(name)){
                match.add(search);
            }
        }
        return match.get(0);
    }

}
