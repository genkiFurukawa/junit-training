package utppp.ch07.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class EmailChangedEvent {
    private final int userId;
    private final String newEmail;

    @Override
    public boolean equals(Object o) {
        if (o instanceof EmailChangedEvent) {
            var ev = (EmailChangedEvent) o;
            return (this.userId == ev.getUserId()) && (this.newEmail.equals(ev.getNewEmail()));
        }
        return false;
    }
}
