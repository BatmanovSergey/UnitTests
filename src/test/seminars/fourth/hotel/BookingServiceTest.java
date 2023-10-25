package seminars.fourth.hotel;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class BookingServiceTest {

// 4.4.
//*
// Вам необходимо написать тест с использованием моков для сервиса бронирования отелей.
// Условие: У вас есть класс HotelService с методом public boolean isRoomAvailable(int roomId),
// который обычно проверяет, доступен ли номер в отеле. Вам необходимо проверить правильность
// работы класса BookingService, который использует HotelService для бронирования номера, если он доступен.
// *
    @Test
    void bookingTestPositive() {
        HotelService hotelService = mock(HotelService.class);
        BookingService bookingService = new BookingService(hotelService);
        when(hotelService.isRoomAvailable(2)).thenReturn(true);

        boolean check = bookingService.bookRoom(2);

        verify(hotelService, times(1)).isRoomAvailable(2);
        assertThat(check).isEqualTo(true);
        assertTrue(check);
    }

    @Test
    void bookingTestNegative() {
        HotelService hotelService = mock(HotelService.class);
        BookingService bookingService = new BookingService(hotelService);
        when(hotelService.isRoomAvailable(1)).thenReturn(false);

        boolean check = bookingService.bookRoom(1);

        verify(hotelService, times(1)).isRoomAvailable(1);
        assertThat(check).isEqualTo(false);
        assertFalse(check);
    }
}