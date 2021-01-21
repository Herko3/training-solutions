package week12.d04;

import java.util.*;

public class Clients {

    Map<String, Client> clientMap = new HashMap<>();

    public void addClient(String name, String regNumber) {
        Client client = new Client(name, regNumber);
        clientMap.put(regNumber, client);
    }

    public Client findByRegNumber(String toSearch) {
        if (clientMap.containsKey(toSearch)) {
            return clientMap.get(toSearch);
        }
        throw new IllegalArgumentException("No client with such regNumber");
    }

    public List<Client> findByName(String namePart) {
        List<Client> found = new ArrayList<>();
        for (Client client : clientMap.values()) {
            if (client.getName().contains(namePart)) {
                found.add(client);
            }
        }
        return found;
    }

}
