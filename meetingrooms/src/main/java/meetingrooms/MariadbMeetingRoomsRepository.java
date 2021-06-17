package meetingrooms;

import org.flywaydb.core.Flyway;
import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class MariadbMeetingRoomsRepository implements MeetingRoomsRepository {

    private JdbcTemplate jdbcTemplate;

    public MariadbMeetingRoomsRepository() {
        try {
            MariaDbDataSource dataSource;
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/meetingroom?useUnicode=true");
            dataSource.setUser("employees");
            dataSource.setPassword("employees");

            Flyway flyway = Flyway.configure().dataSource(dataSource).load();
            flyway.migrate();

            jdbcTemplate = new JdbcTemplate(dataSource);
        } catch (SQLException e) {
            throw new IllegalStateException("Can not create datasource", e);
        }

    }

    @Override
    public void save(MeetingRoom meetingRoom) {
        jdbcTemplate.update("INSERT INTO meetingroom(room_name, room_with, room_length) VALUES(?, ?, ?)", meetingRoom.getName(), meetingRoom.getWith(), meetingRoom.getLength());
    }

    @Override
    public List<String> findAllByName() {
        return jdbcTemplate.query("SELECT room_name FROM meetingroom ORDER BY room_name",
                (rs, i) -> rs.getString("room_name"));
    }

    @Override
    public List<String> findAllReverseOrder() {
        return jdbcTemplate.query("SELECT room_name FROM meetingroom ORDER BY room_name DESC",
                (rs, i) -> rs.getString("room_name"));
    }

    @Override
    public List<String> findAllWithAreaReverseOrderByArea() {
        return null;
    }

    @Override
    public Optional<MeetingRoom> findMeetingRoomByName(String name) {
        return null;
    }

    @Override
    public List<MeetingRoom> findMeetingRoomByAPieceOfTheName(String name) {
        return null;
    }

    @Override
    public List<MeetingRoom> findMeetingRoomByArea(int area) {
        return null;
    }

    @Override
    public void deleteAll() {
        jdbcTemplate.update("delete from meetingroom");
    }


}
