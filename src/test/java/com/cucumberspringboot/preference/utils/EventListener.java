package com.cucumberspringboot.preference.utils;


import org.springframework.stereotype.Component;
import com.cucumberspringboot.preference.sourceProperties.*;

import java.util.ArrayList;
import java.util.List;

@Component
public class EventListener {
    public List<Inventory> eventData = new ArrayList<>();

    public void addEvent(Inventory data) {
        eventData.add(data);
    }
}
