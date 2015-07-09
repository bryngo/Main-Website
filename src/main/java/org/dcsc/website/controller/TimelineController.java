package org.dcsc.website.controller;

import org.dcsc.event.Event;
import org.dcsc.event.ReadOnlyEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by tktong on 7/8/2015.
 */
@Controller
public class TimelineController {
    private static final int NUM_EVENTS_PER_PAGE = 5;

    @Autowired
    private ReadOnlyEventService readOnlyEventService;

    @RequestMapping(value = "/timeline")
    public String timeline(@RequestParam(value = "p", defaultValue = "0") int pageId, Model model) {
        Page<Event> page = readOnlyEventService.getPagedEvents(pageId, NUM_EVENTS_PER_PAGE);

        model.addAttribute("page", page);

        return "main/timeline";
    }
}
