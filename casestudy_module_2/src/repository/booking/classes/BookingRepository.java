package repository.booking.classes;

import model.booking.Booking;
import repository.booking.IBookingRepository;

import java.util.ArrayList;
import java.util.List;

public class BookingRepository implements IBookingRepository {
    //    private static final String PATH_BOOKING = "src/data/booking.csv";
    private static final List<Booking> bookingList = new ArrayList<>();

    static {
        bookingList.add(new Booking("1", "2023/08/01", "2023/08/01", "2023/08/03", "KH-1111", "SVHO-1111"));
        bookingList.add(new Booking("2", "2023/08/01", "2023/08/01", "2023/08/03", "KH-1111", "SVHO-1111"));
    }

    @Override
    public List<Booking> getAll() {
        return bookingList;
    }

    @Override
    public void add(Booking booking) {
        bookingList.add(booking);
    }
}
