package org.example.case4;

import org.example.case4.impl.BookingServiceImpl;

/**
 * User: bakka
 * Date: 27.04.14
 */
public class ServiceFactory<T extends BookingDate>{

    private Class<T> type;

    public ServiceFactory(Class<T> type) {
        this.type = type;
    }

    public BookingService createService(){
        BookingDate date = getInstance(type);
        return new BookingServiceImpl(date);
    }

    /**
     * Using reflection to instantiate an object of type T
     * @param tClass
     * @param <T>
     * @return
     */
    private <T> T getInstance(Class<T> tClass){
        try{
            return tClass.newInstance();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
