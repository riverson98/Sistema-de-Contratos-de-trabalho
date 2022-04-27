package entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class HourContract {
    private Date date;
    private Double valuePerHour;
    private Integer hours;

    public HourContract() {
    }

    public double totalValue() {
        return valuePerHour * hours;
    }
}