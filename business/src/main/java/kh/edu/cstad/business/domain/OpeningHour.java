
package kh.edu.cstad.business.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OpeningHour {

    @NotNull(message = "Day of week is required")
    private DayOfWeek day;

    @NotNull(message = "Start time is required")
//    @Temporal(TemporalType.TIME)
//    @DateTimeFormat(style = "hh:mm a")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm a")
    private LocalTime startTime;

    @NotNull(message = "End time is required")
//    @Temporal(TemporalType.TIME)
//    @DateTimeFormat(style = "hh:mm a")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm a")
    private LocalTime endTime;

    @NotNull(message = "Over night status is required")
    private Boolean isOvernight;

    public boolean isOpen(LocalTime currentTime) {
        // Handle case where opening time is before closing time on the same day
        if (startTime.isBefore(endTime)) {
            return currentTime.isAfter(startTime) && currentTime.isBefore(endTime);
        } else { // Handle case where opening time is after closing time (e.g., overnight)
            return currentTime.isAfter(startTime) || currentTime.isBefore(endTime);
        }
    }

}
