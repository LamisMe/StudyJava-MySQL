package repository.booking;

import model.booking.Booking;

import java.util.List;

public interface IBookingRepository {
    List<Booking> getAll();
    void add(Booking booking);
}
