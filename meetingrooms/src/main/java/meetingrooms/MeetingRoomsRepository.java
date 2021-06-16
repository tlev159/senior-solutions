package meetingrooms;

import java.util.List;

public interface MeetingRoomsRepository {

    void save(MeetingRoom meetingroom);

    List<String> findAllByName();

    List<String> findAllReverseOrder();

    List<MeetingRoom> findAllWithAreaReverseOrderByArea();

    MeetingRoom findMeetingRoomByName(String name);

    MeetingRoom findMeetingRoomByAPieceOfTheName(String name);

    MeetingRoom findMeetingRoomByArea(int area);

    void deleteAll();
}
