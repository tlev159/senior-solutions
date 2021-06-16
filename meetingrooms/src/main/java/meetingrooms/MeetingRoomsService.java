package meetingrooms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MeetingRoomsService {

    private MeetingRoomsRepository meetingRoomsRepository;

    public MeetingRoomsService(MeetingRoomsRepository meetingRoomsRepository) {
        this.meetingRoomsRepository = meetingRoomsRepository;
    }

    public void save(MeetingRoom meetingRoom) {
        meetingRoomsRepository.save(meetingRoom);
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

    public List<MeetingRoom> findAllWithAreaReverseOrderByArea() {
        return meetingRoomsRepository.findAllWithAreaReverseOrderByArea();
    }

    public MeetingRoom findMeetingRoomByName(String name) {
        return findMeetingRoomByName(name);
    }

    public MeetingRoom findMeetingRoomByAPieceOfTheName(String name) {
        return meetingRoomsRepository.findMeetingRoomByAPieceOfTheName(name);
    }

    public MeetingRoom findMeetingRoomByArea(int area) {
        return meetingRoomsRepository.findMeetingRoomByArea(area);
    }

    public void deleteAll() {
        meetingRoomsRepository.deleteAll();
    }

}
