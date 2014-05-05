package de.kacperbak.room;

/**
 * User: bakka
 */
public interface RoomRepository {

    Room findRoomByNumber(String number);
}
