package unit.test.training.part2.part2_02;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Customer {
    private boolean isSpecialMember;

    public Customer() {
        this.isSpecialMember = false;
    }
}
