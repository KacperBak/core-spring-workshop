package org.example.room.impl;

import org.example.room.Room;
import org.example.room.RoomRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * User: bakka
 */
@Component
public class HashMapRoomRepositoryImpl implements RoomRepository {

    private Map<String, Room> roomMap;

    public HashMapRoomRepositoryImpl() {
        this.roomMap = createInitialRooms();
    }

    private HashMap<String, Room> createInitialRooms(){

        HashMap<String, Room> result = new HashMap<String, Room>();
        Room room1 = new Room("101");
        Room room2 = new Room("102");
        Room room3 = new Room("103");
        result.put(room1.getRoomNumber(), room1);
        result.put(room2.getRoomNumber(), room2);
        result.put(room3.getRoomNumber(), room3);
        return result;
    }

    @Override
    public Room findRoomByNumber(String number) {
        return roomMap.get(number);
    }
}
