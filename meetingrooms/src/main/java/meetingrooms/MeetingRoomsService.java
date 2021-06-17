package meetingrooms;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MeetingRoomsService {

    private MeetingRoomsRepository meetingRoomsRepository;

    public MeetingRoomsService(MeetingRoomsRepository meetingRoomsRepository) {
        this.meetingRoomsRepository = meetingRoomsRepository;
    }

    public boolean save(MeetingRoom meetingRoom) {
        MeetingRoom room = meetingRoomsRepository
                .findMeetingRoomByName(meetingRoom.getName()).orElse(null);
        if (room != null) {
            meetingRoomsRepository.save(meetingRoom);
            return true;
        } else {
            return false;
        }
    }

    public List<String> findAll() {
        return meetingRoomsRepository.findAllByName();
    }

    public List<String> findAllReverseOrder() {
        return meetingRoomsRepository.findAllReverseOrder();
    }

    public List<String> everySecondRoom() {
        List<String> temp = meetingRoomsRepository.findAllByName();
        return IntStream.range(0, temp.size())
                .filter(i -> (i % 2) != 0)
                .mapToObj(n -> temp.get(n)).collect(Collectors.toList());
    }

    public List<String> findAllWithAreaReverseOrderByArea() {
        return meetingRoomsRepository.findAllWithAreaReverseOrderByArea();
    }

    public MeetingRoom findMeetingRoomByName(String name) {
        return meetingRoomsRepository.findMeetingRoomByName(name).orElse(null);
    }

    public List<MeetingRoom> findMeetingRoomByAPieceOfTheName(String name) {
        return meetingRoomsRepository.findMeetingRoomByAPieceOfTheName(name);
    }

    public List<MeetingRoom> findMeetingRoomByArea(int area) {
        return meetingRoomsRepository.findMeetingRoomByArea(area);
    }

    public void deleteAll() {
        meetingRoomsRepository.deleteAll();
    }

}
