package org.dcsc.web.controller;

import org.dcsc.web.constants.ViewNames;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommitteeController {
    @RequestMapping(value = "/committee")
    public String committee() {
        return ViewNames.COMMITTEE;
    }
}
