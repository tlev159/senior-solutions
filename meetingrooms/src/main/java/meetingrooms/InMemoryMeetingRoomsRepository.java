package meetingrooms;

import java.text.Collator;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collector;
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
    public List<String> findAllWithAreaReverseOrderByArea() {
        return  meetingRooms.stream()
                .sorted(Comparator.comparing(MeetingRoom::getArea).reversed())
                .map(MeetingRoom::concatWithArea).collect(Collectors.toList());
    }

    @Override
    public Optional<MeetingRoom> findMeetingRoomByName(String name) {
        return meetingRooms.stream()
                .filter(m -> m.getName().equals(name)).findFirst();
    }

    @Override
    public List<MeetingRoom> findMeetingRoomByAPieceOfTheName(String name) {
        return meetingRooms.stream()
                .filter(m -> m.getName().toLowerCase().contains(name.toLowerCase()))
                .sorted(Comparator.comparing(MeetingRoom::getName))
                .sorted(collator)
                .collect(Collectors.toList());
    }

    @Override
    public List<MeetingRoom> findMeetingRoomByArea(int area) {
        return meetingRooms.stream()
                .filter(m -> m.getArea() > area)
                .sorted(Comparator.comparing(MeetingRoom::getName))
                .sorted(collator)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAll() {
        meetingRooms.clear();
    }

    public List<MeetingRoom> getMeetingRooms() {
        return new ArrayList<>(meetingRooms);
    }
}
