package exam02.cv;

import java.util.ArrayList;
import java.util.List;

public class Cv {

    private String name;
    private List<Skill> skills = new ArrayList<>();

    public Cv(String name) {
        this.name = name;
    }

    public void addSkills(String... skillsAsString) {
        try {
            for (String skill : skillsAsString) {
                String parts[] = skill.split(" \\(");
                int level = Integer.parseInt(parts[1].substring(0, 1));
                skills.add(new Skill(parts[0], level));
            }
        } catch (NumberFormatException nfe) {
            throw new IllegalStateException("Number cannot parse");
        }
    }

    public int findSkillLevelByName(String name) {
        for (Skill skill : skills) {
            if (skill.getName().equalsIgnoreCase(name)) {
                return skill.getLevel();
            }
        }
        throw new SkillNotFoundException("No skill with the name:" + name);
    }

    public String getName() {
        return name;
    }

    public List<Skill> getSkills() {
        return new ArrayList<>(skills);
    }
}
