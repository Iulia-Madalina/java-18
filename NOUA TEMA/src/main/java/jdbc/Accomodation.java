package jdbc;

import lombok.Setter;
import lombok.ToString;

//@Setter
@ToString
public class Accomodation {

    private int id;
    private String type;
    private String bedType;
    private int maxGuests;
    private String description;

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public void setMaxGuests(int maxGuests) {
        this.maxGuests = maxGuests;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
