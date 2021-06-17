package meetingrooms;

import java.util.List;
import java.util.Optional;

public interface MeetingRoomsRepository {

    void save(MeetingRoom meetingroom);

    List<String> findAllByName();

    List<String> findAllReverseOrder();

    List<String> findAllWithAreaReverseOrderByArea();

    Optional<MeetingRoom> findMeetingRoomByName(String name);

    List<MeetingRoom> findMeetingRoomByAPieceOfTheName(String name);

    List<MeetingRoom> findMeetingRoomByArea(int area);

    void deleteAll();
}
