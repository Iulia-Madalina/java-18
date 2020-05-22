package jdbc;

import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
public class AccomodationToRoomFairRelation {

    private int id;

    private int id_accomodation;

    private int id_room_fair;

    public void setId(int id) {
        this.id = id;
    }

    public void setId_accomodation(int id_accomodation) {
        this.id_accomodation = id_accomodation;
    }

    public void setId_room_fair(int id_room_fair) {
        this.id_room_fair = id_room_fair;
    }
}
