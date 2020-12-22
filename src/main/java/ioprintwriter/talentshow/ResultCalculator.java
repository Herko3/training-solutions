package ioprintwriter.talentshow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ResultCalculator {

    private List<Production> productions = new ArrayList<>();
    private List<Vote> votes = new ArrayList<>();

    public void readTalents(Path file) {
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                int id = readId(parts[0]);
                productions.add(new Production(id, parts[1]));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }

    public void calculateVotes(Path file) {
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                int id = readId(line);
                countVote(id);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }

    public void writeResultToFile(Path file) {
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(file))) {
            for (Production production : productions) {
                writer.print(production.getId());
                writer.print(" ");
                writer.print(production.getName());
                writer.print(" ");
                int votes = votesById(production.getId());
                writer.println(votes);
            }
            writer.print("Winner: ");
            for(Production production : productions){
                if(production.getId() == idOfMostVotes()){
                    writer.println(production.getName());
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }


    private int readId(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            throw new IllegalStateException("");
        }
    }

    private void countVote(int id) {
        for (Vote vote : votes) {
            if (vote.getId() == id) {
                vote.incNum();
                return;
            }
        }
        votes.add(new Vote(id, 1));
    }

    private int votesById(int id) {
        for (Vote vote : votes) {
            if (vote.getId() == id) {
                return vote.getNumber();
            }
        }
        return 0;
    }

    private int idOfMostVotes() {
        int numberOfVotes = 0;
        Vote mostVotes = null;
        for (Vote vote : votes) {
            if (vote.getNumber() > numberOfVotes){
                mostVotes = vote;
                numberOfVotes = vote.getNumber();
            }
        }
        return mostVotes.getId();
    }

    public List<Production> getProductions() {
        return new ArrayList<>(productions);
    }

    public List<Vote> getVotes() {
        return new ArrayList<>(votes);
    }
}
