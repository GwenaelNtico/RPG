import lombok.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor

public class Team {
    private List<Character> teamMembers;

    public boolean isAllDead(){
        return teamMembers.stream().allMatch(Character::isDead);
    }
}

