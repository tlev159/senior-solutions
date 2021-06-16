package meetingrooms;

import java.text.Collator;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InMemoryMeetingRoomsRepository implements MeetingRoomsRepository {

    private List<MeetingRoom> meetingRooms = new ArrayList<>();

    Collator collator = Collator.getInstance(new Locale("hu", "HU"));

    @Override
    public void save(MeetingRoom meetingroom) {
        meetingRooms.add(meetingroom);
    }

    @Override
    public List<String> findAllByName() {
        return meetingRooms.stream().map(MeetingRoom::getName).sorted(collator).collect(Collectors.toList());
    }

    @Override
    public List<String> findAllReverseOrder() {
        List<String> temp = new ArrayList<>(findAllByName());
        Collections.reverse(temp);
        return temp;
    }

    @Override
    public List<MeetingRoom> findAllWithAreaReverseOrderByArea() {

        return null;
    }

    @Override
    public MeetingRoom findMeetingRoomByName(String name) {
        Predicate<String> pred = x -> x.equals(name);
//        return meetingRooms.stream().anyMatch();
        return meetingRooms.get(0);
    }

    @Override
    public MeetingRoom findMeetingRoomByAPieceOfTheName(String name) {

        return null;
    }

    @Override
    public MeetingRoom findMeetingRoomByArea(int area) {

        return null;
    }

    @Override
    public void deleteAll() {
        meetingRooms.clear();
    }

    public List<MeetingRoom> getMeetingRooms() {
        return new ArrayList<>(meetingRooms);
    }
}
