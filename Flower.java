package servlet;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.ToString;

@Builder
@Setter
@Getter
@ToString
public class Flower {

    private String name;
    private String color;
    private String many;


}
